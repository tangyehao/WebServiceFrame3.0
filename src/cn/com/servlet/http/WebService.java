package cn.com.servlet.http;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebService {
	private Socket s;
	private ServerSocket ss;
	private boolean bool;

	public void setBool(boolean bool){
		this.bool = bool;
	}

	public WebService() throws IOException {
		ss = new ServerSocket(8888);
		setBool(true);
		init();
	}

	private void init() throws IOException {
		// TODO Auto-generated method stub
		while(bool) {
			s = ss.accept();
			new SessionThread(s).start();
		}
	}
	
}
