import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingSystem {

	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 0;
		boolean done = false;
		while (!done) {
			printLogin();
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
					System.out.println("You entered Login");
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
	
	public static void printLogin() {
		System.out.println("=====================================");
		System.out.println("   John Electrician Booking System");
		System.out.println("=====================================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("=====================================");
	}

}
