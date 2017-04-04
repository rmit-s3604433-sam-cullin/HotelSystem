package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Employee;

public class EmployeeNumberTest {
	Employee employee = new Employee();
	@Test
	public void test1() {
		employee.setNumber("");
		assertEquals("",employee.getNumber());
	}
	@Test
	public void test2() {
		employee.setNumber(" ");
		assertEquals(" ",employee.getNumber());
	}
	@Test
	public void test3() {
		employee.setNumber("040d3r45t6");
		assertEquals("040d3r45t6",employee.getNumber());
	}
	@Test
	public void test4() {
		employee.setNumber("041928345");
		assertEquals("041928345",employee.getNumber());
	}
	@Test
	public void test5() {
		employee.setNumber("ABCDEFGHI");
		assertEquals("ABCDEFGHI",employee.getNumber());
	}
	@Test
	public void test6() {
		employee.setNumber("|}[{}:?><~");
		assertEquals("|}[{}:?><~",employee.getNumber());
	}

}
