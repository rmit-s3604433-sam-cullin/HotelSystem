package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Employee;

public class EmployeeIDTest {

	Employee employee = new Employee();
	@Test
	public void test1() {
		employee.setID("abc");
		assertEquals("abc", employee.getID());	
	}
	@Test
	public void test2() {
		employee.setID("1");
		assertEquals("1", employee.getID());	
	}
	@Test
	public void test3() {
		employee.setID("%!@~");
		assertEquals("%!@~", employee.getID());	
	}
	@Test
	public void test4() {
		employee.setID("0000");
		assertEquals("0000", employee.getID());	
	}
	@Test
	public void test5() {
		employee.setID("1010101010101010101");
		assertEquals("1010101010101010101", employee.getID());	
	}
	@Test
	public void test6() {
		employee.setID(" ");
		assertEquals(" ", employee.getID());	
	}

}