package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import mainpackage.Employee;


public class AddEmployee {

	final static Scanner scan = new Scanner(System.in);
	
	public void addEmployeeMenu(){
		
		String ID = "", name = "", address = "", number = "", age = "", position = "";
		Employee nE = new Employee(ID,name,address,number,age,position);
	
		while(true){
			if(nE.getID().equals("")){
				System.out.println("\nPlease enter ID: ");
				ID = scan.nextLine();
				nE.setID(ID);
			}
			else{
				break;
			}	
		}	
		while(true){
			if(nE.getName().equals("")){
				System.out.println("\nPlease enter Name: ");
				name = scan.nextLine();	
				nE.setName(name);
			}
			else{
				break;
			}
		}	
		while(true){
			if(nE.getAddress().equals("")){
				System.out.println("\nPlease enter Address: ");
				address = scan.nextLine();
				nE.setAddress(address);
			}
			else {
				break;
			}
		}	
		while(true){
			if(nE.getNumber().equals("")){
				System.out.println("\nPlease enter mobile Number: ");
				number = scan.nextLine();
				nE.setNumber(number);
			}
			else {
				break;
			}
		}		
		addEmployee(nE);		
	}
	
	public void addEmployee(Employee nE){		
		Connection con = null;
		Statement statement = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO employee values('e"+nE.getID()+"', '"+nE.getName()+"', '"+nE.getAddress()+"', '"+nE.getNumber()+"')");			
			System.out.println("\nSuccessfully added new employee to system!\n");			
		} catch (Exception e) {		
			System.err.println(e);			
		}finally {		
			if (statement != null) {			
		        try {	        	
		            statement.close();
		            System.out.println("add employee statement closed");	            
		        } catch (SQLException e) { /* ignored */}	        
		    }		
		    if (con != null) {
		        try {
		            con.close();
		            System.out.println("add employee con closed");
		        } catch (SQLException e) { /* ignored */}
		    }	    
		}	
	}
}
