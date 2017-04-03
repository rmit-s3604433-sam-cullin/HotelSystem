package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Employee;

public class EmployeeAddressTest {

	Employee employee = new Employee();
	@Test
	public void test1() {
		employee.setAddress("");
		assertEquals("",employee.getAddress());
	}
	@Test
	public void test2() {
		employee.setAddress(" ");
		assertEquals(" ",employee.getAddress());
	}
	@Test
	public void test3() {
		employee.setAddress("65* Test st, Testville 3012");
		assertEquals("65* Test st, Testville 3012",employee.getAddress());
	}
	@Test
	public void test4() {
		employee.setAddress("1012302495901");
		assertEquals("1012302495901",employee.getAddress());
	}
	@Test
	public void test5() {
		employee.setAddress("90009-88897709");
		assertEquals("90009-88897709",employee.getAddress());
	}
	@Test
	public void test6() {
		employee.setAddress("?_=[][{}};./,.`~");
		assertEquals("?_=[][{}};./,.`~",employee.getAddress());
	}

}
