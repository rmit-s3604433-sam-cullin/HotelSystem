package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddEmployee {

	final static Scanner scan = new Scanner(System.in);
	
	public void addEmployeeMenu(){
		
		String ID = "", name = "", address = "", number = "";

		System.out.println("\nPlease enter new employee ID: ");	
		ID = scan.nextLine();
		
		System.out.println("\nPlease enter new employee name: ");
		name = scan.nextLine();
		
		System.out.println("\nPlease enter new employee address: ");	
		address = scan.nextLine();
		
		System.out.println("\nPlease enter new employee number: ");	
		number = scan.nextLine();

		addEmployee(ID,name,address,number);
	}
	
	public String addEmployeeID(String ID){
		
		String setID = "";
		
		if(Pattern.matches("[0-9]{1,3}", ID) == true){
			
			ID.trim();
			setID = ID;

		}
		else{
			
			boolean idmatch = false;
			
			while(idmatch == false){
			
				if(Pattern.matches("[0-9]{1,3}", ID) == true){
					
					ID.trim();
					setID = ID;
					idmatch = true;
					
				}
				else{
					
					System.out.println("Please enter a valid ID number");
					ID = scan.next();
					
				}
			}
		}
		
		return setID;
	}
	
	public String addEmployeeName(String name){
		
		String setName = "";
		
		if(Pattern.matches("[a-zA-z]{1,20}\\s[a-zA-z]{1,20}",name) == true){
			
			setName = name;
			
		}
		else{
			
			boolean namematch = false;
			
			while(namematch == false){
				
				if(Pattern.matches("[a-zA-z]{1,20}\\s[a-zA-z]{1,20}",name) == true){
					
					setName = name;
					namematch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid name: ");
					name = scan.nextLine();
					
				}
			}			
		}

		return setName;
	}
	
	public String addEmployeeAddress(String address){
		
		String setAddress = "";
		
		if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){
			
			setAddress = address;
			
		}
		else{
			
			boolean addressmatch = false;
			
			while(addressmatch == false){
				
				if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){
					
					setAddress = address;
					addressmatch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid address: ");
					address = scan.nextLine();
					
				}
			}
			
		}
		
		return setAddress;
	}
	
	public String addEmployeeNumber(String number){
		
		String setNumber = "";
		
		if(Pattern.matches("[0-9]{10}", number) == true){
			
			setNumber = number;
			
		}
		else{
			
			boolean numbermatch = false;
			
			while(numbermatch == false){
				
				if(Pattern.matches("[0-9]{10}", number) == true){
					
					setNumber = number;
					numbermatch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid number: ");
					number = scan.nextLine();
					
				}
			}
			
		}
		
		return setNumber;
	}
	
	public void addEmployee(String ID, String name, String address, String number){
		
		Connection con = null;
		Statement statement = null;
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			System.out.println("connection made for adding employee");
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO employee values('e"+ID+"', '"+name+"', '"+address+"', '"+number+"')");
			
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
