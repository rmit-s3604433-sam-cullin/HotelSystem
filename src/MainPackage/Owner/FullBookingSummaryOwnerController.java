package MainPackage.Owner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainPackage.BookingSystem;
import Object.booking;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FullBookingSummaryOwnerController {
	
	private Connection con = null;
	private Statement statement = null;
	
	@FXML
	private TableView<booking> Orders;
	
	@FXML
	private TextField searchFeild;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private TableColumn<booking,String> Date;
	@FXML
	private TableColumn<booking,String> Time;
	@FXML
	private TableColumn<booking,String> Employee;
	@FXML
	private TableColumn<booking,String> Service;
	@FXML
	private TableColumn<booking,String> Customer;
	
	private final ObservableList<booking> dta = FXCollections.observableArrayList();
	
	@FXML
	private void initialize() {
		System.out.println("loading bookings");
		loadBookings("");
	}
	
	private void loadBookings(String search){
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			ResultSet bookingSet = statement.executeQuery("SELECT * FROM newbooking");
			if(!search.equals("")){
				bookingSet = statement.executeQuery("SELECT * FROM newbooking WHERE `bookingID` LIKE '"+search+"' or `date` LIKE '"+search+"' or `startTime` LIKE '"+search+"' or `empID` LIKE '"+search+"' or `servicesID` LIKE '"+search+"'");
			}
			while(bookingSet.next()) {
				System.out.println("loading bookings");
				BookingSystem.log.info("displaying booking history"+bookingSet.getString("bookingID"));
				String id = bookingSet.getString("bookingID");
				String date = bookingSet.getString("date");
				String time = bookingSet.getString("startTime");
				String employee = bookingSet.getString("empID");
				String servies = bookingSet.getString("servicesID");
				String customer = bookingSet.getString("customerNumber");
				booking booking = new booking(id,date,time,customer,employee,servies);
				dta.add(booking);
			}
			Orders.setItems(dta);
			Date.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().date));
			Time.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().startTime));
			Employee.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().empID));
			Customer.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().customerNumber));
			Service.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().serviesID));
			bookingSet.close();
			statement.close();
			con.close();
		} catch (SQLException e1) {
			BookingSystem.log.error(e1);
			e1.printStackTrace();
		} 
	}
	
	@FXML
	private void searchButonPressed() throws IOException {
		dta.clear();
		String search = "";
		if(this.searchFeild.getText() != null){
			search = this.searchFeild.getText();
		}
		System.out.println("searching for: "+search);
		this.loadBookings(searchFeild.getText());
	}
	
	
}
