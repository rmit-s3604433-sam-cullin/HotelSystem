package views;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MainPackage.Employee;

public class EmployeeTest {

	Employee e;
	String name = "John";
	String number = "0449920356";
	String ID = "01";
	String password = "abcde12345";
	String position = "Manager";
	
	@Before
	public void setUp() throws Exception{
		
		e = new Employee();
		
	}
	
	@After
	public void tearDown() throws Exception{
		
		e = null;
		
	}
	
	@Test
	public void testConstructer(){
		
		assertNotNull("Could not create basic Person", e);
		Employee e2 = new Employee(name,number,ID, password, position);
		assertNotNull("Could not create complex Person", e2);
		assertEquals("Name not set as expecgted on complex constructor",
				name, e2.getName());
		assertEquals("Number not set as expected on complex constructor",
				number, e2.getContact());
		assertEquals("Number not set as expected on complex constructor",
				ID, e2.getID());
		assertEquals("Number not set as expected on complex constructor",
				password, e2.getPassword());
		assertEquals("Position not set as expected on complex constructor",
				position, e2.getPosition());
	}
	
	@Test 
	public void testGetSetName(){
		
		e.setName(name);
		assertEquals("Name is not expected",
				name, e.getName());
		
	}
	
	public void testGetSetID(){
		
		e.setID(ID);
		assertEquals("ID is not expected",
				ID, e.getID());
		
	}
	
	public void testGetSetContact(){
		
		e.setContract(number);
		assertEquals("Number is not expected",
				name, e.getContact());
		
	}
	
	public void testGetSetPassword(){
		
		e.setPassword(password);
		assertEquals("Password is not expected",
				name, e.getPassword());
		
	}
	
	@Test
	public void testGetSetPosition(){
		
		e.setPosition(position);
		assertEquals("Position is not expected",
				position, e.getPosition());
	}
}
