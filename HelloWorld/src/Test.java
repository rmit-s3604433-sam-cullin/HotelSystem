import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int choice;
		
		System.out.println("=====================================");
		System.out.println("   John Electrician Booking System");
		System.out.println("=====================================");
		System.out.println("\tRegister / Login");
		System.out.println("=====================================");
		System.out.println("1. Business Owner");
		System.out.println("2. Customer\n");
		System.out.println("Please enter your choice :");
		Scanner one = new Scanner(System.in);
		choice = one.nextInt();
		
		if(choice == 2) {
			System.out.println("Please enter Name: ");
			System.out.println("Please enter Username: ");
			System.out.println("Please enter Password: ");
			System.out.println("Please enter Address: ");
			System.out.println("Please enter Contact Number: ");
		}
		else {
			System.out.println("Bye.");
		}
		
	}
			
}
