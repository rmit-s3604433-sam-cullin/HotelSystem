package mainpackage;

public class Employee {
	
	private int number, age;
	private String ID, name, address, position;
	
	public Employee(String ID, String name, String address, int number, int age, String position) {
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
	public int getNumber() { return number; }
	public int getAge() { return age; }
	public String getPosition() { return position; }
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String toString(){
		return ID + "," + name +  "," + address + "," + number + "," + age + "," + position;
	}

}
