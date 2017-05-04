package MainPackage.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainPackage.BookingSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddTimeDateController {

	ObservableList<String> empList = FXCollections.observableArrayList();
	Connection con = null;
	Statement statement = null;
	
	@FXML
	public ComboBox<String> employee = new ComboBox<String>(empList);
	@FXML
	RadioButton monday;
	@FXML
	RadioButton tuesday;
	@FXML
	RadioButton wednesday;
	@FXML
	RadioButton thursday;
	@FXML
	RadioButton friday;
	@FXML
	RadioButton saturday;
	@FXML
	RadioButton first;
	@FXML
	RadioButton second;
	@FXML
	RadioButton third;
	@FXML
	RadioButton fourth;
	@FXML
	Button confirmation;
	@FXML
	Label erroremp;
	@FXML
	Label success;
	@FXML
	Label errorday;
	@FXML
	Label errortime;
	@FXML
	Label errordatabase;
	@FXML
	ToggleGroup Day;
	@FXML
	ToggleGroup time;
	
	@FXML
	private void initialize() {
		{
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				ResultSet empSet = statement.executeQuery("SELECT name FROM employee");
				while(empSet.next()) {
					empList.add(empSet.getString("name"));
					employee.setItems(empList);
				}
			} catch (SQLException e1) {
				BookingSystem.log.error(e1.toString());
				e1.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e1) {
						BookingSystem.log.error(e1.toString());
					}
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					BookingSystem.log.error(e1.toString());
				}
			}
		}
	}
	@FXML
	public void onConfirmation() {
		
		success.setVisible(false);
		String empname = employee.getSelectionModel().getSelectedItem();
		String empday = HandleDayOptions(monday, tuesday, wednesday, thursday, friday, saturday);
		String emptime = HandleTimeOptions(first, second, third, fourth);
		
		if(empname == null) {
			erroremp.setVisible(true);
		}
		else {
			erroremp.setVisible(false);
		}
		if(empday == null) {
			errorday.setVisible(true);
		} 
		else {
			errorday.setVisible(false);
		}
		if(emptime == null) {
			errortime.setVisible(true);
		}
		else {
			errortime.setVisible(false);
		}
		if(empname != null && empday != null && emptime != null) {
			if(databasecheck(empname, empday, emptime) == 0) {
				errordatabase.setVisible(false);
				Connection con = null;
				Statement statement = null;
				{
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						
						/* SQL Statement */
						statement.executeUpdate("INSERT INTO workingTimeDate(`EmployeeName`, `Day`, `Time`) VALUES ('" + empname + "','" + empday + "','" + emptime + "')");
						success.setVisible(true);
						employee.getSelectionModel().clearSelection();
						Day.selectToggle(null);
						time.selectToggle(null);
					} catch (Exception e) {
						BookingSystem.log.error(e.toString());
							System.err.println(e);
					} finally {
						if(statement != null) {
							try {
								statement.close();
							} catch (SQLException e) { BookingSystem.log.error(e.toString());}
						}
					}
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e) {BookingSystem.log.error(e.toString()); }
					}
				}
			}
			else if(databasecheck(empname, empday, emptime) == 1){
				errordatabase.setVisible(true);
			}
		}
	}
	private String HandleDayOptions(RadioButton monday, RadioButton tuesday, RadioButton wednesday, RadioButton thursday, RadioButton friday, RadioButton saturday) {
		
		if(monday.isSelected()) {
			return ("MONDAY");
		}
		if(tuesday.isSelected()) {
			return ("TUESDAY");
		}
		if(wednesday.isSelected()) {
			return ("WEDNESDAY");
		}
		if(thursday.isSelected()) {
			return ("THURSDAY");
		}
		if(friday.isSelected()) {
			return ("FRIDAY");
		}
		if(saturday.isSelected()) {
			return ("SATURDAY");
		}
		else {
			return null;
		}
	}
	private String HandleTimeOptions(RadioButton first, RadioButton second, RadioButton third, RadioButton fourth) {
		
		if(first.isSelected()) {
			return ("8am-10am");
		}
		if(second.isSelected()) {
			return ("10am-12pm");
		}
		if(third.isSelected()) {
			return ("1pm-3pm");
		}
		if(fourth.isSelected()) {
			return ("3pm-5pm");
		}
		else {
			return null;
		}
	}
	private int databasecheck(String empname, String empday, String emptime) {
	
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		int i = 0;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			
			resultSet1 = statement.executeQuery("SELECT * FROM workingTimeDate");
			while(resultSet1.next()) {
				if(empname.equals(resultSet1.getString("EmployeeName"))){
					if(empday.equals(resultSet1.getString("Day"))) {
						if(emptime.equals(resultSet1.getString("Time"))) {
							i = 1;
						}
					}					
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
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
		return i;
	}
}
