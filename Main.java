package application;
	
import java.net.ServerSocket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	// 사용자들이 접속했을때 효과적으로 thread를 관리
	public static ExecutorService threadPool;
	//쉽게 사용할 수 있는 배열
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드 입니다. 
	public void startServer(String IP, int port) {
		
	}
	
	// 서버 작동을 중지시키는 메소드입니다. 
	public void stopServer() {
		
	}
	
	// UI를 생성하고, 실질적으로 프로그램을 동작시키는 메소드입니다. 
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	// 프로그램의 진입점입니다. 
	public static void main(String[] args) {
		launch(args);
	}
}
