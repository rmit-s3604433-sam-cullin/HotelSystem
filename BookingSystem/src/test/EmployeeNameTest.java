package test;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Employee;

public class EmployeeNameTest {
	Employee employee = new Employee();
	@Test
	public void test1() {
		employee.setName("tim0t4y 7uRn3r");
		assertEquals("tim0t4y 7uRn3r", employee.getName());
	}
	@Test
	public void test2() {
		employee.setName(" ");
		assertEquals(" ", employee.getName());
	}
	@Test
	public void test3() {
		employee.setName("10239843");
		assertEquals("10239843", employee.getName());
	}
	@Test
	public void test4() {
		employee.setName("[]-=;'./,`");
		assertEquals("[]-=;'./,`", employee.getName());
	}
	@Test
	public void test5() {
		employee.setName("12123]][;..`1");
		assertEquals("12123]][;..`1", employee.getName());
	}
	@Test
	public void test6() {
		employee.setName("Taspf][';`kfja");
		assertEquals("Taspf][';`kfja", employee.getName());
	}


}
