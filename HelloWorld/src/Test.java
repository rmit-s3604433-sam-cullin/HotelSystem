import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=====================================");
		System.out.println("   John Electrician Booking System");
		System.out.println("=====================================");
		System.out.println("\tRegister / Login");
		System.out.println("=====================================");
		System.out.println("1. Business Owner");
		System.out.println("2. Customer\n");
		System.out.println("Please enter your choice :");
		int choice = scanner.nextInt();
		
		if(choice == 2) {
			System.out.println("Please enter Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.println("Your name is: " + name);
			System.out.println("Please enter Username: ");
			String username = scanner.nextLine();
			while(username.contains(" ")) {
				System.out.println("Invalid : Username can't have spaces.");
				System.out.println("Please re-enter Username: ");
				username = scanner.nextLine();
			}
			System.out.println("Your username is: " + username);
			System.out.println("Please enter Password: ");
			String password = scanner.nextLine();
			while(password.contains(" ")) {
				System.out.println("Invalid : Password can't have spaces.");
				System.out.println("Please re-enter Password: ");
				password = scanner.next();
			}
			System.out.println("Your password is: " + password);
			System.out.println("Please enter Address: ");
			scanner.nextLine();
			String address = scanner.nextLine();
			System.out.println("Your address is: " + address);
			System.out.println("Please enter Contact Number: ");
			String contact = scanner.next();
			System.out.println("Your contact number is: " + contact);
		
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
			System.out.println("\nRegistration Successful!");
		}
		else {
			try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem/HelloWorld/business.txt"))) {
				String[] tokens = reader.readLine().split(",");
				System.out.println("Please enter username: ");
				String username1 = scanner.next();
				while (!tokens[5].equals(username1)) {
					System.out.println("Invalid Username.");
					System.out.println("Please re-enter Username: ");
					username1 = scanner.next();
				}
				System.out.println("Please enter password:");
				String password1 = scanner.next();
				while (!tokens[6].equals(password1)) {
					System.out.println("Invalid Password.");
					System.out.println("Please re-enter Password: ");
					password1 = scanner.next();
				}
				System.out.println("\nLogin Successful !");
			}
		}
		scanner.close();
	}
}
			
