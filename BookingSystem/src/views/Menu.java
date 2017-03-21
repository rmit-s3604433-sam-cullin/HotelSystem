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
	
	public boolean systemMenu() throws IOException {
		boolean exit = false;
		do{
			String x = printMenu();
			switch(x){
				case("1"):
					login();
					exit = true;
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
	
	@SuppressWarnings("unused")
	public void login() {
		Person person = null;
		String ID, password;
		do{
		System.out.println("\nPlease Enter User ID or 'exit'"); 
		ID = scan.next();
		if(!ID.equals("exit") && person == null) {
			System.out.println("Invalid : Please re-enter User ID");
		} else {
			Login read = new Login();
			read.readUsername(ID);
		}
		}while(person == null && (!ID.equals("exit")));
		if(person != null) {
			do {
			System.out.println("\nPlease Enter User Password for "+ person.getName() + " or 'exit'");
			password = scan.next();
			if(!password.equals("exit") && !password.equals(person.getPassword())) {
				System.out.println("\nInvalid : Please re-enter User Password");
			}
			}while(!password.equals(person.getPassword()) && (!password.equals("exit")));
			if(password.equals("exit")){
				person = null;
			}
		}
	}
	
	public void OwnerMenu() throws IOException {
		
		boolean done = false;
		Employee employee = null;
		
		while(!done) {
			System.out.println("======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. Add new employee");
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
	
	public void CustomerMenu() throws FileNotFoundException, IOException {
		
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
		
		String ID = "c", name = "", password = "", address = "";
		int number = 0;
		Person nC = new Customer(ID,name,password,address,number);
		scan.nextLine();
		System.out.println("\nPlease enter ID: ");
		ID += scan.nextLine();
		nC.setID(ID);
		System.out.println("\nPlease enter Name: ");
		name = scan.nextLine();
		nC.setName(name);
		System.out.println("\nPlease enter Password: ");
		password = scan.nextLine();
		((Customer) nC).setPassword(password);
		System.out.println("\nPlease enter Address: ");
		address = scan.nextLine();
		nC.setAddress(address);
		System.out.println("\nPlease enter Contact Number: ");
		number = scan.nextInt();
		nC.setNumber(number);
		scan.nextLine();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			System.out.println("Connection success!");
			Statement statement = con.createStatement();
			
			/* SQL Statement */
			statement.executeUpdate("INSERT INTO customer values(' " + nC.getID() + "', '" + nC.getName() + "', '" + ((Customer) nC).getPassword() + "', '" + nC.getAddress() + "', '" + nC.getNumber() + "')");
			
			ResultSet resultSet2 = statement.executeQuery("SELECT * from customer");
			while(resultSet2.next()) {
				System.out.print("id: " + resultSet2.getString("custid") + " | ");
				System.out.print("name: " + resultSet2.getString("name") + " | ");
				System.out.print("password: " + resultSet2.getString("password") + " | ");
				System.out.print("address: " + resultSet2.getString("address") + " | ");
				System.out.println("number: " + resultSet2.getInt("number"));
			}
			System.out.println("\nRegistration Successful!\n");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/*public Employee addEmployee() {

		String name;
		String age;
		String contact;
		String title;
		String empid;
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
		return newEmployee;
	}*/
}
