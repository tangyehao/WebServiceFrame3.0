package cn.com.servlet.http;

import java.io.IOException;

public class Start {
	public static void main(String[]args){
		try {
			new WebService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
