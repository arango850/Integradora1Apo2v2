package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Personal extends Stage {

	private Button back;
	private Button list;
	private Button add;
	private Button change;
	public Personal() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Personal.fxml"));
		Parent root= loader.load();
		Scene scene = new Scene(root, 700,500);
		setScene(scene);
		
		back= (Button) loader.getNamespace().get("back");
		list= (Button) loader.getNamespace().get("list");
		add= (Button) loader.getNamespace().get("add");
		change= (Button) loader.getNamespace().get("change");
		
			init();	
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init() {
		// TODO Auto-generated method stub
		back.setOnAction(event->{
			MainMenu mainMenu = new MainMenu();
			mainMenu.show();
			this.close();	
		});
		list.setOnAction(event->{
			WorkerList workerList= new WorkerList();
			workerList.show();
			this.close();
		});
		add.setOnAction(event->{
			RegisterWorker registerWorker= new RegisterWorker();
			registerWorker.show();
			this.close();
		});
		
		
	}
}
