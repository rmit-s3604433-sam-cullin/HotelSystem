package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import mainpackage.Customer;
import mainpackage.Person;

public class AddCustomer {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void addCustomerMenu(){
		
		String ID = "", name = "", password = "", address = "", number = "";
		
		System.out.println("\nPlease enter ID: ");
		ID = scan.nextLine();
		String setID = addCustomerID(ID);
		
		System.out.println("\nPlease enter Name: ");
		name = scan.nextLine();	
		String setName = addCustomerName(name);
		
		System.out.println("\nPlease enter Password: ");
		password = scan.nextLine();
		String setPassword = addCustomerPassword(password);
		
		System.out.println("\nPlease enter Address: ");
		address = scan.nextLine();
		String setAddress = addCustomerAddress(address);
		
		System.out.println("\nPlease enter mobile Number: ");
		number = scan.nextLine();	
		String setNumber = addCustomerNumber(number);
		
		addCustomer(setID,setName,setPassword,setAddress,setNumber);
	}

	public String addCustomerID(String ID){		
		String setID = "";
		while(true) {
			if(ID.matches("[0-9]{3}")) {
				ID.trim();
				setID = ID;
				break;
			} else {
				System.out.println("Please enter a valid ID number");
				ID = scan.nextLine();
			}
		}	
		return setID;
	}
	
	public String addCustomerName(String name){	
		String setName = "";	
		while(true) {
			if(name.matches("[a-zA-Z ]{1,30}")) {	
				setName = name;
				break;
			} else {
				System.out.println("Please enter a valid name");
				name = scan.nextLine();
			}
		}
		return setName;
	}
		
	public String addCustomerPassword(String password){
		String setPassword = "";
		while(true) {	
			if(password.matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}")){
				setPassword = password;
				break;
			} else {
				System.out.println("Please enter a valid password");
				password = scan.nextLine();
			}
		}	
		return setPassword;
	}
	
	public String addCustomerAddress(String address){	
		String setAddress = "";
		while(true) {	
			if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
				setAddress = address;
				break;
			} else {
				System.out.println("Please enter a valid address");
				address = scan.nextLine();
			}
		}
		return setAddress;
	}
	
	public String addCustomerNumber(String number){	
		String setNumber = "";	
		while(true) {
			if(number.matches("[0-9]{10}")){
				setNumber = number;
				break;
			} else {
				System.out.println("Please enter mobile number");
				number = scan.nextLine();
			}
		}	
		return setNumber;
	}
	
	public void addCustomer(String ID, String name, String password, String address, String number) {	
		Person nC = new Customer(ID,name,password,address,number);
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			Statement statement = con.createStatement();	
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO customer values('c" + nC.getID() + "', '" + nC.getName() + "', '" + nC.getPassword() + "', '" + nC.getAddress() + "', '0" + nC.getNumber() + "')");
			System.out.println("\nRegistration Successful!");			
		} catch (Exception e) {		
			System.err.println(e);		
		}
	}	
}
