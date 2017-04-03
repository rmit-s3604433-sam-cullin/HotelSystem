package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Customer;

public class CustomerNameTest {
	Customer customer = new Customer();
	@Test
	public void test1() {
		customer.setName("tim0t4y 7uRn3r");
		assertEquals("tim0t4y 7uRn3r", customer.getName());
	}
	@Test
	public void test2() {
		customer.setName(" ");
		assertEquals(" ", customer.getName());
	}
	@Test
	public void test3() {
		customer.setName("10239843");
		assertEquals("10239843", customer.getName());
	}
	@Test
	public void test4() {
		customer.setName("[]-=;'./,`");
		assertEquals("[]-=;'./,`", customer.getName());
	}
	@Test
	public void test5() {
		customer.setName("12123]][;..`1");
		assertEquals("12123]][;..`1", customer.getName());
	}
	@Test
	public void test6() {
		customer.setName("Taspf][';`kfja");
		assertEquals("Taspf][';`kfja", customer.getName());
	}

}
