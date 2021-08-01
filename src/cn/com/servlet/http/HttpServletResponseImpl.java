package cn.com.servlet.http;

import java.io.PrintWriter;

class HttpServletResponseImpl implements HttpServletResponse {
	private PrintWriter out;
	private String stat;
	private HttpServletRequest request;
	public HttpServletResponseImpl(PrintWriter out, String stat, HttpServletRequest request) {
		this.out = out;
		this.stat = stat;
		this.request = request;
		sendResponse();
	}

	private void sendResponse() {
		// TODO Auto-generated method stub
		out.println(request.getProctorl()+" "+stat+" OK\r\ncontent-type: text/html;\r\n\r\n");
	}
	@Override
	public PrintWriter getWriter() {
		// TODO Auto-generated method stub
		return this.out;
	}
	
}
