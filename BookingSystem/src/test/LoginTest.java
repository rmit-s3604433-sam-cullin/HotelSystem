package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
		
	@Test
	//Test owner invalid id and valid password - Failure
	public void test1() throws SQLException {
		
		Statement statement =null;
		ResultSet resultSet =null;
		Connection con =null;
		String Result, Result2;
			
		String ID = "o0101"; 
		String Password = "ownerpass";
		assertTrue(ID.matches("[o][0-9]{3}"));
		
		con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement = con.createStatement();		
		resultSet = statement.executeQuery("SELECT ownid FROM owner");
		Result = resultSet.getString("ownid");
		resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
		Result2 = resultSet.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
	@Test
	//Test owner valid id but invalid password - Failure
	public void test2() throws SQLException {
		
		Statement statement2 =null;
		ResultSet resultSet2 =null;
		Connection con2 =null;
		String Result, Result2;
		
		String ID = "o001"; 
		String Password = "myownpass";
		assertTrue(ID.matches("[o][0-9]{3}"));
		
		con2 = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement2 = con2.createStatement();		
		resultSet2 = statement2.executeQuery("SELECT ownid FROM owner");
		Result = resultSet2.getString("ownid");
		resultSet2 = statement2.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
		Result2 = resultSet2.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
	@Test
	//Test owner invalid id and invalid password - Failure
	public void test3() throws SQLException {
		
		Statement statement3 =null;
		ResultSet resultSet3 =null;
		Connection con3 =null;
		String Result, Result2;
		
		String ID = "o1234"; 
		String Password = "ownpass123";
		assertTrue(ID.matches("[o][0-9]{3}"));
		
		con3 = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement3 = con3.createStatement();		
		resultSet3 = statement3.executeQuery("SELECT ownid FROM owner");
		Result = resultSet3.getString("ownid");
		resultSet3 = statement3.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
		Result2 = resultSet3.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
	@Test
	//Test customer invalid id and valid password - Failure
	public void test4() throws SQLException {

		Statement statement =null;
		ResultSet resultSet =null;
		Connection con =null;
		String Result, Result2;
		
		String ID = "c1234";
		String Password = "abcd1234";
		assertTrue(ID.matches("[c][0-9]{3}"));
		
		con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement = con.createStatement();		
		resultSet = statement.executeQuery("SELECT custid FROM customer");
		Result = resultSet.getString("custid");
		resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
		Result2 = resultSet.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
	@Test
	//Test customer valid id but invalid password - Failure
	public void test5() throws SQLException {

		Statement statement2 =null;
		ResultSet resultSet2 =null;
		Connection con2 =null;
		String Result, Result2;
		
		String ID = "c001";
		String Password = "qwer6789";
		assertTrue(ID.matches("[c][0-9]{3}"));
		
		con2 = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement2 = con2.createStatement();		
		resultSet2 = statement2.executeQuery("SELECT custid FROM customer");
		Result = resultSet2.getString("custid");
		resultSet2 = statement2.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
		Result2 = resultSet2.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
	@Test
	//Test customer invalid id and invalid password- Failure
	public void test6() throws SQLException {

		Statement statement3 =null;
		ResultSet resultSet3 =null;
		Connection con3 =null;
		String Result, Result2;
		
		String ID = "12345";
		String Password = "play13579";
		assertTrue(ID.matches("[c][0-9]{3}"));
		
		con3 = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
		statement3 = con3.createStatement();		
		resultSet3 = statement3.executeQuery("SELECT custid FROM customer");
		Result = resultSet3.getString("custid");
		resultSet3 = statement3.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
		Result2 = resultSet3.getString("password");
		assertEquals(ID, (Result));
		assertEquals(Password, (Result2));
	}
}