package objects;
import java.util.Date;

import interfaces.Card;

public class Customer extends Person implements interfaces.Customer{
	private Card card;
	
	public Customer(String name, String email, String number, String ID, Date bDay,Card card) {
		super(name, email, number, ID, bDay);
		this.card = card;
	}

	@Override
	public Card getCard() {
		return this.card;
	}

	@Override
	public void book() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	


}
