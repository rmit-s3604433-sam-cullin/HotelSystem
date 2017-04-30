package MainPackage.Register;

import MainPackage.BookingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Object.Customer;
import Object.Person;

public class RegisterController {
	
	@FXML
	TextField newuserid;
	@FXML
	TextField newusername;
	@FXML
	TextField newuserpassword;
	@FXML
	TextField newusermobno;
	@FXML
	TextArea newuseraddress;
	@FXML
	Button Submit;
	@FXML
	Label invaliduserid;
	@FXML
	Label invalidusername;
	@FXML
	Label invaliduserpassword;
	@FXML
	Label invalidusermobno;
	@FXML
	Label invaliduseraddress;
	@FXML
	Label Success;
	@FXML
	Label iddatabase;
	
	public void onSubmit(ActionEvent event) throws IOException {
		
		String custid = newuserid.getText();
		String name = newusername.getText();
		String password = newuserpassword.getText();
		String address = newuseraddress.getText();
		String number = newusermobno.getText();
		
		Person nC = new Customer();
		
		//Input validate customer ID
		nC.setID(custid);
		if(nC.getID() == null) {				
			invaliduserid.setVisible(true);
		} else {
			invaliduserid.setVisible(false);
		}
		//Input validate customer Name
		nC.setName(name);
		if(nC.getName() == null) {			
			invalidusername.setVisible(true);
		} else {
			invalidusername.setVisible(false);
		}
		//Input validate customer Password
		nC.setPassword(password);
		if(nC.getPassword() == null){
			invaliduserpassword.setVisible(true);
		} else {
			invaliduserpassword.setVisible(false);
		}
		//Input validate customer Address
		nC.setAddress(address);
		if(nC.getAddress() == null){
			invaliduseraddress.setVisible(true);
		} else {
			invaliduseraddress.setVisible(false);
		}
		//Input validate customer Mobile Number
		nC.setNumber(number);
		if(nC.getNumber() == null){
			invalidusermobno.setVisible(true);
		} else {
			invalidusermobno.setVisible(false);
		}
		//If all input is valid, it stores the new customer data into the database
		if(!(nC.getID() == null) && !(nC.getName() == null) && !(nC.getPassword() == null) && !(nC.getNumber() == null)
				&& !(nC.getAddress() == null)){
			custid = "c" + nC.getID(); 
			if(databasecheck(custid) == 0) {
				iddatabase.setVisible(false);
				nC.addCustomer(nC);
				Success.setVisible(true);
				newuserid.setText("");
				newusername.setText("");
				newuserpassword.setText("");
				newusermobno.setText("");
				newuseraddress.setText("");
				BookingSystem.showLogin2();
			}
			else if(databasecheck(custid) == 1) {
				iddatabase.setVisible(true);
			}
		}
	}
	public int databasecheck(String ID) {
		
		Connection con = null;
		Statement statement = null;
		int i = 0;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			ResultSet customerSet = statement.executeQuery("SELECT custid FROM customer");		
			while(customerSet.next()) {
				if(ID.equals(customerSet.getString("custid"))) {
					i = 1;
				}
			}
			while(customerSet.next()) {
				if(!ID.equals(customerSet.getString("custid"))) {
					i = 0;
				}
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
		return i;
	}
}
