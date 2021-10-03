package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlatilloData {
	private ObservableList<Platillo> platillo;
	
	public PlatilloData() {
		platillo = FXCollections.observableArrayList();
	}
	public ObservableList<Platillo> getData() {
		return platillo;
	}
}
