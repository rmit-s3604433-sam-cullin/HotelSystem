package views;

import java.util.Scanner;

import dataManagers.DataBase;
import objects.Booking;
import objects.Customer;
import objects.Person;
import objects.Worker;
import system.BookingSystem;
public class Menus{
	static private DataBase database = system.BookingSystem.database;
	Scanner scanner = new Scanner(System.in);
	
	public void printMainMenu() {
		// TODO Auto-generated method stub
		
	}

	public Customer printAddCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printDataManager() {
		// TODO Auto-generated method stub
		
	}

	public Booking printBookingCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Worker printAddWorker() {
		// TODO Auto-generated method stub
		return null;
	}

	public Person login() {
		int exit = 0;
		Person person = null;
		for(;exit < 1;){
		String x = login1();
		switch(x){
			case("1"):
				person = login2();
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
		}
		return person;
	}
	private String login1(){
		System.out.println("======================================");
		System.out.println("   Johns Electrician Booking System");
		System.out.println("======================================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("======================================");
		System.out.print("Your Choice: ");
		String i = scanner.next();
		return i;
	}
	private Person login2(){
		Person person = null;
		System.out.println("Please Enter User ID");
		String ID = scanner.next();
		person = database.getPersonByID(ID);
		System.out.println("Please Enter User Passord for "+ person.getName());
		
		
		return null;
	}



}
