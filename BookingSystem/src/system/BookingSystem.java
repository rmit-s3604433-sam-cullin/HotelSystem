package system;
import java.util.InputMismatchException;
import java.util.Scanner;


import dataManagers.DataBase;
public class BookingSystem {

	final static Scanner scan = new Scanner(System.in);
	public final static DataBase database = new DataBase();
	public static void main(String[] args) {
		
		String username;
		int val = 0;
		boolean done = false;
		
		while (!done) {
			printMenu();
			try {
				System.out.println("Choose an option: ");
				val = scan.nextInt();
			} catch(InputMismatchException exception) {
				System.out.println("Input is not an integer");
				scan.nextLine();
				val = -1;
			}

			switch ( val ) {
				case -1:
					done = false;
					break;
				case 1:
					System.out.println("Please enter your username: ");
					// i.e
					// username = scan.nextLine();
					done = false;
					break;
				case 2:
					System.out.println("You entered Register");
					done = false;
					break;
				case 3:
					System.out.println("You entered Quit");
					done = true;
					break;
				default:
					System.out.println("Invalid Input");
			}
		}
		System.out.println("\nProgram has been terminated.");
	}
	
	public static void printMenu() {
		
	}

}