package mainpackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import views.Menus;
import java.sql.*;

public class BookingSystem {
	
	final static Scanner scan = new Scanner(System.in);
	final static public String customertxt = "customerinfo.txt";
	final static public String employeetxt = "/Users/samcullin/git/HotelSystem/BookingSystem/src/employeeinfo.txt";
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
			System.out.println("Connection success!");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		Menus menu = new Menus();
		
		Customer temCustomer = new Customer("c001","jim","abcd1234","1 Street Road, Melbourne","0401654752" );
		Employee temEmployee = new Employee("bob","25","123456","dude","e002");
		/*database.addEmployee(temEmployee);
		database.addCustomer(temCustomer);
		database.printCustomers();
		database.printEmployee();*/
		boolean done = false;
		while (!done) {
			done = menu.login();
			System.out.println("Program has been terminated.");
			/*int usertype = getUserType(logedinUser);
			switch(usertype){
				case(1):
					menu.CustomerMenu();
				break;
				case(2):
					menu.OwnerMenu();
				break;
				case(3):
				exit =0;
				break;
				default:
			}*/
		
		}
		/*database.saveSystem();*/
		}
	
	static public int getUserType(Person person){
		int type = 2;
		if(person == null){
			type =3;
		}
		return type;
	}
		/*int val = 0;
		boolean done = false;
		Login ownerlogin = new Login();
		Login customerlogin = new Login();
		Register register = new Register();
		
		while (!done) {
			
			printMenu();
			try {
				System.out.println("Please enter your choice: ");
				val = scan.nextInt();
			} catch(InputMismatchException exception) {
				System.out.println("\nInvalid : Please choose from the following menu.\n");
				scan.nextLine();
				val = -1;
			}

			switch ( val ) {
				case -1:
					done = false;
					break;
				case 1:
					while(!done) {
						System.out.println("\n======================================");
						System.out.println("   Johns Electrician Booking System");
						System.out.println("======================================");
						System.out.println("1. Business Owner");
						System.out.println("\n2. Customer");
						System.out.println("======================================");
						System.out.println("Please choose a category: ");
						int choice = scan.nextInt();
						
						switch (choice) {
							case 1:
								ownerlogin.login1();
								break;
							case 2:
								customerlogin.login2();
								break;
							default:
								System.out.println("\nInvalid : Please choose one of the category stated above.");
						}
					}
					done = true;
					break;
				case 2:
					register.register();
					done = true;
					break;
				case 3:
					System.out.println("\nThe system will exit now.");
					System.out.println("Program has been terminated.");
					System.exit(0);
					break;
				default:
					System.out.println("\nInvalid : Please choose from the following menu.\n");
			}
		}
	}
	public static void printMenu() {
		System.out.println("======================================");
		System.out.println("   Johns Electrician Booking System");
		System.out.println("======================================");
		System.out.println("1. Login");
		System.out.println("\n2. Register");
		System.out.println("\n3. Quit");
		System.out.println("======================================");
	}*/
}
