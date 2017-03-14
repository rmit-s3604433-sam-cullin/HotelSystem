package interfaces;

import java.util.Date;
import java.util.LinkedList;

public interface Booking {
		public abstract void cancel();
		public abstract void complete();
		public abstract LinkedList<Customer> getGoing();
		public abstract Date getDate();
		//this function will be used for any booking that are going to be repeating
		public abstract void enterNextBooking();
		
		
}
