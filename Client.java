package application;

import java.net.Socket;

public class Client {
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
//	Ŭ���̾�Ʈ�κ��� �޼����� ���� �޴� �޼ҵ��Դϴ�.
	public void receive() {
		
	}
// Ŭ���̾�Ʈ�κ��� �޼����� �����ϴ� �޼��� �Դϴ�.
	public void send(String message) {
		
	}
}
