package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.WorkerData;

public class CambiarPass extends Stage  {

	private TextField name;
	private PasswordField oldpass;
	private PasswordField newpass;
	private Button back;
	private Button done;
	
	private WorkerData workerdata;
	
	public CambiarPass() {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("CambiarPass.fmxl"));
		Parent root= loader.load();
		Scene scene= new Scene(root, 700,500);
		setScene(scene);
		
		name= (TextField) loader.getNamespace().get("name");
		oldpass= (PasswordField) loader.getNamespace().get("oldpass");
		newpass= (PasswordField) loader.getNamespace().get("newpass");
		back= (Button) loader.getNamespace().get("back");
		done= (Button) loader.getNamespace().get("done");
		
		init();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public  void init() {
		// TODO Auto-generated method stub
		done.setOnAction(event->{
			cambiarContra();
		});
	}

	public void cambiarContra() {
		// TODO Auto-generated method stub
		String name1= name.getText();
		String oldPass= oldpass.getText();
		String newPass= newpass.getText();
		if(workerdata.confirmPass(name1, oldPass)) {
			workerdata.changePassword(name1, newPass);
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Information Dialog");
             alert.setHeaderText("The username or password is wrong");
             alert.setContentText(" ");

             alert.showAndWait();
		}
	}
}
