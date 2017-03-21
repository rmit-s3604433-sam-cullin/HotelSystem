package mainpackage;

public abstract class Person {
	protected String ID;
	protected String name;
	protected String password;
	protected String address;
	protected int number;

	public Person(){
	
	}
	public Person(String ID, String name, String password, String address, int number){
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
	public abstract void setNumber(int number);
	
	public String getID() { return ID; }
	public String getName() { return name; }
	public String getPassword() { return password; }
	public String getAddress() { return address; }
	public int getNumber() { return number; }
	
	public String toString(){
		return ID + "," + name + "," + password + "," + address + "," + number;
	}

}
