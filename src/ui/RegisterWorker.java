package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Worker;
import model.WorkerData;

public class RegisterWorker extends Stage{

	private TextField name;
	private TextField id;
	private PasswordField pass;
	private DatePicker date;
	private Button done;
	private Button back;
	
	private WorkerData workerdataR;
	
	public RegisterWorker() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterWorker.fxml"));
            Parent root = loader.load();

            name= (TextField) loader.getNamespace().get("name");
            id = (TextField) loader.getNamespace().get("id");
            pass = (PasswordField) loader.getNamespace().get("pass");
            date = (DatePicker) loader.getNamespace().get("date");
            done = (Button) loader.getNamespace().get("done");
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
            Personal login = new Personal();
            login.show();

            this.close();
        });

        done.setOnAction(e -> {
            String username = name.getText();
            String password = pass.getText();
            String id1= id.getText();
            String birthday = date.getValue().toString();

            Worker user = new Worker(username, password, id1,birthday);

            workerdataR.setWorker(getDataUser());
           if(workerdataR.getWorker() != null) {
        	   workerdataR.getWorker().add(user); 
           }
            

            saveStudent(workerdataR);

            MainMenu list = new MainMenu();
            list.show();

            this.close();
        });

      
    }
 

    

    

    private void saveStudent(WorkerData user){
        try {
            File file = new File("src\\docs\\workers.txt");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(new ArrayList<Worker>(user.getWorker()));
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
