package MainPackage.Login;

import Object.Person;
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
			BookingSystem.companyLogin = getCompnayType(ID);
			if(loginPasswordValidation(ID, password) == 1){
				// Launch Customer Menu
				BookingSystem.log.info("Customer Logged in");
				BookingSystem.showCustomerMenu();
			} else if(loginPasswordValidation(ID, password) == 2){
				// Launch Owner Menu
				BookingSystem.log.info("Owner Logged in");
				BookingSystem.showOwnerMenu();
			} else if(loginPasswordValidation(ID, password) == 3){
				// Launch Super User Menu
				BookingSystem.log.info("Super User Logged in");
				BookingSystem.showSuperUserMenu();
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
	public String getCompnayType(String id){
		Connection con = null;
		Statement statement = null;
		String ownerid = "";
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			ResultSet ownerSet = statement.executeQuery("SELECT ownerID FROM customer where custid ='"+id+"'");
			ownerid = ownerSet.getString("ownerID");
			con.close();
			BookingSystem.log.info("customer loged in under company:"+ownerid);
		} catch (SQLException e) {
			BookingSystem.log.error(e.toString());
			e.printStackTrace();
		}
		
		return ownerid;
	}
	public boolean loginIDValidation(String ID){
		Connection con = null;
		Statement statement = null;
		boolean id = false;		
		if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}") | ID.matches("[s][0-9]{3}")){	
			try{
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();	
				ResultSet ownerSet = statement.executeQuery("SELECT ownid FROM owner");
				ResultSet customerSet = statement.executeQuery("SELECT custid FROM customer");
				ResultSet superuserSet = statement.executeQuery("SELECT supid FROM superuser");
				if(customerSet.next() || ownerSet.next() || superuserSet.next()){
					BookingSystem.log.debug("ID found");
					id = true;
				}
				else {
					BookingSystem.log.debug("ID not found");
					id = false;
				}
			}catch (SQLException e1) {
				BookingSystem.log.error(e1.toString());
				e1.printStackTrace();
			} finally {
				if(statement != null) {
					try {
						statement.close();
					} catch (SQLException e1) {BookingSystem.log.error(e1.toString()); }
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e1) { BookingSystem.log.error(e1.toString());}
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
						BookingSystem.log.debug("Correct password");
						i = 2;
					}
				}
			}
			else if(ID.contains("c")){
				resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
				if(resultSet.next()){
					if(password.equals(resultSet.getString("password"))) {
						BookingSystem.log.debug("Correct password");
						Person.storeID(ID);
						i = 1;
					}
				}
			}
			else if(ID.contains("s")){
				resultSet = statement.executeQuery("SELECT password FROM superuser WHERE supid='" + ID + "'");
				if(resultSet.next()){
					if(password.equals(resultSet.getString("password"))) {
						BookingSystem.log.debug("Correct password");
						i = 3;
					}
				}
			}
		}catch (SQLException e){
			BookingSystem.log.error(e.toString());
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) { BookingSystem.log.error(e1.toString());}
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e1) { BookingSystem.log.error(e1.toString());}
		}
		return i;
	}
	public void onSignUp() throws IOException {
		BookingSystem.showRegisterMenu();
	}
}
