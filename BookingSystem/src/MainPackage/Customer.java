package MainPackage;
import java.util.Date;


public class Customer extends Person{

	
	public Customer(String name, String number, String ID, String Password) {
		super(name, number, ID,Password);
	}
	public Customer(String textfile){
		
	}

	
	public void book() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		System.out.println("name:" + this.getName() + "   number:" +this.getContact()+"   Password:"+ this.getPassword()+ "  ID:"+ this.getID());
		
	}
	@Override
	public String toString(){
		String userString = this.getName() + "," + this.getContact()+"'"+this.getID()+"'"+this.getPassword();
		return userString;
	}
	


}
