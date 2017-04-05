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
	public void setID(String ID) { //can't have duplicates
		if(ID.matches("[0-9]{3}")) {
			ID.trim();
			this.ID = ID;
		} else {
			System.out.println("Invalid ID number");
		}			
	}
	
	@Override
	public void setName(String name) {
		if(name.matches("[a-zA-Z ]{2,30}")) {	
			this.name = name;		
		} else {
			System.out.println("Invalid name");			
		}
	}
	
	@Override
	public void setPassword(String password) {	
		if(password.matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}")){
			this.password = password;			
		} else {
			System.out.println("Invalid Password");		
		}			
	}
	
	@Override
	public void setAddress(String address) {
		if(address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
			this.address = address;	
		} else {
			System.out.println("Invalid Address");		
		}			
	}
	
	@Override
	public void setNumber(String number) {
		if(number.matches("[0-9]{10}")){
			this.number = number;	
		} else {
			System.out.println("Invalid Number");		
		}
	}

	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
}
