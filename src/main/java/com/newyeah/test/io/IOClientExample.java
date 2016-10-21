package com.newyeah.test.io;

import java.io.PrintWriter;
import java.net.Socket;

public class IOClientExample {
	public void send(String msg) {
		try {
			Socket socket = new Socket("127.0.0.1",1234) ;
			PrintWriter print = new PrintWriter(socket.getOutputStream(),true) ;
			System.out.println("发送的内容报文为："+msg);
			print.println(msg);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public static void main(String[] args) {
		IOClientExample client = new IOClientExample() ;
		client.send("helloworld世界你好！");
	}
}
