package objects;
import java.util.Date;

public class Person{
	private String name;
	private String email;
	private String number;
	private String ID;
	private Date bDay;
	
	public Person(String name,String email,String number,String ID,Date bDay){
		this.name = name;
		this.email = email;
		this.number = number;
		this.ID = ID;
		this.bDay = bDay;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getbDay() {
		return bDay;
	}
	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}
	public void print(){
		
	}

}
