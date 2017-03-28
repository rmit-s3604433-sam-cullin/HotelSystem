package views;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

import mainpackage.*;

public class Menu {
  
	final static Scanner scan = new Scanner(System.in);

	private String printMenu(){
		System.out.println("======================================");
		System.out.println("   John's Electrician Booking System");
		System.out.println("======================================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("======================================");
		System.out.print("Please Enter Your Choice: ");
		String i = scan.next();
		return i;
	}
	/* first method called here */
	public boolean systemMenu() throws IOException {

		boolean exit = false;
		do{
			String x = printMenu();
			switch(x){
				case("1"):
					login();
					break;
				case("2"):
					addCustomer();
					break;
				case("3"):
					System.out.println("\nThe system will exit now.");
					exit = true;
					break;
				default:
					System.out.println("\nInvalid input\n");
					break;
			}
		} while (!exit);
		
		return true;
	}
	
public void login() { //need to pass ID and password. Make it cleaner for JUnit
		
		String ID, password;
		boolean userDone = false, passDone = false;
		Connection con =null;
		Statement statement =null;
		ResultSet resultSet =null;
		
		do{
			System.out.println("\nPlease Enter User ID or 'exit'"); 
			ID = scan.next();
			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					statement = con.createStatement();
					
					resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							System.out.println("Admin found!");
							userDone = true;
							break;
						}
					}
					resultSet.close();
					if(!userDone) {
						resultSet = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet.next()) {
							if(ID.equals(resultSet.getString("custid"))) { 
								System.out.println("User found!");
								userDone = true;
								break;
							}
						}
						resultSet.close();
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					//Closing statements for the sql connection
					if (statement != null) {
				        try {
				            statement.close();
				            System.out.println("id state closed");
				        } catch (SQLException e) { System.out.println("id statment still open");}
				    }
				    if (con != null) {
				        try {
				            con.close();
				            System.out.println("id con closed");
				        } catch (SQLException e) { /* ignored */}
				    }  
				}
				if(!userDone) {
					System.out.println("No user found");
					/* remove break to replay user ID input instead of going back to main menu */
					break;
				}
					
			} else if(ID.equals("exit")) {
				System.out.println("You selected exit");
				break;
			} else {
				System.out.println("Input Invalid");
			}
			
		} while(!userDone);

		if(userDone && !passDone) {
			do {
			System.out.println("\nPlease enter user password or 'exit'");
			password = scan.next();
				if(password.equals("exit")){
					System.out.println("You selected exit");
					break;
				} else {
					
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						
						//owner password check
						resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
						while(resultSet.next()) {
							if(password.equals(resultSet.getString("password"))) {
								System.out.println("Password correct!");
								//moves to owner menu
								statement.close();
								con.close();
								ownerMenu();
								passDone = true;
							}
						}
						
						//customer password check
						resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
						while(resultSet.next()) {
							if(password.equals(resultSet.getString("password"))) { 
								System.out.println("Password correct!");
								//moves to customer menu
								statement.close();
								con.close();
								customerMenu();
								passDone = true;
							} else {
								System.out.println("Password incorrect");
							}
						}
					} catch (Exception e) {
						System.err.println(e);
					} finally {
						if(resultSet != null){
					    	try {
					    		resultSet.close();
					    		System.out.println("pass result closed");
					    	} catch (SQLException e){ /* ignored */ }
					    }
						if (statement != null) {
					        try {
					            statement.close();
					            System.out.println("pass stat closed");
					        } catch (SQLException e) { System.out.println("statement did not close");}
					    }
					    if (con != null) {
					        try {
					            con.close();
					            System.out.println("pass con closed");
					        } catch (SQLException e) { /* ignored */}
					    } 
					}
				}
			} while(!passDone);
		}
	}
	
	public void ownerMenu() throws IOException {
		
		boolean done = false;
		//Employee employee = null;
		
		while(!done) {
			System.out.println("======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. Add new employee");
			/* Ask Homy how he wants this recorded*/
			System.out.println("\n2. Add working time/dates for next month");
			System.out.println("\n3. Booking summary");
			System.out.println("\n4. Employeee availability");
			System.out.println("\n4. Logout");
			System.out.println("======================================");
			System.out.println("Please enter you choice: ");
			int choice = scan.nextInt();
			
			switch (choice) {
				case 1 : 
					addEmployee();
					break;
				case 4 :
					System.out.println("\n");
					BookingSystem.main(null);
					break;
			}
		}
	}
	
	public void customerMenu() throws FileNotFoundException, IOException {
		
		new BookingSystem();
		String choice ;
		do{
			System.out.println("\n======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. View available date & time");
			System.out.println("\n2. Logout");
			System.out.println("======================================");
			System.out.println("PLease enter you choice: ");
			choice = scan.next();
			
			switch(choice) {
				case ("1"):
					System.out.println("\nHello!");
					break;
				case ("2"):
					System.out.println("\n");
					BookingSystem.main(null);
					break;
				default:
					System.out.println("please enter valid input");
			}
		}while(!choice.equals("2"));
	}
	
	public void addCustomer() { //should make another class for this function
		
		String ID = "", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		scan.nextLine();
		
		System.out.println("\nPlease enter ID: ");
		ID = scan.nextLine();
		
		if(Pattern.matches("[c0-9]{2,4}", ID) == true){ //if id doesn't start with c and has less than or greater than 3 digits, please enter a correct id
			
			ID.trim();		
			nC.setID(ID);
			
		}
		else{
			
			boolean idmatch = false;
			
			while(idmatch == false){
			
				if(Pattern.matches("[c0-9]{2,4}", ID) == true){
					
					nC.setID(ID);
					idmatch = true;
				
				}
				else{
					
					System.out.println("Please enter a valid ID number");				
					ID = scan.nextLine();
					
				}
			}
		}
		
		System.out.println("ID:" + nC.getID());
			
		System.out.println("\nPlease enter Name: ");
		name = scan.nextLine();	
		
		if(Pattern.matches("[a-zA-z]{1,20}\\s[a-zA-z]{1,20}",name) == true){ //if name must contain only letters and must be name.length < 20
			
			nC.setName(name);
			
		}
		else{
			
			boolean namematch = false;
			
			while(namematch == false){
				
				if(Pattern.matches("[a-zA-z]{1,20}\\s[a-zA-z]{1,20}",name) == true){
				
					nC.setName(name);
					namematch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid name: ");					
					name = scan.nextLine();
					
				}
			}			
		}
		
			
		System.out.println("\nPlease enter Password: ");
		password = scan.nextLine();
		
		
		if(Pattern.matches("[a-zA-z0-9]{8,}",password) == true){ //password must contain more than 8 characters
			
			nC.setPassword(password);
		
		}
		else{
			
			boolean passwordmatch = false;
			
			while(passwordmatch == false){
			
				if(Pattern.matches("[a-zA-z0-9]{8,}",password) == true){
				
					nC.setPassword(password);
					passwordmatch = true;
	
				}
				else{
				
					System.out.println("Please enter a password that has more than 8 characters");
					System.out.println("\nPlease enter Password: ");
					password = scan.nextLine();
				
				}
				
			}
		}
		
		System.out.println("\nPlease enter Address: ");
		address = scan.nextLine();
		
		if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){//format is (number)(space)(name)(space)(street,drive,all the good stuff)
			
			nC.setAddress(address);
			
		}
		else{
			
			boolean addressmatch = false;
			
			while(addressmatch == false){
				
				if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){
				
					nC.setAddress(address);
					addressmatch = true;
				
				}
				else{
				
					System.out.println("\nPlease enter a valid address: ");
					address = scan.nextLine();
				
				}
			}
			
		}
		
		System.out.println("\nPlease enter mobile Number: ");
		number = scan.nextLine();
		
		if(Pattern.matches("[0-9]{10}", number) == true){ //number.length() == 10 && must be digits.
			
			nC.setNumber(number);
			
		}
		else{
			
			boolean numbermatch = false;
			
			while(numbermatch == false){
			
				if(Pattern.matches("[0-9]{10}", number) == true){
				
					nC.setNumber(number);
					numbermatch = true;
				
				}
				else{
				
					System.out.println("\nPlease enter a valid number: ");
					number = scan.nextLine();
				
				}
			}
			
		}
		
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
	
	public void addEmployee() { //make another class for this function

		String empid = "", name = "", address = "", number = "";
		String setempid = null, setname = null, setaddress = null, setnumber = null;
		Connection con = null;
		Statement statement = null;
		scan.nextLine();
		
		System.out.println("\nPlease enter new employee name: ");
		name = scan.nextLine();
		
		if(Pattern.matches("[a-zA-z]{1,20}",name) == true){
			
			setname = name;
			
		}
		else{
			
			boolean namematch = false;
			
			while(namematch == false){
				
				if(Pattern.matches("[a-zA-z]{1,20}",name) == true){
					
					setname = name;
					namematch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid name: ");
					name = scan.nextLine();
					
				}
			}			
		}
		
		System.out.println("\nPlease enter new employee number: ");
		
		number = scan.nextLine();
		
		if(Pattern.matches("[0-9]{10}", number) == true){
			
			setnumber = number;
			
		}
		else{
			
			boolean numbermatch = false;
			
			while(numbermatch == false){
				
				if(Pattern.matches("[0-9]{10}", number) == true){
					
					setnumber = number;
					numbermatch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid number: ");
					number = scan.nextLine();
					
				}
			}
			
		}
		System.out.println("\nPlease enter new employee address: ");
		
		address = scan.nextLine();
		
		if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){
			
			setaddress = address;
			
		}
		else{
			
			boolean addressmatch = false;
			
			while(addressmatch == false){
				
				if(Pattern.matches("[0-9]{1,6}\\s[a-zA-z]{3,15}\\s[a-zA-z]{2,10}", address) == true){
					
					setaddress = address;
					addressmatch = true;
					
				}
				else{
					
					System.out.println("\nPlease enter a valid address: ");
					address = scan.nextLine();
					
				}
			}
			
		}
		
		System.out.println("\nPlease enter new employee ID: ");
		
		empid = scan.next();
		
		if(Pattern.matches("[0-9]{1,3}", empid) == true){
			
			empid.trim();
			setempid = empid;

		}
		else{
			
			boolean empidmatch = false;
			
			while(empidmatch == false){
			
				if(Pattern.matches("[0-9]{1,3}", empid) == true){
					
					empid.trim();
					setempid = empid;
					empidmatch = true;
					
				}
				else{
					
					System.out.println("Please enter a valid ID number");
					empid = scan.next();
					
				}
			}
		}
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
		
			System.out.println("connection made for adding employee");
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO employee values('e"+setempid+"', '"+setname+"', '"+setaddress+"', '"+setnumber+"')");
			
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
