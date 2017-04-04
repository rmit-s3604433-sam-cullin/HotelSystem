package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Customer;

public class CustomerNumberTest {
	Customer customer = new Customer();
	@Test
	public void test1() {
		customer.setNumber("");
		assertEquals("",customer.getNumber());
	}
	@Test
	public void test2() {
		customer.setNumber(" ");
		assertEquals(" ",customer.getNumber());
	}
	@Test
	public void test3() {
		customer.setNumber("040d3r45t6");
		assertEquals("040d3r45t6",customer.getNumber());
	}
	@Test
	public void test4() {
		customer.setNumber("041928345");
		assertEquals("041928345",customer.getNumber());
	}
	@Test
	public void test5() {
		customer.setNumber("ABCDEFGHI");
		assertEquals("ABCDEFGHI",customer.getNumber());
	}
	@Test
	public void test6() {
		customer.setNumber("|}[{}:?><~");
		assertEquals("|}[{}:?><~",customer.getNumber());
	}

}