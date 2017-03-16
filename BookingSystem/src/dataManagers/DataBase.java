package dataManagers;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import objects.Booking;
import objects.Customer;
import objects.Person;
import objects.Worker;

public class DataBase{
	
	@SuppressWarnings("unused")
	static private LinkedList<Booking> Bookings;
	@SuppressWarnings("unused")
	static private LinkedList<Customer> Customers;
	@SuppressWarnings("unused")
	static private LinkedList<Worker> Workers;
	
	public DataBase(){
		Bookings =  new LinkedList<Booking>();
		Customers = new LinkedList<Customer>();
		Workers = new LinkedList<Worker>();
	
	}
	
	public void addBooking(Booking booking){
		//bookings should be added in order of their due dates
	}
	public void addCustomer(Customer customer){
		
	}
	public void addWorker(Worker worker){
		
	}
	public boolean removeWorker(Worker worker){
		
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

	public LinkedList<Booking> workingDates(Worker worker) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> bookingsFor(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Booking> workingDatesFromTo(Worker worker, Date from, Date to) {
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}
	public int getPersonType(Person person){
		
		return 0;
	}

}
