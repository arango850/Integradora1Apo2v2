package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Worker;
import model.WorkerData;

public class Register extends Stage {

	private TextField adminTF;
	private TextField adminIDTF;
	private PasswordField adminPassTF;
	private DatePicker adminDate;
	private Button adminDone;
	private Button back;
	
	private WorkerData workerdataR;
	
	public Register() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root = loader.load();

            adminTF = (TextField) loader.getNamespace().get("adminTF");

            adminIDTF = (TextField) loader.getNamespace().get("adminIDTF");
            adminPassTF = (PasswordField) loader.getNamespace().get("adminPassTF");
            adminDate = (DatePicker) loader.getNamespace().get("adminDate");
            adminDone = (Button) loader.getNamespace().get("adminDone");
            back = (Button) loader.getNamespace().get("back");
            

            workerdataR = new WorkerData();

            Scene scene = new Scene(root, 700, 500);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void init() {
        back.setOnAction(e -> {
            Login login = new Login();
            login.show();

            this.close();
        });

        adminDone.setOnAction(e -> {
            String username = adminTF.getText();
            String password = adminPassTF.getText();
            String id= adminIDTF.getText();
            String birthday = adminDate.getValue().toString();

            Worker user = new Worker(username, password, id,birthday);

            workerdataR.setWorker(getDataUser());
           if(workerdataR.getWorker() != null) {
        	   workerdataR.getWorker().add(user); 
           }
            

            workerdataR.saveWoker();

            MainMenu list = new MainMenu();
            list.show();

            this.close();
        });

      
    }
 

    

    

    

    private ObservableList<Worker> getDataUser(){
        try {
            File file = new File("students.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Worker> list = (List<Worker>) ois.readObject();
            ObservableList<Worker> userData = FXCollections.observableList(list);


            return userData;
        } catch (IOException | ClassNotFoundException ex){

            return null;
        }
    }
	
	}

