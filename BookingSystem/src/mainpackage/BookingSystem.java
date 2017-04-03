package mainpackage;

import java.util.Scanner;

import view.Menu;

import java.io.*;
import java.sql.*;

public class BookingSystem {
	
	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		/* create instance of menu */
		Menu menu = new Menu();
		boolean done = false;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			System.out.println("Connection success!");
			Statement statement = con.createStatement();
			
			/* NEVER DELETE THESE!
			statement.executeUpdate("CREATE TABLE customer(custid STRING, name STRING, password STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO customer values('c001','Patrick Bateman', 'abcd1234', '720 Glenhuntly Rd, Glen Huntly 3163', '0470617895')");
			statement.executeUpdate("INSERT INTO customer values('c002','Sean Daley', '1234abcd', '5/20 Sandbelt Close, Heatherton 3202', '0401387466')");
			statement.executeUpdate("CREATE TABLE owner(ownid STRING, businessname STRING, ownername STRING, password STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO owner values('o001', 'JS Electrical PTY', 'John Stewart', 'ownerpass', '24 Lansell Rd, Toorak 3142', '0430614823')");
			statement.executeUpdate("CREATE TABLE employee(empid STRING, name STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO employee values('e001', 'Patrick Cripps', '256 Warrigal Rd, Oakleigh 3166', '0405841655')");
			statement.executeUpdate("INSERT INTO employee values('e002', 'Marc Murphy', '45 Derby St, Kew 3101', '0430655874')");
			statement.executeUpdate("INSERT INTO employee values('e003', 'Sebastian Vettel', '73 Pakington St, St Kilda 3182', '0408711963')");
			*/
			
			//if you want to delete register test entries
			//statement.executeUpdate("DELETE FROM employee WHERE empid='e004'");
			 
			
			/* perform query, loop through and print all rows */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
			while(resultSet.next()) {
				System.out.print("empid: " + resultSet.getString("empid") + " | ");
				System.out.print("name: " + resultSet.getString("name") + " | ");
				System.out.print("address: " + resultSet.getString("address") + " | ");
				System.out.println("number: 0" + resultSet.getInt("number"));
			}
			System.out.println("");
			/* here for customer */
			ResultSet resultSet2 = statement.executeQuery("SELECT * FROM customer");
			while(resultSet2.next()) {
				System.out.print("custid: " + resultSet2.getString("custid") + " | ");
				System.out.print("name: " + resultSet2.getString("name") + " | ");
				System.out.print("password: " + resultSet2.getString("password") + " | ");
				System.out.print("address: " + resultSet2.getString("address") + " | ");
				System.out.println("number: 0" + resultSet2.getString("number"));
			}
			System.out.println("");
			/* here for owner */
			ResultSet resultSet3 = statement.executeQuery("SELECT * FROM owner");
			while(resultSet3.next()) {
				System.out.print("ownid: " + resultSet3.getString("ownid") + " | ");
				System.out.print("business name: " + resultSet3.getString("businessname") + " | ");
				System.out.print("business owner name: " + resultSet3.getString("ownername") + " | ");
				System.out.print("password: " + resultSet3.getString("password") + " | ");
				System.out.print("address: " + resultSet3.getString("address") + " | ");
				System.out.println("number: 0" + resultSet3.getString("number"));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		while (!done) {
			done = menu.systemMenu();
			System.out.println("Program has been terminated.");
		
		}
	}
}