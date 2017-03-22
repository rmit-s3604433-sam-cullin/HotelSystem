package mainpackage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	
	final static Scanner scan = new Scanner(System.in);
	
	public void readUsername(String ID, Person person) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			System.out.println("Connection success!");
			Statement statement = con.createStatement();
			
			/*ResultSet resultSet = statement.executeQuery("SELECT * FROM owner WHERE ownid='" + ID + "'");
			while(resultSet.next()) {
			
			}*/
			ResultSet resultSet2 = statement.executeQuery("SELECT * FROM customer WHERE custid='" + ID + "'");
			while(resultSet2.next()) {
				System.out.print("custid: " + resultSet2.getString("custid") + " | ");
				System.out.print("name: " + resultSet2.getString("name") + " | ");
				System.out.print("password: " + resultSet2.getString("password") + " | ");
				System.out.print("address: " + resultSet2.getString("address") + " | ");
				System.out.println("number: " + resultSet2.getString("number"));
			}
			if(ID.matches("[c][0-9]{3}")) {
				while(resultSet2.next()) {
				person = new Customer();
				person.setID(resultSet2.getString("custid"));
				person.setName(resultSet2.getString("name"));
				person.setPassword(resultSet2.getString("password"));
				person.setAddress(resultSet2.getString("address"));
				person.setNumber(resultSet2.getString("number"));
				}
			} /*else if (ID.matches("[o][0-9]{3}")) {
				person = new Owner();
			}*/ else {
				System.out.println("No person found");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		/* 
		 * Read from database and compare to user input i.e String ID
		 */
	}
	
	public void readPassword(String password) {
		/*
		 * Read from database and compare to user input i.e String password
		 */
	}
	
}
