package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Worker;

public class WorkerList extends Stage{
	
	private TableView<Worker> table;
	private Button back;
	
	public WorkerList() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkerList.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");
            back= (Button) loader.getNamespace().get("back");

            TableColumn<Worker, String> usernameColum = new TableColumn("Name");
            TableColumn<Worker, String> idColum = new TableColumn("Id");
            TableColumn<Worker, String> passColum = new TableColumn("Password");
            TableColumn<Worker, String> birthdayColum = new TableColumn("Birthday");
            

            usernameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
            idColum.setCellValueFactory(new PropertyValueFactory<>("id"));
            passColum.setCellValueFactory(new PropertyValueFactory<>("pass"));
            birthdayColum.setCellValueFactory(new PropertyValueFactory<>("date"));
            

            table.getColumns().addAll(usernameColum, idColum, passColum, birthdayColum);
            table.setItems(getDataUser());

            Scene scene = new Scene(root, 400, 500);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void init() {
    	back.setOnAction(event->{
    		Personal personal= new Personal();
    		personal.show();
    		this.close();
    	});
    }

    private ObservableList<Worker> getDataUser(){
        try {
            File file = new File("src\\docs\\workers.txt");
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
