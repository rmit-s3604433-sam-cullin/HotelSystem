package views;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

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
	
	public void login() {
		
		String ID, password;
		boolean userDone = false, passDone = false;
		
		do{
			System.out.println("\nPlease Enter User ID or 'exit'"); 
			ID = scan.next();
			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							System.out.println("Admin found!");
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								System.out.println("User found!");
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
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
						Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						Statement statement = con.createStatement();
						
						ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
						while(resultSet.next()) {
							if(password.equals(resultSet.getString("password"))) {
								System.out.println("Password correct!");
								ownerMenu();
								passDone = true;
							}
						}
						ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
						while(resultSet2.next()) {
							if(password.equals(resultSet2.getString("password"))) { 
								System.out.println("Password correct!");
								customerMenu();
								passDone = true;
							} else {
								System.out.println("Password incorrect");
							}
						}
					} catch (Exception e) {
						System.err.println(e);
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
					/*
					 * addEmployee();
					 */
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
	
	public void addCustomer() {
		
		String ID = "c", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		scan.nextLine();
		System.out.println("\nPlease enter ID: ");
		ID += scan.nextLine();
		ID.trim();
		nC.setID(ID);
		System.out.println("ID:" + nC.getID());
		System.out.println("\nPlease enter Name: ");
		name = scan.nextLine();
		nC.setName(name);
		System.out.println("\nPlease enter Password: ");
		password = scan.nextLine();
		nC.setPassword(password);
		System.out.println("\nPlease enter Address: ");
		address = scan.nextLine();
		nC.setAddress(address);
		System.out.println("\nPlease enter mobile Number: ");
		number = scan.nextLine();
		nC.setNumber(number);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			Statement statement = con.createStatement();
			
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO customer values('" + nC.getID() + "', '" + nC.getName() + "', '" + nC.getPassword() + "', '" + nC.getAddress() + "', '0" + nC.getNumber() + "')");

			System.out.println("\nRegistration Successful!");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/*public void addEmployee() {

		String ID = "", name = "", address = "", number = "", position = "";
		int age = 0;
		Employee newEmployee;
		System.out.println("\nPlease enter new employee name: ");
		name = scan.next();
		System.out.println("\nPlease enter new employee age: ");
		age = scan.next();
		System.out.println("\nPlease enter new employee contact: ");
		contact = scan.next();
		System.out.println("\nPlease enter new employee title/position: ");
		title = scan.next();
		System.out.println("\nPlease enter new employee ID: ");
		empid = scan.next();
		newEmployee = new Employee(name,age,contact,title,empid);
		System.out.println("\nSuccessfully added new employee to system!\n");
	}*/
}
