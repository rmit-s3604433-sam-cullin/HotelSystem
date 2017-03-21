package mainpackage;

import java.util.Scanner;
import java.io.*;
import java.sql.*;
import views.Menu;

public class BookingSystem {
	
	final static Scanner scan = new Scanner(System.in);
	Person customers[];
	Person employees[];
	Person admins[];
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Menu menu = new Menu();
		boolean done = false;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			System.out.println("Connection success!");
			Statement statement = con.createStatement();
			
			/*
			statement.executeUpdate("CREATE TABLE customer(custid STRING, name STRING, password STRING, address STRING, number INTEGER)");
			statement.executeUpdate("INSERT INTO customer values('c001', 'Patrick Cripps', 'abcd1234', '520 South Rd, Ormond 3145', '0410622387')");
			statement.executeUpdate("INSERT INTO employee values('e002', 'Marc Murphy', '45 Derby St, Kew 3101', '0430655874', '27', 'Electrician')");
			statement.executeUpdate("INSERT INTO employee values('e003', 'Sebastian Vettel', '73 Pakington St, St Kilda 3182', '0408711963', '36', 'Labourer')");
			*/
			statement.executeUpdate("DELETE FROM customer WHERE custid = ' c004'");
			
			ResultSet resultSet = statement.executeQuery("SELECT * from employee");
			while(resultSet.next()) {
				System.out.print("id: " + resultSet.getString("empid") + " | ");
				System.out.print("name: " + resultSet.getString("name") + " | ");
				System.out.print("address: " + resultSet.getString("address") + " | ");
				System.out.print("number: " + resultSet.getInt("number") + " | ");
				System.out.print("age: " + resultSet.getInt("age") + " | ");
				System.out.println("position: " + resultSet.getString("position"));
			}
			System.out.println("");
			ResultSet resultSet2 = statement.executeQuery("SELECT * from customer");
			while(resultSet2.next()) {
				System.out.print("custid: " + resultSet2.getString("custid") + " | ");
				System.out.print("name: " + resultSet2.getString("name") + " | ");
				System.out.print("password: " + resultSet2.getString("password") + " | ");
				System.out.print("address: " + resultSet2.getString("address") + " | ");
				System.out.println("number: " + resultSet2.getInt("number"));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		while (!done) {
			done = menu.systemMenu();
			System.out.println("Program has been terminated.");
			/*int usertype = getUserType(logedinUser);
			switch(usertype){
				case(1):
					menu.CustomerMenu();
				break;
				case(2):
					menu.OwnerMenu();
				break;
				case(3):
				exit =0;
				break;
				default:
			}*/
		
		}
	}
	
	static public int getUserType(Person person){
		int type = 2;
		if(person == null){
			type =3;
		}
		return type;
	}
}