package MainPackage;




public class Employee  extends Person{
	
	private String name;
	private String position;
	private String age;
	private String empid;
	private String contact;
	
	public Employee(String name,String age,String contact,String title,String empid){
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.position = title;
		this.empid = empid;
	}



	public void acceptWork() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	public String getName1() {
		return name;
	}
	public void setName1(String name) {
		this.name = name;
	}
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age;
	}
	public String getContact1(){
		return contact;
	}
	public void setContact1(String contact){
		this.contact = contact;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String title) {
		this.position = title;
	}
	public String getEmployeeID() {
		return empid;
	}
	public void setEmployeeID(String empid){
		this.empid = empid;
	}

	
}
