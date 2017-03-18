package MainPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import views.Menus;
public class BookingSystem {
	
	final static Scanner scan = new Scanner(System.in);
	final static public DataBase database = new DataBase();
	final static public String customertxt = "C:/Users/Nic/git/HotelSystem/BookingSystem/src/customerinfo.txt";
	final static public String employeetxt = "C:/Users/Nic/git/HotelSystem/BookingSystem/src/employeeinfo.txt";
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Menus menu = new Menus();
		
		Customer temCustomer = new Customer("sam","000","001","1234" );
		database.addCustomer(temCustomer);
		database.printWorkers();
		/*database.printCustomers();*/
		int exit = 5;
		do{
		Person logedinUser = menu.login();
		int usertype = getUserType(logedinUser);
		switch(usertype){
			case(1):
				menu.OwnerMenu();
			break;
			case(2):
				menu.OwnerMenu();
			break;
			case(3):
			System.out.println("\nThe system will exit now.");
			System.out.println("Program has been terminated.");
			System.exit(0);
			break;
			default:
				
		
		}
		
		}while(exit > 0);
		database.saveCustomers();
		database.saveEmployees();
		}
	
	static public int getUserType(Person person){
		int type = 1;
		if(person == null){
			type =3;
		}
		return type;
	}
		/*int val = 0;
		boolean done = false;
		Login ownerlogin = new Login();
		Login customerlogin = new Login();
		Register register = new Register();
		
		while (!done) {
			
			printMenu();
			try {
				System.out.println("Please enter your choice: ");
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
					while(!done) {
						System.out.println("\n======================================");
						System.out.println("   Johns Electrician Booking System");
						System.out.println("======================================");
						System.out.println("1. Business Owner");
						System.out.println("\n2. Customer");
						System.out.println("======================================");
						System.out.println("Please choose a category: ");
						int choice = scan.nextInt();
						
						switch (choice) {
							case 1:
								ownerlogin.login1();
								break;
							case 2:
								customerlogin.login2();
								break;
							default:
								System.out.println("\nInvalid : Please choose one of the category stated above.");
						}
					}
					done = true;
					break;
				case 2:
					register.register();
					done = true;
					break;
				case 3:
					System.out.println("\nThe system will exit now.");
					System.out.println("Program has been terminated.");
					System.exit(0);
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
	}*/
}
