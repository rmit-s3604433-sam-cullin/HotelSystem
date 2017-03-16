package MainPackage;

import java.util.Date;

public class Person{
	private String name;
	private String ID;
	private String number;
	private String password;

	
	public Person(){
		
	}
	public Person(String name,String number,String ID,String password){
		this.name = name;
		this.number = number;
		this.ID = ID;
		this.setPassword(password);

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
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	

	public void print(){
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
