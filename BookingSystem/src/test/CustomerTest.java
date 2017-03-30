package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Customer;
import mainpackage.Person;

public class CustomerTest {

	@Test
	public void testID() {
		String ID = "x001", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		/* This will run successful. 
		 * To get a fail return assertTrue instead of assert
		 */
	}
	@Test
	public void testName() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testPassword() {
		String ID = "", name = "", password = "abcd", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testAddress() {
		String ID = "", name = "", password = "", address = "65* Test st, Testville 3012", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testNumber() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "040d3r45t6";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}

}
