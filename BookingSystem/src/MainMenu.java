import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	public void mainmenu() throws IOException {
		
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		Employee addemployee = new Employee();
		
		while(!done) {
			System.out.println("======================================");
			System.out.println("   Johns Electrician Booking System");
			System.out.println("======================================");
			System.out.println("1. Add new employee");
			System.out.println("\n2. Add working time/dates for next month");
			System.out.println("\n3. Booking summary");
			System.out.println("\n4. Employeee availability");
			System.out.println("\n4. Quit");
			System.out.println("======================================");
			System.out.println("PLease enter you choice: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
				case 1 : 
					addemployee.addemployee();
					break;
			}
		}
	}
}
