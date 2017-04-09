package jebs.object;

//Person class that contains all basic attributes of a person
public abstract class Person {
	protected String ID;
	protected String name;
	protected String password;
	protected String address;
	protected String number;

	public Person(){
	
	}
	public Person(String ID, String name, String password, String address, String number){
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.address = address;
		this.number = number;

	}
	public abstract void setID(String ID);
	public abstract void setName(String name);
	public abstract void setPassword(String password);
	public abstract void setAddress(String address);
	public abstract void setNumber(String number);
	
	public String getID() { return ID; }
	public String getName() { return name; }
	public String getPassword() { return password; }
	public String getAddress() { return address; }
	public String getNumber() { return number; }
	
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}
	public void addCustomer(Person nC) {
		// TODO Auto-generated method stub
		
	}

}
