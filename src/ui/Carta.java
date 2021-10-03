package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Carta extends Stage {

	private Button add;
	private Button list;
	private Button back;
	
	public Carta() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Carta.fxml"));
            Parent parent = loader.load();


            list = (Button) loader.getNamespace().get("list");
            add= (Button) loader.getNamespace().get("add");
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
			MainMenu mainMenu = new MainMenu();
			mainMenu.show();
			this.close();
		});
		add.setOnAction(event->{
			AddCombo addCombo= new AddCombo();
			addCombo.show();
			this.close();
		});
		list.setOnAction(event->{
			ListCombo listCombo= new ListCombo();
			listCombo.show();
			this.close();
		});
	}
}
