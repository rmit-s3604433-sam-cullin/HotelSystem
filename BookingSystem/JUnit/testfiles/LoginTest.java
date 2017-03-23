package testfiles;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class LoginTest {
	
	@Test
	public void IDTest1(){
		String ID = "    "; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
	}
	
	@Test
	public void IDTest2(){
		String ID = "abcdsdfgdsa"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
	}
	
	@Test
	public void IDTest3(){
		
		String ID = "123456678"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test
	public void IDTest4(){
		
		String ID = "c0"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test
	public void IDTest5(){
		String ID = "c01"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
	}
	
	@Test
	public void IDTest6(){
		
		String ID = "c0001"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test
	public void IDTest7(){
		
		String ID = "c000000000000001"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
	}
	
	@Test
	public void IDTest8(){
		
		String ID = "o1"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test 
	public void IDTest9(){
		
		String ID = "o11"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test
	public void IDTest10(){
		
		String ID = "o1110"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
		
	}
	
	@Test
	public void IDTest11(){
		
		String ID = "o00000000000001110001"; 
		boolean userDone = false;

			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							userDone = true;
							break;
						}
					}
					if(!userDone) {
						ResultSet resultSet2 = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet2.next()) {
							if(ID.equals(resultSet2.getString("custid"))) { 
								userDone = true;
								break;
							}
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(userDone == false);
	}
	
	@Test
	public void PasswordTest1(){
		String ID = "c001"; 
		String password = "00000000000";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
	
	@Test
	public void PasswordTest2(){
		String ID = "c001"; 
		String password = "abcdefghijklmnop";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
	
	@Test
	public void PasswordTest3(){
		String ID = "c001"; 
		String password = "^@($&*#!)($*#@";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
	
	@Test
	public void PasswordTest4(){
		String ID = "c001"; 
		String password = "fjaskdj-12984124";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
	
	@Test
	public void PasswordTest5(){
		String ID = "c001"; 
		String password = "ANSAJLFNVDS";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
	
	@Test
	public void PasswordTest6(){
		String ID = "c001"; 
		String password = "ABCD1234";
		boolean userDone = true, passDone = false;
		
		if(userDone && !passDone) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				Statement statement = con.createStatement();
						
				ResultSet resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
				while(resultSet.next()) {
					if(password.equals(resultSet.getString("password"))) {
							passDone = true;
						}
					}
					ResultSet resultSet2 = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
					while(resultSet2.next()) {
						if(password.equals(resultSet2.getString("password"))) { 
							passDone = true;
						} else {
							System.out.println("Password incorrect");
						}
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		
		assertTrue(passDone == false);
	}
}
