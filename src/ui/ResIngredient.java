package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Ingredient;
import model.IngredientData;

public class ResIngredient extends Stage  {

	private Button done;
	private Button back;
	private TextField name;
	private TextField newAmount;
	
	private IngredientData ingredientData;
	public Ingredient ingredient;
	
	public ResIngredient() {
		 try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResIngredient.fxml"));
	            Parent root = loader.load();

	            name = (TextField) loader.getNamespace().get("name");

	            newAmount = (TextField) loader.getNamespace().get("newAmount");
	            
	            done = (Button) loader.getNamespace().get("done");
	            back = (Button) loader.getNamespace().get("back");
	            

	            

	            Scene scene = new Scene(root, 700, 500);
	            setScene(scene);

	            init();
	        } catch (Exception ex){
	            ex.printStackTrace();
	        
			
		}
	}

	public  void init() {
		// TODO Auto-generated method stub
		done.setOnAction(event->{
			String name1= name.getText();
			double newAmount1= Double.parseDouble(newAmount.getText());
			ingredient.decreAmount(newAmount1);
		});
		back.setOnAction(event->{
			Inventario inventario= new Inventario();
			inventario.show();
			this.show();
		});
	}
	
}
