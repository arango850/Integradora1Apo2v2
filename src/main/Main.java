package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.Login;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Login login= new Login();
		login.show();
	}

}
