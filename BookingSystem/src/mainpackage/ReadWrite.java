package mainpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void saveCustToFile() throws IOException {
		String ID = "c", name = "", password = "", address = "";
		int number = 0;
		Person nC = new Customer(ID,name,password,address,number);
		System.out.println("\nPlease enter Name: ");
		name = scan.nextLine();
		nC.setName(name);
		System.out.println("\nPlease enter Password: ");
		password = scan.nextLine();
		nC.setPassword(password);
		System.out.println("\nPlease enter Address: ");
		address = scan.nextLine();
		nC.setAddress(address);
		System.out.println("\nPlease enter Contact Number: ");
		number = scan.nextInt();
		nC.setContact(number);
		System.out.println("\nPlease enter ID: ");
		ID += scan.nextLine();
		nC.setID(ID);
		System.out.println("\nRegistration Successful!\n");
		System.out.println(nC.toString());
		/* PLEASE CHANGE THE BELOW FILENAME TO YOUR VALID DIRECTORY */
		String filename = "/Users/Daniel/Documents/Bachelor Semester 05/Software Engineering - PT/HotelSystemGit/HotelSystem/BookingSystem/src/customerinfo.txt";
		try (FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outputStream = new PrintWriter(bw)){
			outputStream.write(nC.toString() + "\n");
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void loadCustFromFile(Person[] customers, Person[] admins) {
		String filename = "/Users/Daniel/Documents/Bachelor Semester 05/Software Engineering - PT/HotelSystemGit/HotelSystem/BookingSystem/src/customerinfo.txt";
		try {
			Scanner inputStream = new Scanner(new File(filename)).useDelimiter(",");
			int counter = 0;
			while (inputStream.hasNext()) {
				for (int i=0; i == counter; i++) {
					String id = inputStream.next();
					if (id.startsWith("c")) {
						//System.out.println("This id is " + id);
						String name = inputStream.next();
						String password = inputStream.next();
						//System.out.println("This name is " + name);
						String address = inputStream.next();
						//System.out.println("This bookLoanFee is " + bookLoanFee);
						int number = inputStream.nextInt();
						//System.out.println("This bookMaxLoanDays is " + bookMaxLoanDays);
						customers[i] = new Customer(id, name, password, address, number);
					}
					if (id.startsWith("a")) {
						//System.out.println("This id is " + id);
						String name = inputStream.next();
						String password = inputStream.next();
						//System.out.println("This name is " + name);
						String address = inputStream.next();
						//System.out.println("This bookLoanFee is " + bookLoanFee);
						int number = inputStream.nextInt();
						//System.out.println("This bookMaxLoanDays is " + bookMaxLoanDays);
						admins[i] = new Employee(id, name, password, address, number);
					}
					if (inputStream.hasNext()) {
						counter++;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
