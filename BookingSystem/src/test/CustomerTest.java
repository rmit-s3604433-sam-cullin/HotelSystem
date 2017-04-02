package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Customer;
import mainpackage.Person;

public class CustomerTest {

	@Test
	public void testID1() {
		String ID = "x001", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	
	@Test
	public void testID2() {
		String ID = "xpaps", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	@Test
	public void testID3() {
		String ID = "12384329", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
	
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	@Test
	public void testID4() {
		String ID = "+_][;'./,;'`[];}{};", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	@Test
	public void testID5() {
		String ID = "120{}+-==;./<", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	@Test
	public void testID6() {
		String ID = "c01];'2", name = "", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setID(ID);
		
		assertTrue(nC.getID().matches("c[0-9]{3}"));
		
	}
	@Test
	public void testName1() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testName2() {
		String ID = "", name = " ", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testName3() {
		String ID = "", name = "10239843", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testName4() {
		String ID = "", name = "[]-=;'./,``", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testName5() {
		String ID = "", name = "12123]][;..`1", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testName6() {
		String ID = "", name = "Taspf][';`kfja", password = "", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setName(name);
		
		assertTrue(nC.getName().matches("[a-zA-Z ]{1,30}"));
	}
	@Test
	public void testPassword1() {
		String ID = "", name = "", password = " ", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testPassword2() {
		String ID = "", name = "", password = "1234", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testPassword3() {
		String ID = "", name = "", password = "abcd", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testPassword4() {
		String ID = "", name = "", password = "ABCDJAKS0101092", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testPassword5() {
		String ID = "", name = "", password = "AbcjsLsfp]]['.1/]", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testPassword6() {
		String ID = "", name = "", password = "lospfA]['/.20193", address = "", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setPassword(password);
		
		assertTrue(nC.getPassword().matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}"));
	}
	@Test
	public void testAddress1() {
		String ID = "", name = "", password = "", address = "65* Test st, Testville 3012", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	public void testAddress2() {
		String ID = "", name = "", password = "", address = "Abcdefghijk", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	public void testAddress3() {
		String ID = "", name = "", password = "", address = "1012302495901", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	public void testAddress4() {
		String ID = "", name = "", password = "", address = "90009-88897709", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	public void testAddress5() {
		String ID = "", name = "", password = "", address = "?_=[][{}};./,.`~", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	public void testAddress6() {
		String ID = "", name = "", password = "", address = "a", number = "";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setAddress(address);
		
		assertTrue(nC.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testNumber1() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "040d3r45t6";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber2() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "041928345";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber3() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "01";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber4() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "ABCDEFGHI";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber5() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = "|}[{}:?><~";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber6() {
		String ID = "", name = "tim0t4y 7uRn3r", password = "", address = "", number = " ";
		Person nC = new Customer(ID,name,password,address,number);
		nC.setNumber(number);
		
		assertTrue(nC.getNumber().matches("[0-9]{10}"));
	}

}