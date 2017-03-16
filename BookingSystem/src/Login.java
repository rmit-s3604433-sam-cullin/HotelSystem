import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void login1() throws FileNotFoundException, IOException {
		
		MainMenu object = new MainMenu();
		try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/business.txt"))) {
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
			System.out.println("\nLogin Successful!\n");
			object.OwnerMenu();
		}
	}
	public void login2() throws FileNotFoundException, IOException {
			
			MainMenu customermenu = new MainMenu();
			try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/customerinfo.txt"))) {
				String[] tokens = reader.readLine().split(",");
				System.out.println("\nPlease enter username: ");
				String username1 = scan.next();
				while (!tokens[1].equals(username1)) {
					System.out.println("\nInvalid Username.");
					System.out.println("Please re-enter Username: ");
					username1 = scan.next();
				}
				System.out.println("\nPlease enter password:");
				String password1 = scan.next();
				while (!tokens[2].equals(password1)) {
					System.out.println("\nInvalid Password.");
					System.out.println("Please re-enter Password: ");
					password1 = scan.next();
				}
				System.out.println("\nLogin Successful!\n");
				customermenu.CustomerMenu();
			}
		}
}