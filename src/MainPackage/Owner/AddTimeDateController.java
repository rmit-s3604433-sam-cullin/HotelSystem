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
				ResultSet empSet = statement.executeQuery("SELECT name FROM employee WHERE ownerID = '"+ BookingSystem.companyLogin + "'");
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
			if(databasecheck(empname, empday, emptime) != null) {
				errordatabase.setVisible(false);
				Connection con = null;
				Statement statement = null;
				{
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						ResultSet resultSet1 = statement.executeQuery("Select empid from employee where name ='"+empname+"'");
						String empid = resultSet1.getString("empid");
						/* SQL Statement */
						statement.executeUpdate("INSERT INTO workingTimeDate(`EmployeeID`, `Day`, `Time`, `ownerID`) VALUES ('" + empid + "','" + empday + "','" + emptime + "','" + BookingSystem.companyLogin + "')");
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
			}else{
				BookingSystem.log.info("adding working time failed");
				errordatabase.setVisible(true);
			}
		}
	}
	private String HandleDayOptions(RadioButton monday, RadioButton tuesday, RadioButton wednesday, RadioButton thursday, RadioButton friday, RadioButton saturday) {
		
		if(monday.isSelected()) {
			return ("Monday");
		}
		if(tuesday.isSelected()) {
			return ("Tuesday");
		}
		if(wednesday.isSelected()) {
			return ("Wednesday");
		}
		if(thursday.isSelected()) {
			return ("Thursday");
		}
		if(friday.isSelected()) {
			return ("Friday");
		}
		if(saturday.isSelected()) {
			return ("Saturday");
		}
		else {
			BookingSystem.log.error("selected day failed");
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
			BookingSystem.log.error("selected time failed");
			return null;
		}
	}
	private String databasecheck(String empname, String empday, String emptime) {
	
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		String i = null;
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			
			resultSet1 = statement.executeQuery("SELECT * FROM workingTimeDate inner join employee on employee.empid = workingTimeDate.EmployeeID where employee.name = '"+empname+"'");
			
			i = resultSet1.getString("empid");
			while(resultSet1.next()) {
					if(empday.equals(resultSet1.getString("Day"))) {
						if(emptime.equals(resultSet1.getString("Time"))) {
							BookingSystem.log.info("already working at that time");
							i = null;
						}
					}					
				
			}
		} catch (SQLException e){
			BookingSystem.log.error(e.toString());
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
