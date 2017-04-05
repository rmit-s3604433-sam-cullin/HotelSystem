package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mainpackage.Login;

public class LoginIDTest {
	Login login = new Login();
	@Test
	public void test() {
		assertEquals(1,login.loginIDValidation("c001"));
	}
	
	@Test 
	public void test1() {
		assertEquals(0,login.loginIDValidation("c01"));
	}
	
	@Test 
	public void test2() {
		assertEquals(0,login.loginIDValidation("p001"));
	}
	
	@Test 
	public void test3() {
		assertEquals(0,login.loginIDValidation("abcd"));
	}
	
	@Test 
	public void test4() {
		assertEquals(0,login.loginIDValidation("c1"));
	}
	
	@Test 
	public void test5() {
		assertEquals(1,login.loginIDValidation("o001"));
	}

}
