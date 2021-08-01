package cn.com.servlet.http;

import java.io.BufferedReader;
import java.io.IOException;

class HttpServletRequestImpl implements HttpServletRequest {
	private BufferedReader br;
	private String head;
	private String heads;
	public HttpServletRequestImpl(BufferedReader br) throws IOException {
		this.br = br;
		initHead();
	}
	private void initHead() throws IOException {
		// TODO Auto-generated method stub
		this.head = br.readLine();
		String line = null;
		heads = head +"\r\n";
		while((line = br.readLine()) != null) {
			if(line.matches("^\\s*$")) {
				break;
			}
			heads += line + "\r\n";
		}
	}
	@Override
	public String getHead() {
		// TODO Auto-generated method stub
		return this.head;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return this.head.split(" ")[0];
	}

	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		return this.head.split(" ")[1];
	}

	@Override
	public String getProctorl() {
		// TODO Auto-generated method stub
		return this.head.split(" ")[2];
	}

}
