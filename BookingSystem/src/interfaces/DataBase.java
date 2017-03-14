package interfaces;

import java.util.Date;
import java.util.LinkedList;

public interface DataBase {
	public abstract LinkedList<Booking> workingDates(Worker worker);
	public abstract LinkedList<Booking> bookingsFor(Customer customer);
	public abstract LinkedList<Booking> workingDatesFromTo(Worker worker,Date from,Date to);
	public abstract LinkedList<Booking> bookingsForFromTo(Customer customer,Date from,Date to);
	public abstract LinkedList<Booking> allBookingsFromTo(Date from,Date to);
	public abstract void printCustomers();
	public abstract void printWorkers();
	public abstract void printBookings();
	public abstract void fillDataBase();

}
