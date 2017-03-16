
import java.util.Date;

public class Person{
	private String name;
	private String ID;
	private String number;

	
	public Person(){
		
	}
	public Person(String name,String number,String ID){
		this.name = name;
		this.number = number;
		this.ID = ID;

	}
	public String getContact(){
		return number;
	}
	public void setContract(String number){
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public void print(){
		
	}

}
