package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
//	클라이언트로부터 메세지를 전달 받는 메소드입니다.
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				//예외 오류 처리
				try {
					while(true) {
						//내용전달받기
						InputStream in = socket.getInputStream();
						// 한번에 512바이트만큼 전달받기가능
						byte[] buffer = new byte[512];
						//실제로 클라이언트에게 내용을 받아서 buffer에 담아준다.
						int length = in.read(buffer);
						// 메세지를 읽어들일때 오류가 발생했다면 오류메세지 출력
						while(length == -1) throw new IOException();
						System.out.println("[메세지 수신 성공] " 
						// ip주소 출력
						+ socket.getRemoteSocketAddress() 
						// thread 이름값 출력
						+ ": " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for (Client client : Main.clients) {
							// 클라이언트가 다른 클라이언트에게 보낼수 있게 해줌
							client.send(message);
						}
					}
				} catch(Exception e) {
					//오류 선별
					try {
						System.out.println("[메세지 수신 오류] "
								// IP주소 출력
								+ socket.getRemoteSocketAddress() 
								// thread 이름값 출력
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e2){
					e.printStackTrace();
					}
				}
				
			}
		};
		// 만들어진 하나의 thread를 main.threadPool에 보내주기
		Main.threadPool.submit(thread);
	}
// 클라이언트로부터 메세지를 전송하는 메서드 입니다.
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
				}
			}
		};
	}
}
