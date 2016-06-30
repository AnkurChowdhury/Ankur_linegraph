package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	//Entery point of javafx application
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/mainFxml.fxml")); // call .fxml file into javafx api
			Scene scene = new Scene(root,600,600);	// console of Javafx	
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// End of javafx application
	//Java Entery point
	public static void main(String[] args) {
		launch(args);
		
	}
}
