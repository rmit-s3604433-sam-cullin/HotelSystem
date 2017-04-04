package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Employee;

public class EmployeeTest {

	@Test
	public void testID1() {
		String ID = "x001", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);	
		assertTrue(e.getID().matches("e[0-9]{3}"));		
	}
	
	@Test
	public void testID2() {
		String ID = "xpaps", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);		
		assertTrue(e.getID().matches("e[0-9]{3}"));
	}
	@Test
	public void testID3() {
		String ID = "12384329", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);	
		assertTrue(e.getID().matches("e[0-9]{3}"));
	}
	@Test
	public void testID4() {
		String ID = "+_][;'./,;'`[];}{};", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);		
		assertTrue(e.getID().matches("e[0-9]{3}"));		
	}
	@Test
	public void testID5() {
		String ID = "120{}+-==;./<", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);	
		assertTrue(e.getID().matches("e[0-9]{3}"));		
	}
	@Test
	public void testID6() {
		String ID = "c01];'2", name = "",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setID(ID);	
		assertTrue(e.getID().matches("e[0-9]{3}"));	
	}
	@Test
	public void testName1() {
		String ID = "", name = "x001",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testName2() {
		String ID = "", name = " ",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testName3() {
		String ID = "", name = "10239843",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testName4() {
		String ID = "", name = "[]-=;'./,``",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testName5() {
		String ID = "", name = "12123]][;..`1",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testName6() {
		String ID = "", name = "12123]][;..`1",address = "", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setName(name);	
		assertTrue(e.getName().matches("e[0-9]{3}"));
	}
	@Test
	public void testAddress1() {
		String ID = "", name = "",address = "65* Test st, Testville 3012", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);	
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testAddress2() {
		String ID = "", name = "",address = "Abcdefghijk", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);	
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testAddress3() {
		String ID = "", name = "",address = "1012302495901", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);	
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testAddress4() {
		String ID = "", name = "",address = "90009-88897709", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);	
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testAddress5() {
		String ID = "", name = "",address = "?_=[][{}};./,.`~", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);	
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testAddress6() {
		String ID = "", name = "",address = " ", position = "", number = "", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setAddress(address);
		assertTrue(e.getAddress().matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}"));
	}
	@Test
	public void testNumber1() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = "040d3r45t6", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber2() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = "041928345", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber3() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = "01", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber4() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = "ABCDEFGHI", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber5() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = "|}[{}:?><~", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}
	@Test
	public void testNumber6() {
		String ID = "", name = "tim0t4y 7uRn3r", address = "", position = "", number = " ", age = "";
		Employee e = new Employee(ID,name,address,number,age,position);
		e.setNumber(number);	
		assertTrue(e.getNumber().matches("[0-9]{10}"));
	}

}