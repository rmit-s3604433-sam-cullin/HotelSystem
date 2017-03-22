package mainpackage;

public class Customer extends Person {
	
	public Customer(){
		
	}
	public Customer(String ID, String name, String password, String address, String number) {
		super(ID, name, password, address, number);
	}
	
	public void createBooking() {
		// TODO Auto-generated method stub
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
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
}
