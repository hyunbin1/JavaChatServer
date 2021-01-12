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
//	Ŭ���̾�Ʈ�κ��� �޼����� ���� �޴� �޼ҵ��Դϴ�.
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				//���� ���� ó��
				try {
					while(true) {
						//�������޹ޱ�
						InputStream in = socket.getInputStream();
						// �ѹ��� 512����Ʈ��ŭ ���޹ޱⰡ��
						byte[] buffer = new byte[512];
						//������ Ŭ���̾�Ʈ���� ������ �޾Ƽ� buffer�� ����ش�.
						int length = in.read(buffer);
						// �޼����� �о���϶� ������ �߻��ߴٸ� �����޼��� ���
						while(length == -1) throw new IOException();
						System.out.println("[�޼��� ���� ����] " 
						// ip�ּ� ���
						+ socket.getRemoteSocketAddress() 
						// thread �̸��� ���
						+ ": " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for (Client client : Main.clients) {
							// Ŭ���̾�Ʈ�� �ٸ� Ŭ���̾�Ʈ���� ������ �ְ� ����
							client.send(message);
						}
					}
				} catch(Exception e) {
					//���� ����
					try {
						System.out.println("[�޼��� ���� ����] "
								// IP�ּ� ���
								+ socket.getRemoteSocketAddress() 
								// thread �̸��� ���
								+ ": " + Thread.currentThread().getName());
					} catch (Exception e2){
					e.printStackTrace();
					}
				}
				
			}
		};
		// ������� �ϳ��� thread�� main.threadPool�� �����ֱ�
		Main.threadPool.submit(thread);
	}
// Ŭ���̾�Ʈ�κ��� �޼����� �����ϴ� �޼��� �Դϴ�.
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
