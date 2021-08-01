package cn.com.servlet.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {
	public static void main(String[]args){
		Socket s = null;
		BufferedReader br = null;
		PrintWriter out = null;
		Scanner sc = new Scanner(System.in);
		try {
			s = new Socket(InetAddress.getByName("127.0.0.1"),8888);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(),true);
			System.out.println("请输入要请求的文件路径:");
			String filePath = sc.nextLine();
			String request = "GET /"+filePath+" HTTP/1.0\r\nHOST: 127.0.0.1:8888\r\n\r\n";
			out.println(request);
			String line = null;
			while((line = br.readLine())!=null) {
				if(line.matches("^\\s*$")) {
					break;
				}
				System.out.println(line);
			}
			System.out.println("--------------------------------------");
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
