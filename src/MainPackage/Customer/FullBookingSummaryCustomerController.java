package MainPackage.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import MainPackage.BookingSystem;
import Object.Person;
import Object.booking;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FullBookingSummaryCustomerController {
	
	private Connection con = null;

	
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
	private TableColumn<booking,String> Status;
	
	private final ObservableList<booking> dta = FXCollections.observableArrayList();
	
	@FXML
	private void initialize() {
		System.out.println("loading bookings");
		loadBookings("");
	}
	
	private void loadBookings(String search){
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			
			//SQL statement to get the mobile number that matches the logged in customer ID at the 
			//beginning of the booking
			
			ResultSet custSet = con.createStatement().executeQuery("SELECT number FROM customer Where customer.custID = '" + Person.retrieveID()+"' and customer.ownerID = '"+BookingSystem.companyLogin+"'");
			String customerNumber = custSet.getString("number");
			custSet.close();
			
			
			
			ResultSet bookingSet = con.createStatement().executeQuery("SELECT * FROM newbooking where newbooking.customerNumber = '"+customerNumber+"'");
			if(!search.equals("")){
				bookingSet = con.createStatement().executeQuery("SELECT * FROM newbooking WHERE `bookingID` LIKE '"+search+"' or `date` LIKE '"+search+"' or `startTime` LIKE '"+search+"' or `empID` LIKE '"+search+"' or `servicesID` LIKE '"+search+"' or `status` LIKE '"+search+"'  and newbooking.customerNumber = '" + customerNumber+"'");
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
				String status = bookingSet.getString("status");
				booking booking = new booking(id,date,time,customer,employee,servies,status);
				dta.add(booking);
			}
			Orders.setItems(dta);
			Date.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().date));
			Time.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().startTime));
			Employee.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().empID));
			Service.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().serviesID));
			Status.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().status));
			bookingSet.close();
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
	
	@FXML
	private void removeButtonPressed(){
		booking selectedOrder = Orders.getSelectionModel().getSelectedItem();
		try {
			selectedOrder.updateStatus("c");
			BookingSystem.log.info(selectedOrder.bookingID +" as been cancelled");
		} catch (SQLException e) {
			BookingSystem.log.error(e.toString());
		}
	}
	
}
