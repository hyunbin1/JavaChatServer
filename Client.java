package application;

import java.net.Socket;

public class Client {
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
//	클라이언트로부터 메세지를 전달 받는 메소드입니다.
	public void receive() {
		
	}
// 클라이언트로부터 메세지를 전송하는 메서드 입니다.
	public void send(String message) {
		
	}
}
