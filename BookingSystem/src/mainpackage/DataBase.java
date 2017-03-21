package mainpackage;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class DataBase{
	
	/*@SuppressWarnings("unused")
	static private LinkedList<Booking> Bookings;
	static private LinkedList<Person> Customers;
	static private LinkedList<Employee> Employee;
	
	public DataBase(){
		Bookings =  new LinkedList<Booking>();
		Customers = new LinkedList<Person>();
		Employee = new LinkedList<Employee>();
	}*/
	LinkedList<Person> Customers = new LinkedList<Person>();
	LinkedList<Employee> Employee = new LinkedList<Employee>();
	
	public void addBooking(Booking booking){
		// bookings should be added in order of their due dates
	}
	public void addCustomer(Person customer){
		Customers.add(customer);
	}
	public void addEmployee(Employee employee){
		Employee.add(employee);
	}
	public boolean removeEmplyee(Employee employee){
		
		return false;
	}
	public boolean removeCustomer(Customer customer){
		
		return false;
	}
	public HashMap<Booking,String> updateBookings(){
		//this method will be run to check the progress of passed booking 
		//if they have been completed or canceled 
		
		return null;
	}

	public LinkedList<Booking> workingDates(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> bookingsFor(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> workingDatesFromTo(Employee employee, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> bookingsForFromTo(Customer customer, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> allBookingsFromTo(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printCustomers() {
		for(Person customer: Customers){
			customer.toString();
		}
	}

	public void printEmployee() {
		for(Employee employee: Employee){
			employee.toString();
		}
	}

	public void printBookings() {
		// TODO Auto-generated method stub
		
	}

	public void fillDataBase() {
		// TODO Auto-generated method stub
		
	}

	public Person getPersonByID(String ID) {
		Person tempperson = null;
		for(Person person : Customers){
			if(person.getID().equals(ID)){
				tempperson = person;
			}
		}
		return tempperson;
	}
	public int getPersonType(Person person){
		
		return 0;
	}
}

