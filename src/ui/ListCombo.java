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
import model.Platillo;
import model.Worker;

public class ListCombo extends Stage {
	private TableView<Platillo> table;
	private Button back;
	
	public ListCombo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListCombo.fxml"));
            Parent root = loader.load();

            table = (TableView) loader.getNamespace().get("table");
            back= (Button) loader.getNamespace().get("back");

            TableColumn<Platillo, String> nameColum = new TableColumn("Name");
            TableColumn<Platillo, String> idColum = new TableColumn("Id");
            TableColumn<Platillo, Double> priceColum = new TableColumn("Price");
            TableColumn<Platillo, Double> amountColum = new TableColumn("Amount");
            

            nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
            idColum.setCellValueFactory(new PropertyValueFactory<>("id"));
            priceColum.setCellValueFactory(new PropertyValueFactory<>("price"));
            amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));
            

            table.getColumns().addAll(nameColum, idColum, idColum, amountColum);
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
    		Carta carta= new Carta();
    		carta.show();
    		
    	});
    }

    private ObservableList<Platillo> getDataUser(){
        try {
            File file = new File("src\\docs\\platillos.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Platillo> list = (List<Platillo>) ois.readObject();
            ObservableList<Platillo> userData = FXCollections.observableList(list);


            return userData;
        } catch (IOException | ClassNotFoundException ex){

            return null;
        }
    }
}
