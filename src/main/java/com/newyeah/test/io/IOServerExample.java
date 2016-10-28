package com.newyeah.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOServerExample {
	ExecutorService mExecutorService = null;
	ServerSocket server ;
	public void start(){
		try{
			System.out.println("����������...");
			server = new ServerSocket(1234) ;
			mExecutorService = Executors.newCachedThreadPool(); 
			while(true) {
				Socket socket = server.accept() ;
				System.out.println("�ӵ�����:"+socket);
				mExecutorService.execute(new Service(socket));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	public static void main(String[] args) {
		IOServerExample server = new IOServerExample() ;
		server.start();
	}
	
	class Service implements Runnable{
		private Socket socket;  
        private BufferedReader in = null;
		public void run() {
			System.out.println("��������:"+socket);
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String content = "" ;
				while((content=in.readLine()) != null){
					System.out.println("���յ��ı����ǣ�"+content);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
        public Service(Socket socket){
        	this.socket = socket ;
        }
	}
}
