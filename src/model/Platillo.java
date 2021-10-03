package model;

public class Platillo {
	private String id;
	private String name;
	private double price;
	private double quantity;
	
	
	Ingredient ingredientes;
	
	
	public Platillo(String id, String name, double price, double quantity) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	public Ingredient getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Ingredient ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	

}
