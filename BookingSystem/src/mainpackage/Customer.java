package mainpackage;



public class Customer extends Person {

	
	public Customer(String ID, String name, String password, String address, String number) {
		super(ID, name, password, address, number);
	}
	public Customer(String textfile){
		
	}

	
	public void createBooking() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
	@Override
	public void setID(String ID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContact(String number) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}
	


}
