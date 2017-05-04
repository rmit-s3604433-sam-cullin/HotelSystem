package MainPackage.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;

import Object.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.Callback;

public class CreateBookingDetailsController {

	ObservableList<String> serviceList = FXCollections.observableArrayList();
	ObservableList<String> timeList = FXCollections.observableArrayList();
	ObservableList<String> empList = FXCollections.observableArrayList();
	
	@FXML
	private DatePicker date;
	@FXML
	public ComboBox<String> service = new ComboBox<String>(serviceList);
	@FXML
	public ComboBox<String> time = new ComboBox<String>(timeList);
	@FXML
	public ComboBox<String> employee = new ComboBox<String>(empList);
	@FXML
	Label invaliddate;
	@FXML
	Label invalidservice;
	@FXML
	Label invalidtime;
	@FXML
	Label invalidemployee;
	@FXML
	Label success;
	
	//This function is to initialize the Services section whenever the Booking page is called in.
	@FXML
	private void initialize() {
		
		date.setDayCellFactory(dayCellFactory);
		Connection con = null;
		Statement statement = null;
		{
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				ResultSet serviceSet = statement.executeQuery("SELECT Services FROM BusinessActivities");
				while(serviceSet.next()) {
					serviceList.add(serviceSet.getString("Services"));
					service.setItems(serviceList);
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
	//This function main idea is that whenever the owner changes the date, it will launch the Time section
	//according to the chosen date.
	@FXML
	public void launchTime() {
		timeList.clear();
		time.setItems(timeList);
		empList.clear();
		employee.setItems(empList);
		LocalDate date2 = date.getValue();
		String date3 = date2.getDayOfWeek().toString();
		Connection con = null;
		Statement statement = null;
		{
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				ResultSet timeSet = statement.executeQuery("SELECT DISTINCT Day, Time FROM workingTimeDate");
				while(timeSet.next()) {
					if(date3.equals(timeSet.getString("Day"))) {
						timeList.add(timeSet.getString("Time"));
						time.setItems(timeList);
					}
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
	//This function is to launch the Employee section according to the time chosen at the Time section.
	@FXML
	public void launchEmployee() {
		empList.clear();
		employee.setItems(empList);
		LocalDate date2 = date.getValue();
		String date3 = date2.getDayOfWeek().toString();
		String custtime = time.getSelectionModel().getSelectedItem();
		Connection con = null;
		Statement statement = null;
		{
			try {
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();
				ResultSet empSet = statement.executeQuery("SELECT DISTINCT Time, Day, EmployeeName FROM workingTimeDate");
				while(empSet.next()) {
					if(custtime.equals(empSet.getString("Time"))) {
						if(date3.equals(empSet.getString("Day"))) {
							empList.add(empSet.getString("EmployeeName"));
							employee.setItems(empList);
						}
					}
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
	//This function will initiate when the user clicks on the Submit button.
	@FXML
	private void onSubmit() {
		
		//All labels will be set to invisible
		success.setVisible(false);
		invaliddate.setVisible(false);
		invalidservice.setVisible(false);
		invalidtime.setVisible(false);
		invalidemployee.setVisible(false);
		//Get value from all menu choice
		LocalDate date2 = date.getValue();
		String custservice = service.getSelectionModel().getSelectedItem();
		String custtime = time.getSelectionModel().getSelectedItem();
		String custemployee = employee.getSelectionModel().getSelectedItem();
		
		//Error validate to check whether does all menu choice has a value in them
		if(date2 == null) {
			invaliddate.setVisible(true);
		}
		else {
			invaliddate.setVisible(false);
		}
		if(custservice == null) {
			invalidservice.setVisible(true);
		}
		else {
			invalidservice.setVisible(false);
		}
		if(custtime == null) {
			invalidtime.setVisible(true);
		}
		else {
			invalidtime.setVisible(false);
		}
		if(custemployee == null) {	
			invalidemployee.setVisible(true);
		}
		else {
			invalidemployee.setVisible(false);
		}
		//When all menu choice has a value
		if(date2 != null && custservice != null && custtime != null && custemployee != null) {
			//The system will check which function in person does not have an empty data
			if(Person.retrieveIDName() == null) {
				if(Person.retrieveNameNumAddress() != null) {
					//New string array to convert the incoming string array from other function under Person class
					//from Object folder
					String[] customer = Person.retrieveNameNumAddress();
					//Extract all data from the array
					String name = customer[0];
					String number = customer[1];
					String address = customer[2];
					//Validation check the contact number with the database
					//If there is no similar contact number
					if(databasecheckMobNo(number) == 0) {
						Connection con = null;
						Statement statement = null;
						{
							//Create connection with the business database
							try {
								con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
								statement = con.createStatement();
								//SQL query to insert all data into their respective table
								statement.executeUpdate("INSERT INTO customer(`name`, `address`, `number`) VALUES ('" + name + "','" + address + "','" + number + "')");
								statement.executeUpdate("INSERT INTO newbooking(`date`, `time`, `customerNumber`, `empName`, `servicesName`) VALUES ('" + date2 + "','" + custtime + "','" + number +  "','" + custemployee + "','" + custservice + "')");
								//If insert success, it will print out a success label and clear all menu choices
								success.setVisible(true);
								date.setValue(null);
								service.getSelectionModel().clearSelection();
								time.getSelectionModel().clearSelection();
								employee.getSelectionModel().clearSelection();
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
					//If there is a similar contact number exists in the customer table
					else if(databasecheckMobNo(number) == 1){
						Connection con = null;
						Statement statement = null;
						{
							//Create connection with the business database
							try {
								con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
								statement = con.createStatement();
								//SQL query to insert the data only into the booking table
								statement.executeUpdate("INSERT INTO newbooking(`date`, `time`, `customerNumber`, `empName`, `servicesName`) VALUES ('" + date2 + "','" + custtime + "','" + number +  "','" + custemployee + "','" + custservice + "')");
								//If insert success, it will print out a success label and clear all menu choices
								success.setVisible(true);
								date.setValue(null);
								service.getSelectionModel().clearSelection();
								time.getSelectionModel().clearSelection();
								employee.getSelectionModel().clearSelection();
						
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
				}
			}
			//This section is when owner uses the customer ID and Name field to do the booking
			else if(Person.retrieveIDName() != null) {
				if(Person.retrieveNameNumAddress() == null) {
					//A new string is created to get the value from another function under Person class from Object folder
					String ID = Person.retrieveIDName();
					Connection con = null;
					Statement statement = null;
					{
						//Create connection with the business database
						try {
							con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
							statement = con.createStatement();
							//SQL statement to get the mobile number that matches the customer ID input by owner at the 
							//beginning of the booking
							ResultSet custSet = statement.executeQuery("SELECT custid, number FROM customer");
							while(custSet.next()) {
								if(ID.equals(custSet.getString("custid"))) {
									String custnumber = custSet.getString("number");
									//SQL statement to insert all data into the booking table
									statement.executeUpdate("INSERT INTO newbooking(`date`, `time`, `customerNumber`, `empName`, `servicesName`) VALUES ('" + date2 + "','" + custtime + "','" + custnumber +  "','" + custemployee + "','" + custservice + "')");
									//If insert success, it will print out a success label and clear all menu choices
									success.setVisible(true);
									date.setValue(null);
									service.getSelectionModel().clearSelection();
									time.getSelectionModel().clearSelection();
									employee.getSelectionModel().clearSelection();
								}
							}
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
			}
		}
	}
	//This function is created to Duplicate check the input Mobile Number with the business
	//database customer table number field, if the number exists already, it will return 1, else 0.
	private int databasecheckMobNo(String number) {
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		int i = 0; 
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();	
			
			resultSet1 = statement.executeQuery("SELECT number FROM customer");
			while(resultSet1.next()) {
				if(number.equals(resultSet1.getString("number"))){
						i = 1;
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
	//This section is to initialize the Date Picker to disable all past dates from today onwards.
	Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
	    public DateCell call(final DatePicker datePicker) {
	
	       return new DateCell() {
	            @Override
	            public void updateItem(LocalDate item, boolean empty) {
	
	                // Must call super
	                super.updateItem(item, empty);
	              
	                // Show Weekends in blue color
	                LocalDate date = LocalDate.from(item);
	                if(date.isBefore(LocalDate.now())) {
	                	 setDisable(true);
	                     setStyle("-fx-background-color: #EEEEEE;");
	                }
	                DayOfWeek day = DayOfWeek.from(item);
	                if(day == DayOfWeek.SUNDAY) {
	                	 setDisable(true);
	                     setStyle("-fx-background-color: #EEEEEE;");
	                }
	            }
	        };
	    }
	};
}
