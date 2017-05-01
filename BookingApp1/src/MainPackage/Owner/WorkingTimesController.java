package MainPackage.Owner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.prism.paint.Color;

import MainPackage.BookingSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;


public class WorkingTimesController {
	Pane[][] array;
	
	ObservableList<String> empList = FXCollections.observableArrayList();
	Connection con = null;
	Statement statement = null;
	
	@FXML
	public ComboBox<String> employee = new ComboBox<String>(empList);
	
	@FXML
	Pane oneMonday;
	
	@FXML
	Pane twoMonday;
	
	@FXML
	Pane threeMonday;
	
	@FXML
	Pane fourMonday;
	
	@FXML
	Pane oneTuesday;
	
	@FXML
	Pane twoTuesday;
	
	@FXML
	Pane threeTuesday;
	
	@FXML
	Pane fourTuesday;
	
	@FXML
	Pane oneWednesday;
	
	@FXML
	Pane twoWednesday;
	
	@FXML
	Pane threeWednesday;
	
	@FXML
	Pane fourWednesday;
	
	@FXML
	Pane oneThursday;
	
	@FXML
	Pane twoThursday;
	
	@FXML
	Pane threeThursday;
	
	@FXML
	Pane fourThursday;
	
	@FXML
	Pane oneFriday;
	
	@FXML
	Pane twoFriday;
	
	@FXML
	Pane threeFriday;
	
	@FXML
	Pane fourFriday;
	
	@FXML
	Pane oneSaterday;
	
	@FXML
	Pane twoSaterday;
	
	@FXML
	Pane threeSaterday;
	
	@FXML
	Pane fourSaterday;
	
	
	@FXML
	private void initialize() {
		{
			array = new Pane[][]{{oneMonday,twoMonday,threeMonday,fourMonday},
				{oneTuesday,twoTuesday,threeTuesday,fourTuesday},
				{oneWednesday,twoWednesday,threeWednesday,fourWednesday},
				{oneThursday,twoThursday,threeThursday,fourThursday},
				{oneFriday,twoFriday,threeFriday,fourFriday},
				{oneSaterday,twoSaterday,threeSaterday,fourSaterday}};
			
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				ResultSet empSet = statement.executeQuery("SELECT empid, name FROM employee");
				while(empSet.next()) {
					empList.add(empSet.getString("name"));
					employee.setItems(empList);
					
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
	
	@FXML
	private void onEmployeeSelection() {
		String empname = employee.getSelectionModel().getSelectedItem();
		for (int i = 0; i < 6; i++){
			for(int j = 0 ; j < 4; j++){
				array[i][j].setStyle("-fx-background-color: lightGray;");
				array[i][j].setStyle("-fx-border-color: #000000;");
			}
			
		}
		System.out.println("running selection");
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			ResultSet empSet = statement.executeQuery("SELECT day , Time FROM workingTimeDate WHERE EmployeeID == '"+empname+"'");
			while(empSet.next()) {
				int timeNumber = getTimeNumber(empSet.getString("Time"));
				int	DayNumber = getDayNumber(empSet.getString("day"));
				if(timeNumber != 10 && DayNumber != 10 ){
					System.out.println("working the color change should work");
					
					array[DayNumber][timeNumber].setStyle("-fx-background-color: green");
					//array[DayNumber][timeNumber].setStyle("-fx-border-color: #000000;");
					
				}
				employee.setItems(empList);
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
	}
	
	
	private int getTimeNumber(String x){
		switch(x){
			case "8am-10am":
				return 0;
			case "10am-12am":
				return 1;
			case "1pm-3pm":
				return 2;
			case "3pm-5pm":
				return 3;
		}
		return 10;
	}
	
	private int getDayNumber(String x){
		switch(x){
		case "Monday":
			return 0;
		case "Tuesday":
			return 1;
		case "Wedneday":
			return 2;
		case "Thursday":
			return 3;
		case "Friday":
			return 4;
		case "Saturday":
			return 5;
			
	}
	return 10;
		
		
	}
	

}
