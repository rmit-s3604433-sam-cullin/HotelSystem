package objects;
import java.util.Date;

public class Worker  extends Person{
	
	private String position;
	private String blerb;
	
	public Worker(String name,String email,String number,String ID,Date bDay,String position){
		super(name,email,number,ID,bDay);
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

	public String getBlerb() {
		return blerb;
	}

	public void setBlerb(String blerb) {
		this.blerb = blerb;
	}
	
}
