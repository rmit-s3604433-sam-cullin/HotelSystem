package mainpackage;

import java.util.Scanner;

public class Employee {
	
	
	private String ID, name, address, number;
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
	public Employee(String ID, String name, String address, String number) {
=======
>>>>>>> GUI
	public Employee() {
		
	}
	public Employee(String ID, String name, String address, String number, String age, String position) {
>>>>>>> Regex in setters and junit overhaul commit
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.number = number;
		/*this.age = age;
		this.position = position;*/
	}

	public String getID() { return ID; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public String getNumber() { return number; }
	/*public String getAge() { return age; }
	public String getPosition() { return position; }*/
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	/*public void setAge(String age) {
		this.age = age;
	}
	public void setPosition(String position) {
		this.position = position;
	}*/
	
	public String toString(){
		return ID + "," + name +  "," + address + "," + number;
	}
	
	
	
	
	
	
	
	public int multiply(int x, int y){
		
		return x*y;
		
	}
	
	
	public void multiply(){
		
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int total = x*y;
	}

}
