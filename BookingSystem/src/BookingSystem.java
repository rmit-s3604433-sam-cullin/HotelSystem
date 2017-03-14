import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingSystem {

	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int val = 0;
		boolean done = false;
		
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
					try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem/HelloWorld/business.txt"))) {
						String[] tokens = reader.readLine().split(",");
						System.out.println("\nPlease enter username: ");
						String username1 = scan.next();
						while (!tokens[5].equals(username1)) {
							System.out.println("\nInvalid Username.");
							System.out.println("Please re-enter Username: ");
							username1 = scan.next();
						}
						System.out.println("\nPlease enter password:");
						String password1 = scan.next();
						while (!tokens[6].equals(password1)) {
							System.out.println("\nInvalid Password.");
							System.out.println("Please re-enter Password: ");
							password1 = scan.next();
						}
						System.out.println("\nLogin Successful !\n");
					}
					done = true;
					break;
				case 2:
					System.out.println("\nPlease enter Name: ");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println("\nPlease enter Username: ");
					String username = scan.nextLine();
					while(username.contains(" ")) {
						System.out.println("\nInvalid : Username can't have spaces.");
						System.out.println("Please re-enter Username: ");
						username = scan.nextLine();
					}
					System.out.println("\nPlease enter Password: ");
					String password = scan.nextLine();
					while(password.contains(" ")) {
						System.out.println("\nInvalid : Password can't have spaces.");
						System.out.println("Please re-enter Password: ");
						password = scan.next();
					}
					System.out.println("\nPlease enter Address: ");
					scan.nextLine();
					String address = scan.nextLine();
					System.out.println("\nPlease enter Contact Number: ");
					String contact = scan.next();
				
						BufferedWriter writer = null;
						try {
								writer = new BufferedWriter(new FileWriter(".\\customerinfo.txt", true));
					
						writer.write(name + ",");
						writer.write(username + ",");
						writer.write(password + ",");
						writer.write(address + ",");
						writer.write(contact);
						writer.newLine();
						writer.flush();
			
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if(writer != null) try {
							writer.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
					System.out.println("\nRegistration Successful !\n");
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
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("======================================");
	}

}