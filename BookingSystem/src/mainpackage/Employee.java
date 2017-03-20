package mainpackage;

public class Employee extends Person{
	
	private String name;
	private String age;
	private String contact;
	private String position;
	private String employeeid;
	
	public Employee(String name,String age,String contact,String title,String empid){
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.position = title;
		this.employeeid = empid;
	}

	public void acceptWork() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		System.out.println("name:"+this.name+" age:"+this.age+" conatact:"+this.contact+" position:"+this.position+" ID:"+this.employeeid);
		
	}
	@Override
	public String toString(){
		String userString = this.getName()+","+this.getAge()+","+this.getContact()+","+this.getPosition()+","+this.getID();
		
		return userString;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age;
	}
	public String getContact(){
		return contact;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String title) {
		this.position = title;
	}
	public String getEmployeeID() {
		return employeeid;
	}
	public void setEmployeeID(String empid){
		this.employeeid = empid;
	}
}
