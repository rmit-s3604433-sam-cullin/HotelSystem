package MainPackage.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BusinessActivitiesController {
	
	//Drop down list for services
	//The list will print services data that reads from the business database
	ObservableList<String> serviceList = FXCollections.observableArrayList();
	//Combo box list for duration
	//Pre-set duration for owner to choose
	ObservableList<String> durationList = FXCollections.observableArrayList();
	Connection con = null;
	Statement statement = null;
	
	@FXML
	private ComboBox<String> services = new ComboBox<String>(serviceList);
	@FXML
	private ComboBox<String> duration = new ComboBox<String>(durationList);
	@FXML
	TextField ADDservices;
	@FXML
	TextField ADDduration;
	@FXML 
	Button confirmed;
	@FXML
	Label success;
	@FXML
	Label errorservices;
	@FXML
	Label errorduration;
	@FXML
	Label errordatabase;
	
	//When the page loads from Owner Menu, this function will run and get ready all
	//the drop down lists available
	@FXML
	private void initialize() {
		{
			//Read data from database and printing it out in the drop down lists
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				//Services Data
				ResultSet serviceSet = statement.executeQuery("SELECT DISTINCT Services FROM BusinessActivities");
				while(serviceSet.next()) {
					serviceList.add(serviceSet.getString("Services"));
					services.setItems(serviceList);
				}
				//Duration Data
				ResultSet durationSet = statement.executeQuery("SELECT DISTINCT Duration FROM BusinessActivities");
				while(durationSet.next()) {
					durationList.add(durationSet.getString("Duration"));
					duration.setItems(durationList);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e1) {
					}
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
				}
			}
		}
	}
	//This function was made to add the owner's choice of new business activities into
	//the business database
	@FXML
	private void addNewData() {
		
		success.setVisible(false);
		String services2 = services.getSelectionModel().getSelectedItem();
		String duration2 = duration.getSelectionModel().getSelectedItem();
		
		if(services2 == null && ADDservices.getText().equals("")) {
			errorservices.setVisible(true);
		}
		else{
			errorservices.setVisible(false);
		}
		if(duration2 == null && ADDduration.getText().equals("")) { 
			errorduration.setVisible(true);
		}
		else{
			errorduration.setVisible(false);
		}
		if(services2 != null && duration2 != null){
			if(databasecheck(services2, duration2) == 0) {
				errordatabase.setVisible(false);
				Connection con = null;
				Statement statement = null;
				{
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
		
						statement.executeUpdate("INSERT INTO BusinessActivities " + "VALUES ('" + services2 + "','" + duration2 + "')");
						success.setVisible(true);
						services.getSelectionModel().clearSelection();
						duration.getSelectionModel().clearSelection();
					} catch (Exception e) {
						System.err.println(e);
					} finally {
						if(statement != null) {
							try {
								statement.close();
							} catch (SQLException e) { }
						}
					}
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e) { }
					}
				}
			}
			else if(databasecheck(services2, duration2) == 1){
				errordatabase.setVisible(true);
			}
		}
		//Reads the services and duration text field 
		if(!ADDservices.getText().equals("") && !ADDduration.getText().equals("")) {
			if(databasecheck(ADDservices.getText(), ADDduration.getText()) == 0) {
				errordatabase.setVisible(false);
				Connection con = null;
				Statement statement = null;
				{
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						
						statement.executeUpdate("INSERT INTO BusinessActivities " + "VALUES ('" + ADDservices.getText() + "','" + ADDduration.getText() + "')");
						success.setVisible(true);
						ADDservices.setText("");
						ADDduration.setText("");
					} catch (Exception e) {
						System.err.println(e);
					} finally {
						if(statement != null) {
							try {
								statement.close();
							} catch (SQLException e) { }
						}
					}
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e) { }
					}
				}
			}
			else if((databasecheck(ADDservices.getText(), ADDduration.getText()) == 1)) {
				errordatabase.setVisible(true);
			}
		}
	}
	private int databasecheck(String service, String duration) {
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		int i = 0;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			
			resultSet1 = statement.executeQuery("SELECT * FROM BusinessActivities");
			while(resultSet1.next()) {
				if(service.equals(resultSet1.getString("Services"))){
					if(duration.equals(resultSet1.getString("Duration"))) {
						i = 1;
					}
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
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
