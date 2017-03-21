package mainpackage;

public class Employee extends Person{
	
	private String age;
	private String position;
	
	public Employee(String ID, String name, String password, String address, int number) {
		super(ID, name, password, address, number);
	}

	public void acceptWork() {
		// TODO Auto-generated method stub
		
	}
	/*@Override
	public void print() {
		System.out.println("name:"+this.name+" age:"+this.age+" conatact:"+this.contact+" position:"+this.position+" ID:"+this.employeeid);
		
	}*/
	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
	
	@Override
	public void setID(String ID) {
		this.ID = ID;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public void setContact(int number) {
		this.number = number;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
}
