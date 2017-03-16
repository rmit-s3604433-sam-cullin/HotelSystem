package objects;
import java.util.Date;

import objects.Card;

public class Customer extends Person{
	private Card card;
	
	public Customer(String name, String email, String number, String ID, Date bDay,Card card) {
		super(name, email, number, ID, bDay);
		this.card = card;
	}

	public Card getCard() {
		return this.card;
	}

	public void book() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	


}
