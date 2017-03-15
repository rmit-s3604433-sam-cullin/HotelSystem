import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void register() {
		
		System.out.println("\nPlease enter Name: ");
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
		String address = scan.nextLine();
		System.out.println("\nPlease enter Contact Number: ");
		String contact = scan.next();
		BufferedWriter writer = null;
		try {
				writer = new BufferedWriter(new FileWriter("C:/Users/Nic/git/HotelSystem/HelloWorld/customerinfo.txt", true));
	
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
		System.out.println("\nRegistration Successful!\n");
	}
}
