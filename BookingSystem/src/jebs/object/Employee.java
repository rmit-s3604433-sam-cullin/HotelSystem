package jebs.object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	final static Scanner scan = new Scanner(System.in);
	private String ID, name, address, number;
	public Employee(){
		
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
	
	//Input validation for adding new employee data into the system
	public void setID(String ID) {
		if(ID.matches("[0-9]{3}")) {
			ID.trim();
			this.ID = ID;	
		} else {
			System.out.println("Invalid ID number");		
		}	
	}
	public void setName(String name) {
		if(name.matches("[a-zA-Z ]{2,30}")) {	
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
	}
	public void setAddress(String address) {	
		if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
			this.address = address;				
		} else {
			System.out.println("Invalid Address");			
		}
			
	}
	public void setNumber(String number) {
		if(number.matches("[0-9]{10}")){
			this.number = number;
		} else {
			System.out.println("Invalid Number");
		}
	}
	
	public String toString(){
		return ID + "," + name +  "," + address + "," + number;
	}
	
	//Function to add new employee into the system database
	public void addEmployee(Employee nE){
		Connection con = null;
		Statement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO employee values('e" + nE.getID() + "', '" + nE.getName() + "', '" 
					+ nE.getAddress() + "', '0" + nE.getNumber() + "')");
			System.out.println("\nRegistration Successful!");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) { }
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) { }
		}
	}
}
