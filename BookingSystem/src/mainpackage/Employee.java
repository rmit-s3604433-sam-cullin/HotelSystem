package mainpackage;

import java.util.Scanner;

public class Employee {
	
	
	private String ID, name, address, number;
	
	public Employee() {
		
	}
	public Employee(String ID, String name, String address, String number) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public String getID() { return ID; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public String getNumber() { return number; }
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString(){
		return ID + "," + name +  "," + address + "," + number;
	}

}
