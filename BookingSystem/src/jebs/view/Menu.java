package jebs.view;

import java.awt.EventQueue;
import java.io.*;
import java.util.Scanner;

import jebs.gui.Login;
import jebs.mainpackage.BookingSystem;
import jebs.mainpackage.LoginValidation;
import jebs.object.Customer;
import jebs.object.Person;
import jebs.object.Employee;


public class Menu {
  
	final static Scanner scan = new Scanner(System.in);
	Customer customer = new Customer();
	Employee employee = new Employee();
	Login login = new Login();
	LoginValidation lv = new LoginValidation();
	
	private String printMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
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
					loginMenu();
					break;
				case("2"):
					registerCustomerMenu();
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
	
	public void loginMenu() throws IOException{
		boolean IDCheck = false;
		String ID = "";
		while(true){
			System.out.println("Please enter User ID or 'exit': ");
			ID = scan.nextLine();
			if(lv.loginIDValidation(ID) == 1){
				IDCheck = true;
				break;
			}						
			else if(ID.equals("exit")){
				System.out.println("Returning to main menu");
				systemMenu();
				break;
			}
			else{
				System.out.println("Invalid ID");
			}
		}
		
		while(true){
			if(IDCheck == true){
				if(lv.loginIDValidation(ID) == 1){
					System.out.println("Enter the password: ");
					String password = scan.nextLine();
					int i = lv.loginPasswordValidation(ID,password);
					if(i == 1){
						System.out.println("Successful");
						customerMenu();
						break;
					}
					else if(i == 2){
						ownerMenu();
					}
					else {
						System.out.println("Invalid Password");
					}
				}
			}
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
			System.out.println("\n2. Add working time/dates for next month");
			System.out.println("\n3. Booking summary");
			System.out.println("\n4. Employeee availability");
			System.out.println("\n5. Logout");
			System.out.println("======================================");
			System.out.println("Please enter you choice: ");
			int choice = scan.nextInt();
			
			switch (choice) {
				case 1 : 
					registerEmployeeMenu();
					break;
				case 5 :
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
	
	public void registerCustomerMenu(){
		
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
		nC.addCustomer(nC);
	}
	
	public void registerEmployeeMenu(){
		String ID = "", name = "", address = "", number = "";
		Employee nE = new Employee(ID,name,address,number);
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
		employee.addEmployee(nE);
	}
}