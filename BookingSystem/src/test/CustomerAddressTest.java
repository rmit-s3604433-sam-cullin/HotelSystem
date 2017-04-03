package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Customer;

public class CustomerAddressTest {
	Customer customer = new Customer();
	@Test
	public void test1() {
		customer.setAddress("");
		assertEquals("",customer.getAddress());
	}
	@Test
	public void test2() {
		customer.setAddress(" ");
		assertEquals(" ",customer.getAddress());
	}
	@Test
	public void test3() {
		customer.setAddress("65* Test st, Testville 3012");
		assertEquals("65* Test st, Testville 3012",customer.getAddress());
	}
	@Test
	public void test4() {
		customer.setAddress("1012302495901");
		assertEquals("1012302495901",customer.getAddress());
	}
	@Test
	public void test5() {
		customer.setAddress("90009-88897709");
		assertEquals("90009-88897709",customer.getAddress());
	}
	@Test
	public void test6() {
		customer.setAddress("?_=[][{}};./,.`~");
		assertEquals("?_=[][{}};./,.`~",customer.getAddress());
	}

}
