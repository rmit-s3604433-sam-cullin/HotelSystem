package dataManagers;

import java.util.Date;
import java.util.LinkedList;

import interfaces.Booking;
import interfaces.Customer;
import interfaces.Worker;

public class DataBase implements interfaces.DataBase {
	
	private LinkedList<Booking> Bookings;
	private LinkedList<Customer> Customers;
	private LinkedList<Worker> Workers;
	
	public DataBase(){
		Bookings =  new LinkedList<Booking>();
		Customers = new LinkedList<Customer>();
		Workers = new LinkedList<Worker>();
	
	}

	@Override
	public LinkedList<Booking> workingDates(Worker worker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Booking> bookingsFor(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Booking> workingDatesFromTo(Worker worker, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Booking> bookingsForFromTo(Customer customer, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Booking> allBookingsFromTo(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printCustomers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printWorkers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printBookings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillDataBase() {
		// TODO Auto-generated method stub
		
	}

}
