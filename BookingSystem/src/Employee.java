import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee {

	public void addemployee() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nNew employee name: ");
		String name = scanner.nextLine();
		System.out.println("\nNew employee age: ");
		int age = scanner.nextInt();	
		System.out.println("\nNew employee contact number: ");
		String contact = scanner.next();
		System.out.println("\nNew employee address: ");
		scanner.nextLine();
		String address = scanner.nextLine();
		System.out.println("\nNew employee emergency contact number: ");
		String econtact = scanner.next();
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:/Users/Nic/git/HotelSystem/src/employee.txt", true));

			writer.write(name + ",");
			writer.write(age + ",");
			writer.write(contact + ",");
			writer.write(address + ",");
			writer.write(econtact);
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
		System.out.println("\nSuccessfully added new employee!");
		System.out.println("Press 1 to view stored data");
		System.out.println("Press 2 for Main Menu");
		int input = scanner.nextInt();
		
		if(input == 1) { 
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Nic/git/HotelSystem/src/employee.txt"));
			while(true) {
				String line = reader.readLine();
				if(line == null) {
					break;
				}
				System.out.println("\n");
				System.out.println(line);
			}
			reader.close();
			System.out.println("\n");
		}
	}
}
