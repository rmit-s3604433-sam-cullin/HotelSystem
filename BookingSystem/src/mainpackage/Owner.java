package mainpackage;

public class Owner extends Person {

	private String businessName, businessOwnName;
	
	public Owner() {
		
	}
	public Owner(String ID, String businessName, String name, String password, String address, String number) {
		super(ID, name, password, address, number);
		this.businessName = businessName;
		this.businessOwnName = name;
	}
	
	public String getBusinessName() { return businessName; }
	
	@Override
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	@Override
	public void setName(String name) {
		this.businessOwnName = name;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
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
	public String toString(){
		return ID + "," + businessName + "," + businessOwnName + "," + password + "," + address + "," + number;
	}

}
