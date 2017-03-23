package testfiles;

import static org.junit.Assert.*;
import org.junit.Test;
import mainpackage.Employee;

public class EmployeeTest {

	Employee e;
	String name = "John";
	int number = 0000000001;
	String ID = "001";
	String position = "Manager";
	int age = 28;
	String address = "04 Jarvas street";
	
	@Test
	public void testConstructer(){

		Employee e2 = new Employee(ID,name,address,number, age,position);	
		assertEquals(ID, e2.getID());
		assertEquals(name, e2.getName());
		assertEquals(address, e2.getNumber());
		assertEquals(number, e2.getAge());
		assertEquals(age, e2.getPosition());
		
	}
	
	public void testGetSetID(){
		
		e.setID(ID);
		assertEquals("ID is not expected",
				ID, e.getID());
		
	}
	
	@Test 
	public void testGetSetName(){
		
		e.setName(name);
		assertEquals("Name is not expected",
				name, e.getName());
		
	}
	
	@Test
	public void testGetSetAddress(){
		
		e.setAddress(address);
		assertEquals("Address is not expected",
				address, e.getAddress());
	}
	
	public void testGetSetNumber(){
		
		e.setNumber(number);
		assertEquals("Number is not expected",
				number, e.getNumber());
		
	}
	
	public void testGetSetAge(){
		
		e.setNumber(age);
		assertEquals("Number is not expected",
				age, e.getAge());
		
	}
	
	@Test
	public void testGetSetPosition(){
		
		e.setPosition(position);
		assertEquals("Position is not expected",
				position, e.getPosition());
	}

}
