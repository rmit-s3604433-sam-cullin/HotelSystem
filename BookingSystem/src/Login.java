import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Login {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void login1() throws FileNotFoundException, IOException {
		
		MainMenu object = new MainMenu();
		/*try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/business.txt")))*/ {
		
			/*String[] tokens = reader.readLine().split(",");*/
			System.out.println("\nPlease enter username: ");
			String username1 = scan.next();
			FileInputStream f = new FileInputStream("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/business.txt"); 
			InputStreamReader reader = new InputStreamReader(f);
			BufferedReader buff = new BufferedReader(reader);
			StringBuffer stringbuffer = new StringBuffer("");
			String line = null;
			while ((line = buff.readLine()) != null) {
			    stringbuffer.append(line);
			}

			File file = new File("C:/Users/Nic/git/HotelSystem5/BookingSystem/src/business.txt");
			Scanner inputFile = new Scanner(file);
			inputFile.useDelimiter("[\\r,]");
			
			while(inputFile.hasNext()) {
				String Name = inputFile.next();
				String Businessname = inputFile.next();
				String Address = inputFile.next();
				String Address2 = inputFile.next();
				String Contact = inputFile.next();
				String Username = inputFile.next();
				String Password = inputFile.next();
				
				while (!Username.equals(username1)) {
					System.out.println("\nInvalid Username.");
					System.out.println("Please re-enter Username: ");
					username1 = scan.next();
				}
				System.out.println("\nPlease enter password:");
				String password1 = scan.next();
				while (!Password.equals(password1)) {
					System.out.println("\nInvalid Password.");
					System.out.println("Please re-enter Password: ");
					password1 = scan.next();
				}
				System.out.println("\nLogin Successful!\n");
				object.OwnerMenu();
			}	
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
