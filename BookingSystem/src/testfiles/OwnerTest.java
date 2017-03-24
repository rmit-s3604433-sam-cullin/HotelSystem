package testfiles;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Employee;
import mainpackage.Owner;
import mainpackage.Person;

public class OwnerTest {

	Owner o;
	String ID = "o001";
	String businessName = "John's Electrician";
	String name = "John";
	String number = "0000000001";
	String password = "abcd1234";
	String address = "04 Jarvas street";
	
	@Test
	public void testConstructer(){

		Person o2 = new Owner(ID,businessName,name,password,address,number);	
		assertEquals(ID, o2.getID());
		assertEquals(businessName, ((Owner) o2).getBusinessName());
		assertEquals(name, o2.getName());
		assertEquals(password, o2.getPassword());
		assertEquals(address, o2.getAddress());
		assertEquals(number, o2.getNumber());

	}
	
	public void testGetSetID(){
		
		o.setID(ID);
		assertEquals(ID, o.getID());
		
	}
	
	public void testGetSetBusinessName(){
		
		o.setBusinessName(businessName);
		assertEquals(businessName, o.getBusinessName());
		
	}
	
	@Test 
	public void testGetSetName(){
		
		o.setName(name);
		assertEquals(name, o.getName());
		
	}
	
	@Test
	public void testGetSetPassword(){
		
		o.setPassword(password);
		assertEquals(password, o.getPassword());
		
	}
	
	@Test
	public void testGetSetAddress(){
		
		o.setAddress(address);
		assertEquals(address, o.getAddress());
	}
	
	public void testGetSetNumber(){
		
		o.setNumber(number);
		assertEquals(number, o.getNumber());
		
	}
	

}
