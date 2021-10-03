package model;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IngredientData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ObservableList<Ingredient> ingredients;
	
	public IngredientData() {
		ingredients = FXCollections.observableArrayList();
		
	}

	public ObservableList<Ingredient> getInventoryData() {
		return ingredients;
	}
	
	

	public void addIngredient(String name, double amount) {

		Ingredient newIngredient = new Ingredient(name, amount);
		ingredients.add(newIngredient);
	}
	
	public void removeIngredient(int ingIndex)
	{
		ingredients.remove(ingIndex);
	}
	
	public void decreIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).decreAmount(amount);
	}
	
	public void increIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).increAmount(amount);
	}
private static IngredientData instance = null;
	
	public static IngredientData getInstance() {
		if(instance == null) {
			instance = new IngredientData();
		}
		return instance;
	}
}
