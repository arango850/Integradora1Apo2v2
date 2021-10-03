package ui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Worker;
import model.WorkerData;

public class Login extends Stage {

	private TextField name;
	private PasswordField pass;
	private Button done;
	private Button register;
	
	private WorkerData workerData;
	
	public Login() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent parent = loader.load();


            name = (TextField) loader.getNamespace().get("name");
            pass = (PasswordField) loader.getNamespace().get("pass");

            done = (Button) loader.getNamespace().get("done");
            register = (Button) loader.getNamespace().get("register");
            

            Scene scene = new Scene(parent, 600, 400);
            setScene(scene);

            init();
            
            System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void init() {
		register.setOnAction(event ->{
			doSignUpBtn();
    	});
    	
		done.setOnAction(event ->{
			doLogInBtn();
    	});
	}
	private void doLogInBtn() {
		String userName = name.getText();
		String password = pass.getText();
		
		try {
            File file = new File("src\\docs\\workers.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Worker> users = (ArrayList<Worker>) ois.readObject();


            if(usernameVerification(users)){
                MainMenu mainMenu = new MainMenu();
                mainMenu.show();

                this.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("The username or password is wrong");
                alert.setContentText("I have a great message for you!");

                alert.showAndWait();
            }
        } catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
		 boolean value = false;

	       
		if(value) {
			MainMenu mainMenu = new MainMenu();
			mainMenu.show();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Log in incorrect");
			alert.setContentText("The username and password given are incorrect");
			alert.showAndWait();
		}
	}
	public void doSignUpBtn() {
		Register register = new Register();
		register.show();
		this.close();
	}
	private boolean usernameVerification(ArrayList<Worker> users){
        boolean value = false;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equals(name.getText())){
                if(users.get(i).getPassword().equals(pass.getText())){
                    value = true;
                }
            }
        }

        return value;
    }
	
	
}
