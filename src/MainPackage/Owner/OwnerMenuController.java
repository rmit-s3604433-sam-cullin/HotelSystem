package MainPackage.Owner;

import java.io.IOException;

import MainPackage.BookingSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OwnerMenuController {
	static Label connector;
	
	@FXML
	private void initialize() {
		connector = new Label();
		connector.setText(BookingSystem.companyname);
		businessname.textProperty().bindBidirectional(connector.textProperty());
	}
	@SuppressWarnings("unused")
	private BookingSystem main;
	
	
	@FXML
	Label businessname;
	
	@FXML
	Label businessname1;
	
	@FXML
	public void updatename() throws IOException{
		
	}
	@FXML
	private void goAddEmployee() throws IOException {
		BookingSystem.showAddEmployee();
	}
	@FXML
	private void goAddTimeDate() throws IOException {
		BookingSystem.showAddTimeDate();
	}
	@FXML
	private void goBusinessActivities() throws IOException {
		BookingSystem.showBusinessActivities();
	}
	@FXML
	private void goBookingSummary() throws IOException {
		BookingSystem.showBookingSummaryOwner();
	}
	@FXML
	private void goLogout() throws IOException {
		BookingSystem.showLogin3();
	}
	@FXML
	private void goCreateBookingCustInfo() throws IOException {
		BookingSystem.showCreateBookingCustInfo();
	}
	@FXML
	private void showWorkingTimeDate() throws IOException {
		BookingSystem.showWorkingTimes();
	}
	@FXML
	private void goSettings() throws IOException {
		BookingSystem.showSettings();
	}
			
}