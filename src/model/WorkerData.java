package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkerData implements Serializable {

	private static final long serialVersionUID = 1L;
	private ObservableList<Worker> worker;
	public WorkerData() {
		setWorker(FXCollections.observableArrayList());
	}
	public ObservableList<Worker> getWorker() {
		return worker;
	}
	public void setWorker(ObservableList<Worker> worker) {
		this.worker = worker;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean confirmPass(String name, String pass) {
		boolean equals = false;
        int passwordEmployeePosition = buscarNombre(name);

        if(pass.equals(worker.get(passwordEmployeePosition).getPassword())){
            equals = true;
        }

        return equals;
	}
	private int buscarNombre(String name) {
		// TODO Auto-generated method stub
		 int start = 0;
	        int end = worker.size()-1;

	        while(start<=end){
	            int half = (start+end)/2;

	            if(worker.get(half).getName().compareTo(name) == 0){
	                return half;
	            } else if(name.compareTo(worker.get(half).getName()) < 0){
	                end = half-1;
	            } else if(name.compareTo(worker.get(half).getName()) > 0){
	                start = half+1;
	            }
	            System.out.println(half);
	        }

	        return -1;
	}
	public void changePassword(String name, String pass){

        worker.get(buscarNombre(name)).setPassword(pass);
        saveWoker();
    }
	
	public void saveWoker(){
        try {
            File file = new File("src\\docs\\workers.txt");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(new ArrayList<Worker>(((WorkerData) worker).getWorker()));
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	
	
}
