package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.IngredientData;
import model.WorkerData;

public class AddIngredient extends Stage {

	private TextField name;
	private TextField amount;
	private Button done;
	private Button back;
	
	private IngredientData ingredientData;
	
	public AddIngredient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIngredient.fxml"));
            Parent root = loader.load();

            name = (TextField) loader.getNamespace().get("name");

            amount = (TextField) loader.getNamespace().get("amount");
            
            done = (Button) loader.getNamespace().get("done");
            back = (Button) loader.getNamespace().get("back");
            

            

            Scene scene = new Scene(root, 700, 500);
            setScene(scene);

            init();
        } catch (Exception ex){
            ex.printStackTrace();
        
		
	}
	
}

	public void init() {
		// TODO Auto-generated method stub
		done.setOnAction(event->{
			String name1= name.getText();
			double amount1= Double.parseDouble(amount.getText());
			ingredientData.addIngredient(name1, amount1);
		});
		back.setOnAction(event->{
			Inventario inventario = new Inventario();
			inventario.show();
			this.close();
		});
	}
}
