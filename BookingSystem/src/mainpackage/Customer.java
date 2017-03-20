package mainpackage;



public class Customer extends Person {

	
	public Customer(String ID, String name, String password, String address, String number) {
		super(ID, name, password, address, number);
	}
	public Customer(String textfile){
		
	}

	
	public void book() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		System.out.println("name:" + name + "   number:" + number + "   Password:" + password + "  ID:" + ID);
		
	}
	@Override
	public String toString(){
		String userString = ID + "," + name + "," + password + "," + address + "," + number + ",";
		return userString;
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
