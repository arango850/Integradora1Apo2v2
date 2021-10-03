package model;

import java.io.Serializable;

public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private double amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Ingredient(String name, double amount) {
		
		this.name = name;
		this.amount = amount;
	}
	public Ingredient() {
		
		// TODO Auto-generated constructor stub
	}
	public void decreAmount(double dAmount)
	{
		this.amount -= dAmount;
	}
	
	public void increAmount(double dAmount)
	{
		this.amount += dAmount;
	}
	
	
	
	
}
