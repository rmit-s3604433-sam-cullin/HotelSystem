package mainpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import views.Menu;

public class Login {

	final static Scanner scan = new Scanner(System.in);
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public void loginMenu() throws IOException{
		Menu menu = new Menu();
		boolean IDCheck = false;
		String ID = "";
		while(true){
			System.out.println("Please enter User ID or 'exit': ");
			ID = scan.nextLine();
			if(loginIDValidation(ID) == 1){
				IDCheck = true;
				break;
			}						
			else if(ID.equals("exit")){
				System.out.println("Returning to main menu");
				menu.systemMenu();
				break;
			}
			else{
				System.out.println("Invalid ID");
			}
		}
		
		while(true){
			if(IDCheck == true){
				if(loginIDValidation(ID) == 1){
					System.out.println("Enter the password: ");
					String password = scan.nextLine();
					int i = loginPasswordValidation(ID,password);
					if(i == 1){
						System.out.println("Successful");
						menu.customerMenu();
						break;
					}
					else if(i == 2){
						menu.ownerMenu();
					}
					else {
						System.out.println("Invalid Password");
					}
				}
			}
		}	
	}

	
	public int loginIDValidation(String ID){
		int i = 0;		
		if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")){	
			try{
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();	
				ResultSet ownerSet = statement.executeQuery("SELECT ownid FROM owner");
				ResultSet customerSet = statement.executeQuery("SELECT custid FROM customer");		
				if(customerSet.next() || ownerSet.next()){
					i = 1;
				}
				else{
					i = 0;
				}			
	
			}catch (SQLException e1) {
				e1.printStackTrace();
			}		
		}
		return i;
	}
	
	public int loginPasswordValidation(String ID, String password){	
		int i = 0;	
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			//use string ID and password together
			if(ID.contains("o")){
				resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownid='" + ID + "'");		
				if(resultSet.next()){			
					if(password.equals(resultSet.getString("password"))) {
						i = 2;
					}
				}
			}
			else if(ID.contains("c")){
				resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
				if(resultSet.next()){
					if(password.equals(resultSet.getString("password"))) {
						i = 1;
					}
				}
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return i;
	}
	
	
}
