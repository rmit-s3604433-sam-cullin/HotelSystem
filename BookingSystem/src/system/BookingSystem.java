package system;



import dataManagers.DataBase;
import objects.Person;
import views.Menus;
public class BookingSystem {

	public final static DataBase database = new DataBase();
	private final static Menus menu = new Menus();
	public static void main(String[] args) {
	
		for(int i = 0;i > -1;){
		Person person = menu.login();
		int x = database.getPersonType(person);
		switch(x){
			case(1):
				
				break;
			case(2):
				
				break;
			case(3):
				
				break;
			default:
	
				break;
		}
		}
		
	}

}
