package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OlimpicAlgorithmsGUI oagui = new OlimpicAlgorithmsGUI();
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("menu.fxml"));
		fxmll.setController(oagui);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Olimpic Alghoritms");
		primaryStage.show();
	}
	
	public Main() {}
}
