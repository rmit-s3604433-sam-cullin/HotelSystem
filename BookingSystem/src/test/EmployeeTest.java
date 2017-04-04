package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmployeeIDTest.class,EmployeeNameTest.class,
	EmployeeAddressTest.class,EmployeeNumberTest.class})
public class EmployeeTest {


}