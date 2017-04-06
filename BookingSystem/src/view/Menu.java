package views;

import java.io.*;
import java.util.Scanner;

import mainpackage.*;
import register.AddCustomer;
import register.AddEmployee;

public class Menu {
  
	final static Scanner scan = new Scanner(System.in);
	AddCustomer customer = new AddCustomer();
	AddEmployee employee = new AddEmployee();
	Login login = new Login();
	
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
					login.loginMenu();
					break;
				case("2"):
					customer.addCustomerMenu();
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
					employee.addEmployeeMenu();
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

	public void addTimeDate() {
		
		String year = "", month = "", date = "", timeA = "", timeB = "";
		int confirm, choice = 0;
		while(choice == 0 || choice == 1) {		
			scan.nextLine();
			System.out.println("Please enter year :");
			year = scan.nextLine();
			int year1 = Integer.parseInt(year);
			while(year1 < 2017 || year1 > 2017) {
				System.out.println("\nInvalid : You can only add for the current year.");
				System.out.println("Please enter year :");
				year = scan.nextLine();
				year1 = Integer.parseInt(year);
			}
			System.out.println("\nPlease enter month (numeric) :");
			month = scan.nextLine();
			int month1 = Integer.parseInt(month);
			while(month1 > 12 || month1 < 1) {
				System.out.println("\nInvalid : Please enter a valid month");
				System.out.println("Please enter month (numeric) :");
				month = scan.nextLine();
				month1 = Integer.parseInt(month);
				
			}
			if(month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
				System.out.println("\nPlease enter date :");
				date = scan.nextLine();
				int date1 = Integer.parseInt(date);
				while(date1 > 31 || date1 < 1) {
					System.out.println("\nInvalid : Invalid date for that particular month!");
					System.out.println("Please enter date :");
					date = scan.nextLine();
					date1 = Integer.parseInt(date);
				}
			}
			else {
				System.out.println("\nPlease enter date :");
				date = scan.nextLine();
				int date1 = Integer.parseInt(date);
				if(date1 > 30 || date1 < 1) {
					System.out.println("\nInvalid : Invalid date for that particular month!");
					System.out.println("Please enter date :");
					date = scan.nextLine();
					date1 = Integer.parseInt(date);
				}
			}
			System.out.println("\nPlease enter the starting time (24-hours system) :");
			timeA = scan.next();
			int time1 = Integer.parseInt(timeA);
			if(time1 < 900) {
				System.out.println("\nInvalid : Invalid working time schedule!");
				System.out.println("Please enter a time slot (24-hours system) :");
				timeA = scan.nextLine();
				time1 = Integer.parseInt(date);
			}
			System.out.println("\nPlease enter the ending time (24-hours system) :");
			timeB = scan.next();
			int time2 = Integer.parseInt(timeB);
			if(time2 > 1700) {
				System.out.println("\nInvalid : Invalid working time schedule!");
				System.out.println("Please enter a time slot (24-hours system) :");
				timeB = scan.nextLine();
				time2 = Integer.parseInt(date);
			}
			System.out.println("\nConfirm adding this time and date? (1 - Yes/2 - No)");
			confirm = scan.nextInt();
			if(confirm == 1) {
				System.out.println("\nSuccessfully added new time and date to system!");
				System.out.println(year + "/" + month + "/" + date + timeA + "-" + timeB);
			}
			else {
				System.out.println("Successfully cancelled adding new time and date to system!");
			}
			System.out.println("Press 1 to repeat process");
			System.out.println("Press 2 for Main Menu");
			choice = scan.nextInt();
		}
	}
}