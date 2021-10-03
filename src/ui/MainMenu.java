package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenu extends Stage{

	private Button outt;
	private Button personalBtn;
	private Button inventarioBtn;
	private Button combo;
	public MainMenu() {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("MainMenu.fxml"));
		
		Parent root= loader.load();
		Scene scene = new Scene(root, 700,400);
		setScene(scene);
		
		outt= (Button) loader.getNamespace().get("outt");
		personalBtn= (Button) loader.getNamespace().get("personalBtn");
		combo= (Button) loader.getNamespace().get("combo");
		init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init() {
		// TODO Auto-generated method stub
		outt.setOnAction(event->{
			Login login= new Login();
			login.show();
			this.close();
		});
		personalBtn.setOnAction(event->{
			Personal personal= new Personal();
			personal.show();
			this.close();
		});
		inventarioBtn.setOnAction(event->{
			Inventario inventario = new Inventario();
			inventario.show();
		});
		combo.setOnAction(event->{
			Carta carta = new Carta();
			carta.show();
			this.close();
		});
	}
			
}
