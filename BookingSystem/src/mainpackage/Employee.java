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
		while(true){
			while(true) {
				if(ID.matches("[0-9]{3}")) {
					ID.trim();
					this.ID = ID;
					break;
				} else {
					System.out.println("Invalid ID number");
					break;
				}
			}
		}
	}
	public void setName(String name) {
		while(true) {
			if(name.matches("[a-zA-Z ]{1,30}")) {	
				this.name = name;
				break;
			} else {
				System.out.println("Invalid name");
				break;
			}
		}
	}
	public void setAddress(String address) {
		while(true) {	
			if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
				this.address = address;
				break;
			} else {
				System.out.println("Invalid Address");
				break;
			}
		}	
	}
	public void setNumber(String number) {
		while(true) {
			if(number.matches("[0-9]{10}")){
				this.number = number;
				break;
			} else {
				System.out.println("Invalid Number");
				break;
			}
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
