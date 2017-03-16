package MainPackage;

import java.util.Date;


public class Employee  extends Person{
	
	private String position;

	
	public Employee(){
		super();
	}
	public Employee(String name,String number,String ID,String position){
		super(name,number,ID);
		this.position = position;
	}



	public void acceptWork() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
