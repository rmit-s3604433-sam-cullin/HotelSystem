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
		Person nC = new Customer(ID,name,password,address,number);
		scan.nextLine();
		
		while(true){
			if(nC.getID().equals("")){
				System.out.println("\nPlease enter ID: ");
				ID = scan.nextLine();
				nC.setID(ID);
			}
			else{
				System.out.println("IT WORKS!");
				break;
			}	
		}
		
		while(true){
			if(nC.getName().equals("")){
				System.out.println("\nPlease enter Name: ");
				name = scan.nextLine();	
				nC.setName(name);
			}
			else{
				break;
			}
		}
		
		while(true){
			if(nC.getPassword().equals("")){
				System.out.println("\nPlease enter Password: ");
				password = scan.nextLine();
				nC.setPassword(password);
			}
			else {
				break;
			}
		}
		
		while(true){
			if(nC.getAddress().equals("")){
				System.out.println("\nPlease enter Address: ");
				address = scan.nextLine();
				nC.setAddress(address);
			}
			else {
				break;
			}
		}
		
		while(true){
			if(nC.getNumber().equals("")){
				System.out.println("\nPlease enter mobile Number: ");
				number = scan.nextLine();
				nC.setNumber(number);
			}
			else {
				break;
			}
		}		
		addCustomer(nC);		
	}
	
	public void addCustomer(Person nC){
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			Statement statement = con.createStatement();
			
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO customer values('c" + nC.getID() + "', '" + nC.getName() + "', '" 
					+ nC.getPassword() + "', '" + nC.getAddress() + "', '0" + nC.getNumber() + "')");
			System.out.println("\nRegistration Successful!");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
