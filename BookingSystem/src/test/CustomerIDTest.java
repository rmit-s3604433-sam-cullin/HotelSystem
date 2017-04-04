package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Customer;

public class CustomerIDTest {
	Customer customer = new Customer();
	@Test
	public void test1() {
		customer.setID("abc");
		assertEquals("abc", customer.getID());	
	}
	@Test
	public void test2() {
		customer.setID("1");
		assertEquals("1", customer.getID());	
	}
	@Test
	public void test3() {
		customer.setID("%!@~");
		assertEquals("%!@~", customer.getID());	
	}
	@Test
	public void test4() {
		customer.setID("0000");
		assertEquals("0000", customer.getID());	
	}
	@Test
	public void test5() {
		customer.setID("1010101010101010101");
		assertEquals("1010101010101010101", customer.getID());	
	}
	@Test
	public void test6() {
		customer.setID(" ");
		assertEquals(" ", customer.getID());	
	}
	

}