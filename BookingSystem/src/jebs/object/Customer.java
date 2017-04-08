package jebs.object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer extends Person {
	final static Scanner scan = new Scanner(System.in);
	public Customer(){
		
	}
	public Customer(String ID, String name, String password, String address, String number) {
		super(ID, name, password, address, number);
	}
	
	public void createBooking() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void setID(String ID) { //can't have duplicates
		if(ID.matches("[0-9]{3}")) {
			ID.trim();
			this.ID = ID;
		} else {
			System.out.println("Invalid ID number");
			System.out.println("getID()= " + getID());
		}			
	}
	
	@Override
	public void setName(String name) {
		if(name.matches("[a-zA-Z ]{2,30}")) {	
			this.name = name;		
		} else {
			System.out.println("Invalid name");			
		}
	}
	
	@Override
	public void setPassword(String password) {	
		if(password.matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}")){
			this.password = password;			
		} else {
			System.out.println("Invalid Password");		
		}			
	}
	
	@Override
	public void setAddress(String address) {
		if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
			this.address = address;	
		} else {
			System.out.println("Invalid Address");		
		}			
	}
	
	@Override
	public void setNumber(String number) {
		if(number.matches("[0-9]{10}")){
			number.trim();
			this.number = number;	
		} else {
			System.out.println("Invalid Number");		
		}
	}

	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
	
	@Override
	public void addCustomer(Person nC){
		Connection con = null;
		Statement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO customer values('c" + nC.getID() + "', '" + nC.getName() + "', '" 
					+ nC.getPassword() + "', '" + nC.getAddress() + "', '0" + nC.getNumber() + "')");
			System.out.println("\nRegistration Successful!");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if(statement != null) {
				try {
					statement.close();
					System.out.println("id state closed");
				} catch (SQLException e) { }
			}
		}
		if(con != null) {
			try {
				con.close();
				System.out.println("id con closed");
			} catch (SQLException e) { }
		}
	}

}
