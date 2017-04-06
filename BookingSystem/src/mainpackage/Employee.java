package mainpackage;

public class Employee {
	
	
	private String ID, name, address, position, age, number;
	public Employee(){
		
	}
	public Employee(String ID, String name, String address, String number, String age, String position) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.number = number;
		this.age = age;
		this.position = position;
	}

	public String getID() { return ID; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public String getNumber() { return number; }
	public String getAge() { return age; }
	public String getPosition() { return position; }
	
	public void setID(String ID) {
		if(ID.matches("[0-9]{3}")) {
			ID.trim();
			this.ID = ID;	
		} else {
			System.out.println("Invalid ID number");		
		}	
	}
	public void setName(String name) {
		if(name.matches("[a-zA-Z ]{2,30}")) {	
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
	}
	public void setAddress(String address) {	
		if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
			this.address = address;				
		} else {
			System.out.println("Invalid Address");			
		}
			
	}
	public void setNumber(String number) {
		if(number.matches("[0-9]{10}")){
			this.number = number;
		} else {
			System.out.println("Invalid Number");
		}
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String toString(){
		return ID + "," + name +  "," + address + "," + number + "," + age + "," + position;
	}
}
