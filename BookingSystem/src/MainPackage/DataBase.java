package MainPackage;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;



public class DataBase{
	
	@SuppressWarnings("unused")
	static private LinkedList<Booking> Bookings;
	@SuppressWarnings("unused")
	static private LinkedList<Customer> Customers;
	@SuppressWarnings("unused")
	static private LinkedList<Employee> Employee;
	
	public DataBase(){
		Bookings =  new LinkedList<Booking>();
		Customers = new LinkedList<Customer>();
		Employee = new LinkedList<Employee>();
	
	}
	
	public void addBooking(Booking booking){
		//bookings should be added in order of their due dates
	}
	public void addCustomer(Customer customer){
		Customers.add(customer);
	}
	public void addWorker(Employee employee){
		
	}
	public boolean removeWorker(Employee employee){
		
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
		for(Customer customer: Customers){
			customer.print();
		}
		
	}

	public void printWorkers() {
		// TODO Auto-generated method stub
		
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
	public void saveCustomers(){
		for(Customer customer:Customers){
			String cusString = customer.toString();
			
			
		}
	}

}

