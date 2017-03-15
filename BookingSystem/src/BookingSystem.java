import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingSystem {

	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int val = 0;
		boolean done = false;
		Login login = new Login();
		Register register = new Register();
		
		while (!done) {
			printMenu();
			try {
				System.out.println("PLease enter your choice: ");
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
					login.login();
					done = true;
					break;
				case 2:
					register.register();
					done = true;
					break;
				case 3:
					System.out.println("\nThe system will exit now.");
					System.out.println("Program has been terminated.");
					done = true;
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
	}
}