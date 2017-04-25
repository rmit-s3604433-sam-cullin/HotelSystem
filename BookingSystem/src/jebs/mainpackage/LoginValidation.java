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
	
	//Owner ID Validation
	public boolean loginIDValidation(String ID){
		boolean id = false;		
		if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")){	
			try{
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();	
				ResultSet ownerSet = statement.executeQuery("SELECT ownid FROM owner");
				ResultSet customerSet = statement.executeQuery("SELECT custid FROM customer");		
				if(customerSet.next() || ownerSet.next()){
					id = true;
				}
	
			}catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				if(statement != null) {
					try {
						statement.close();
					} catch (SQLException e1) { }
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e1) { }
			}		
		}
		return id;
	}
	
	//Owner Password Validation
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
				} catch (SQLException e1) { }
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e1) { }
		}
		
		return i;
	}
	
	
}
