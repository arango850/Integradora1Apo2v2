package model;

import java.io.Serializable;

public class Worker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	private String date;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Worker() {
		
		// TODO Auto-generated constructor stub
	}
	public Worker(String name, String id, String date, String password) {
		
		this.name = name;
		this.id = id;
		this.date = date;
		this.password = password;
	}
	
	
	

}
