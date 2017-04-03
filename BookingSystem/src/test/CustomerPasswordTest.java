package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Customer;

public class CustomerPasswordTest {
	Customer customer = new Customer();
	@Test
	public void test1() {
		customer.setPassword(" ");
		assertEquals(" ", customer.getPassword());
	}
	@Test
	public void test2() {
		customer.setPassword("1234");
		assertEquals("1234", customer.getPassword());
	}
	@Test
	public void test3() {
		customer.setPassword("abcd");
		assertEquals("abcd", customer.getPassword());
	}
	@Test
	public void test4() {
		customer.setPassword("ABCDJAKS0101092");
		assertEquals("ABCDJAKS0101092", customer.getPassword());
	}
	@Test
	public void test5() {
		customer.setPassword("AbcjsLsfp]]['.1/]");
		assertEquals("AbcjsLsfp]]['.1/]", customer.getPassword());
	}
	@Test
	public void test6() {
		customer.setPassword("lospfA]['/.20193");
		assertEquals("lospfA]['/.20193", customer.getPassword());
	}

}
