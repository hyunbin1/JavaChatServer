package application;
	
import java.net.ServerSocket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	// 사용자들이 접속했을때 효과적으로 thread를 관리
	public static ExecutorService threadPool;
	//쉽게 사용할 수 있는 배열
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드 입니다. 
	public void startServer(String IP, int port) {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
