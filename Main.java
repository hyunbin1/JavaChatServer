package application;
	
import java.net.ServerSocket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	// ����ڵ��� ���������� ȿ�������� thread�� ����
	public static ExecutorService threadPool;
	//���� ����� �� �ִ� �迭
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// ������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ� �Դϴ�. 
	public void startServer(String IP, int port) {
		
	}
	
	// ���� �۵��� ������Ű�� �޼ҵ��Դϴ�. 
	public void stopServer() {
		
	}
	
	// UI�� �����ϰ�, ���������� ���α׷��� ���۽�Ű�� �޼ҵ��Դϴ�. 
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	// ���α׷��� �������Դϴ�. 
	public static void main(String[] args) {
		launch(args);
	}
}
