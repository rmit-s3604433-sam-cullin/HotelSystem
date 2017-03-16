package MainPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	public void OwnerMenu() throws IOException {
		
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		Employee addemployee = new Employee();
		new BookingSystem();
		
		while(!done) {
			System.out.println("======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. Add new employee");
			System.out.println("\n2. Add working time/dates for next month");
			System.out.println("\n3. Booking summary");
			System.out.println("\n4. Employeee availability");
			System.out.println("\n4. Logout");
			System.out.println("======================================");
			System.out.println("PLease enter you choice: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
				case 1 : 
					addemployee.addemployee();
					break;
				case 4 :
					System.out.println("\n");
					BookingSystem.main(null);
					break;
			}
		}
	}
	public void CustomerMenu() throws FileNotFoundException, IOException {
		
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		new BookingSystem();
		String choice ;
		do{
			System.out.println("======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. View available date & time");
			System.out.println("\n2. Logout");
			System.out.println("======================================");
			System.out.println("PLease enter you choice: ");
			choice = scanner.next();
			
			switch(choice) {
				case ("1"):
					System.out.println("\nHello!");
					break;
				case ("2"):
					System.out.println("\n");
					BookingSystem.main(null);
					break;
				default:
					System.out.println("please enter valid input");
			}
		}while(!choice.equals("2"));
	}
}
