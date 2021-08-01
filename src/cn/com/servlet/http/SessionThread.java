package cn.com.servlet.http;

import java.io.*;
import java.net.Socket;
import java.util.Map;

class SessionThread extends Thread{
	private Socket s;
	private BufferedReader br;
	private BufferedReader brFile;
	private PrintWriter out;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static Map<String,String> config;
   /*
    * request: 
    * GET/POST /uri HTTP/1.0(HTTP1.1)
    * HOST: ip/域名/计算机名:端口号
    * (此行必须有，为空白行)
    * response:
    * HTTP/1.0(HTTP/1.1) 状态码(200正常 404文件不存在 500服务器报错 一定为三位长整数) OK
    * content-type:(若服务器发送的网页文件)text/html; charest=XXX(可省)
    *
    */
	static{
	   try {
		   config = Load.loadConfig();
	   } catch (Throwable throwable) {
		   throwable.printStackTrace();
	   }
   }
	
	public SessionThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(),true);
	}
	@Override
	public void run() {
		try {
			request = new HttpServletRequestImpl(br);
			if(request.getHead().split(" ").length != 3) {
				return;
			}
			if(!(request.getMethod().equalsIgnoreCase("get") || request.getMethod().equalsIgnoreCase("post"))){
				return;
			}
			if(!request.getRequestURI().startsWith("/")) {
				return;
			}
			if(!(request.getProctorl().equalsIgnoreCase("http/1.0") || request.getProctorl().equalsIgnoreCase("http/1.1"))) {
				return;
			}

			String filePath = request.getRequestURI().substring(1);
			System.out.println(s.getInetAddress().getHostAddress()+"请求了:"+filePath);
			File f = new File(filePath);
			if(request.getRequestURI().toLowerCase().endsWith(".html") || request.getRequestURI().toLowerCase().endsWith(".htm")){
				if(f.isFile()) {
				response = new HttpServletResponseImpl(out,"200",request);
				brFile = new BufferedReader(new FileReader(f));
				String line = null;
				while((line = brFile.readLine()) != null) {
					out.println(line);
				}
			}else {
				response = new HttpServletResponseImpl(out,"404",request);
			}
		}else if(request.getRequestURI().toLowerCase().endsWith(".jsp")){
			
		}else {
				String uri = request.getRequestURI();
				String servletClass = config.get(uri);
				if(servletClass != null){
					response = new HttpServletResponseImpl(out,"200",request);
					Class c = null;
					c = Class.forName(servletClass);
					HttpServlet servlet = (HttpServlet)c.newInstance();
					servlet.init();
					servlet.service(request,response);
					servlet.destroy();
				}
			}
			
	} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response = new HttpServletResponseImpl(out,"500",request);
	} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
				if(brFile!=null){
					try {
						brFile.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(br!=null){
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(out!=null){
					out.close(); 
				}
				if(request.getProctorl().equalsIgnoreCase("http/1.0")){
					if(s!=null){
					try {
						s.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
