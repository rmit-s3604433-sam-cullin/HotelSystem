package testfiles;

import static org.junit.Assert.*;

import org.junit.Test;
import mainpackage.Customer;
import mainpackage.Person;

public class AddCustomerTest {

	@Test
	public void AddCustomerTest1() {
		 
		String ID = "     ", name = "    ", password = "    ", address = "    ", number = "    ";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));
			
	}
	
	@Test
	public void AddCustomerTest2() {
		 
		String ID = "^&&^@$@#", name = "^&&^@$@#", password = "^&&^@$@#", address = "^&&^@$@#", number = "^&&^@$@#";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));
	}
	
	@Test
	public void AddCustomerTest3() {
		 
		String ID = "120498123", name = "120498123", password = "120498123", address = "120498123", number = "120498123";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));
	}
	
	@Test
	public void AddCustomerTest4() {
		 
		String ID = "asdfnaksdfas", name = "asdfnaksdfas", password = "asdfnaksdfas", address = "asdfnaksdfas", number = "asdfnaksdfas";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));			
	}
	
	@Test
	public void AddCustomerTest5(){
		
		String ID = "jksaldjf01294", name = "jksaldjf01294", password = "jksaldjf01294", address = "jksaldjf01294", number = "jksaldjf01294";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));	
		
	}
	
	public void AddCustomerTest6(){
		
		String ID = "cjksaldjf01294", name = "jksaldjf01294", password = "jksaldjf01294", address = "jksaldjf01294", number = "jksaldjf01294";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));	
		
	}
	
	public void AddCustomerTest7(){
		
		String ID = "c^&&^@$@#", name = "jksaldjf01294", password = "jksaldjf01294", address = "jksaldjf01294", number = "jksaldjf01294";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));	
		
	}
	
	public void AddCustomerTest8(){
		
		String ID = "casncksnvifjalskdnvifjsnghdnsjaishgndjclaldsf", 
				name = "asncksnvifjalskdnvifjsnghdnsjaishgndjclaldsf", 
				password = "asncksnvifjalskdnvifjsnghdnsjaishgndjclaldsf", 
				address = "asncksnvifjalskdnvifjsnghdnsjaishgndjclaldsf", 
				number = "asncksnvifjalskdnvifjsnghdnsjaishgndjclaldsf";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));	
		
	}
	
	public void AddCustomerTest9(){
		
		String ID = "c012345678910111213141516171819202122232425", 
				name = "012345678910111213141516171819202122232425", 
				password = "012345678910111213141516171819202122232425", 
				address = "012345678910111213141516171819202122232425", 
				number = "012345678910111213141516171819202122232425";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));	
		
	}
	
	public void AddCustomerTest10(){
		
		String ID = "c^&&^@$@#*)(*()(^#&(!8754123][]][';;'/.,,", 
				name = "^&&^@$@#*)(*()(^#&(!8754123][]][';;'/.,,", 
				password = "^&&^@$@#*)(*()(^#&(!8754123][]][';;'/.,,", 
				address = "^&&^@$@#*)(*()(^#&(!8754123][]][';;'/.,,", 
				number = "^&&^@$@#*)(*()(^#&(!8754123][]][';;'/.,,";
		Person nC = new Customer(ID,name,password,address,number);
		
		nC.setID(ID);
		nC.setName(name);
		nC.setPassword(password);
		nC.setAddress(address);
		nC.setNumber(number);
		
		assertFalse("The value passed through",ID.equals(nC.getID()));
		assertFalse(name.equals(nC.getName()));
		assertFalse(password.equals(nC.getPassword()));
		assertFalse(address.equals(nC.getAddress()));
		assertFalse(number.equals(nC.getNumber()));
		
	}
}
