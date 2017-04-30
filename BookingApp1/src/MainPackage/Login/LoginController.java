package MainPackage.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainPackage.BookingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	@SuppressWarnings("unused")
	private BookingSystem main;
	@FXML
	TextField userid;
	@FXML
	PasswordField userpassword;
	@FXML
	Button login;
	@FXML
	Label invaliduserid;
	@FXML
	Label invaliduserpass;
		
	public void onLogin(ActionEvent event) throws IOException {
		
		String ID = userid.getText();
		String password = userpassword.getText();
		
		if(loginIDValidation(ID) == true){
			if(loginPasswordValidation(ID, password) == 1){
				// Launch Customer Menu
				BookingSystem.showCustomerMenu();
			} else if(loginPasswordValidation(ID, password) == 2){
				// Launch Owner Menu
				BookingSystem.showOwnerMenu();
			} else {
				invaliduserid.setVisible(true);
				invaliduserpass.setVisible(true);
				userid.setText("");
				userpassword.setText("");
			}
		} else if (loginIDValidation(ID) == false){
			// Incorrect user name or password
			invaliduserid.setVisible(true);
			invaliduserpass.setVisible(true);
			userid.setText("");
			userpassword.setText("");
		}
	}
	public boolean loginIDValidation(String ID){
		Connection con = null;
		Statement statement = null;
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
				else {
					id = false;
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
	public int loginPasswordValidation(String ID, String password){	
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
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
	public void onSignUp() throws IOException {
		BookingSystem.showRegisterMenu();
	}
}
