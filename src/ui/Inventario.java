package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Inventario extends Stage {

	private Button back;
	private Button add;
	private Button sum;
	private Button res;
	
	public Inventario() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventario.fxml"));
            Parent parent = loader.load();


            back = (Button) loader.getNamespace().get("back");
            add= (Button) loader.getNamespace().get("add");
            sum= (Button) loader.getNamespace().get("sum");
            res= (Button) loader.getNamespace().get("res");
            
            

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
			MainMenu mainMenu= new MainMenu();
			mainMenu.show();
			this.close();
		});
		add.setOnAction(event->{
			AddIngredient addIngredient= new AddIngredient();
			addIngredient.show();
			this.close();
		});
		sum.setOnAction(event->{
			SumIngredient sumIngredient= new SumIngredient();
			sumIngredient.show();
			this.close();
		});
		res.setOnAction(event->{
			ResIngredient resIngredient = new ResIngredient();
			resIngredient.show();
			this.close();
		});
	}
}
