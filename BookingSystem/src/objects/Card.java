package objects;

public class Card {
	private String cardNumber;
	private String cardPin;
	
	
	public Card(String cardNumber, String cardPin) {
		this.setCardNumber(cardNumber);
		this.cardPin = cardPin;
	}


	public void print() {
		// TODO Auto-generated method stub
		
	}


	public String getCardPin() {
		return cardPin;
	}


	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
