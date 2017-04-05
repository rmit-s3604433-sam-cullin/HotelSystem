package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Login;

public class LoginPasswordTest {
	Login login = new Login();
	@Test
	public void test1() {
		assertEquals(1,login.loginPasswordValidation("c001", "abcd1234"));
	}
	@Test
	public void test2() {
		assertEquals(0,login.loginPasswordValidation("c001", "abcd12345"));
	}
	@Test
	public void test3() {
		assertEquals(1,login.loginPasswordValidation("o001", "ownerpass"));
	}
	@Test
	public void test4() {
		assertEquals(0,login.loginPasswordValidation("o001", "abcd1234"));
	}
	@Test
	public void test5() {
		assertEquals(0,login.loginPasswordValidation("c002", "abcd1234"));
	}
	@Test
	public void test6() {
		assertEquals(0,login.loginPasswordValidation("c01", "abcd1234"));
	}
	
	

}
