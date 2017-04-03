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
	
	@Override
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
	
	@Override
	public void setPassword(String password) {	
		while(true) {	
			if(password.matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}")){
				this.password = password;
				break;
			} else {
				System.out.println("Invalid Password");
				break;
			}
		}		
	}
	
	@Override
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
	
	@Override
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

	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
}
