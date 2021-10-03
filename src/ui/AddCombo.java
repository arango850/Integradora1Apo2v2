package ui;

import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Platillo;

public class AddCombo  extends Stage{
	
	private TextField name;
	private TextField price;
	private TextField amount;
	private Button done;
	private Button back;
	
	public AddCombo() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Carta.fxml"));
            Parent parent = loader.load();
            name = (TextField) loader.getNamespace().get("name");
            price= (TextField) loader.getNamespace().get("price");
            amount= (TextField) loader.getNamespace().get("amount");

            done = (Button) loader.getNamespace().get("done");
            
            back= (Button) loader.getNamespace().get("back");
            
            
            

            Scene scene = new Scene(parent, 700, 500);
            setScene(scene);

            init();
            
            System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		// TODO Auto-generated method stub
		back.setOnAction(event->{
			Carta carta= new Carta();
			carta.show();
			this.close();
		});
		
		done.setOnAction(event->{
			String id= UUID.randomUUID().toString();
			String name1= name.getText();
			double price1=Double.parseDouble(price.getText());
			double amount1=Double.parseDouble(amount.getText());
			Platillo dish = new Platillo(id, name1, price1, amount1);
		});
	}
	

}
