package interfaces;

public interface Customer extends Person{
	public abstract Card getCard();
	public abstract void book();
	public abstract String toString();
	public abstract void print();
}
