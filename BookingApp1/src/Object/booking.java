package Object;

public class booking {
	public String bookingID;
	public String date;
	public String startTime;
	public String empID;
	public String serviesID;
	public String customerNumber;
	
	public booking(String id,String date,String startTime, String customerID, String empID,String serviesID){
		this.bookingID = id;
		this.date = date;
		this.startTime = startTime;
		this.empID = empID;
		this.serviesID = serviesID;
		this.customerNumber = customerID;
	}

}
