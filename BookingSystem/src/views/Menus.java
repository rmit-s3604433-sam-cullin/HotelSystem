package views;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import MainPackage.Booking;
import MainPackage.BookingSystem;
import MainPackage.Customer;
import MainPackage.DataBase;
import MainPackage.Employee;
import MainPackage.Person;


public class Menus{
  
final static Scanner scan = new Scanner(System.in);
	
static DataBase database = BookingSystem.database;

public void OwnerMenu() throws IOException {
		
		boolean done = false;
		Employee newEmployee;
		new BookingSystem();
		
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
			System.out.println("PLease enter you choice: ");
			int choice = scan.nextInt();
			
			switch (choice) {
				case 1 : 
					newEmployee = printAddEmployee();
					database.addWorker(newEmployee);
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

	public Customer printAddCustomer() {
		
		String name;
		String password;
		String contact;
		Customer newCustomer;
		String id;
		System.out.println("\nPlease enter Name: ");
		name = scan.next();
		System.out.println("\nPlease enter Password: ");
		password = scan.next();
		System.out.println("\nPlease enter Contact Number: ");
		contact = scan.next();
		System.out.println("\nPlease enter ID: ");
		id = scan.next();
		newCustomer = new Customer(name,contact,id,password);
		database.addCustomer(newCustomer);
		System.out.println("\nRegistration Successful!\n");
		return newCustomer;
		
	}

	public void printDataManager() {
		// TODO Auto-generated method stub
		
	}

	public Booking printBookingCreator() {
		// TODO Auto-generated method stub
		return null;
	}


	public Employee printAddEmployee() {

		// TODO Auto-generated method stub
		return null;
	}

	public Person login(){
		int exit = 0;
		Person person = null;
		do{
			String x = login1();
			switch(x){
				case("1"):
					person = login2();
					exit = 1;
					break;
				case("2"):
					person = printAddCustomer();
					break;
				case("3"):
					exit = 1;
					break;
				default:
					System.out.println("invalid input");
					break;
			}
			}while(exit == 0);
		return person;
	}
	private String login1(){
		System.out.println("======================================");
		System.out.println("   John's Electrician Booking System");
		System.out.println("======================================");
		System.out.println("1. Login");
		System.out.println("\n2. Register");
		System.out.println("\n3. Quit");
		System.out.println("======================================");
		System.out.print("Please Enter Your Choice: ");
		String i = scan.next();
		return i;
	}
	private Person login2() {
		Person person = null;
		String ID;
		String password;
		do{
		System.out.println("\nPlease Enter User ID or 'exit'"); 
		ID = scan.next();
		person = database.getPersonByID(ID);
		if(!ID.equals("exit") && person == null) {
			System.out.println("Invalid : Please re-enter User ID");
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
		return person;
	}
}
