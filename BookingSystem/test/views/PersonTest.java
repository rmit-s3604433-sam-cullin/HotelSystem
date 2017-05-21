package views;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MainPackage.Person;

public class PersonTest {
	Person p;
	String name = "John";
	String number = "0449920356";
	String ID = "01";
	String password = "abcde12345";
	
	@Before
	public void setUp() throws Exception{
		
		p = new Person();
		
	}
	
	@After
	public void tearDown() throws Exception{
		
		p = null;
		
	}
	
	@Test
	public void testConstructer(){
		
		assertNotNull("Could not create basic Person", p);
		Person p2 = new Person(name,number,ID, password);
		assertNotNull("Could not create complex Person", p2);
		assertEquals("Name not set as expecgted on complex constructor",
				name, p2.getName());
		assertEquals("Number not set as expected on complex construcor",
				number, p2.getContact());
		assertEquals("Number not set as expected on complex construcor",
				ID, p2.getID());
		assertEquals("Number not set as expected on complex construcor",
				password, p2.getPassword());
		
	}
	
	@Test 
	public void testGetSetName(){
		
		p.setName(name);
		assertEquals("Name is not expected",
				name, p.getName());
		
	}
	
	public void testGetSetID(){
		
		p.setID(ID);
		assertEquals("ID is not expected",
				ID, p.getID());
		
	}
	
	public void testGetSetContact(){
		
		p.setContract(number);
		assertEquals("Name is not expected",
				number, p.getContact());
		
	}
	
	public void testGetSetPassword(){
		
		p.setPassword(password);
		assertEquals("Name is not expected",
				password, p.getPassword());
		
	}

}
