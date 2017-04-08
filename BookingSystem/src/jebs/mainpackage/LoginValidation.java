package jebs.mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidation {

	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
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
			} finally {
				if(statement != null) {
					try {
						statement.close();
						System.out.println("id state closed");
					} catch (SQLException e1) { }
				}
			}
			if(con != null) {
				try {
					con.close();
					System.out.println("id con closed");
				} catch (SQLException e1) { }
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
		finally {
			if(statement != null) {
				try {
					statement.close();
					System.out.println("id state closed");
				} catch (SQLException e1) { }
			}
		}
		if(con != null) {
			try {
				con.close();
				System.out.println("id con closed");
			} catch (SQLException e1) { }
		}
		
		return i;
	}
	
	
}
