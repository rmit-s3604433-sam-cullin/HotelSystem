package MainPackage.Owner;

import java.io.IOException;

import MainPackage.BookingSystem;
import javafx.fxml.FXML;

public class OwnerMenuController {
	
	@SuppressWarnings("unused")
	private BookingSystem main;
	
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
	private void goWeeklySummary() throws IOException {
		BookingSystem.showWeeklySummary();
	}
	@FXML
	private void goLogout() throws IOException {
		BookingSystem.showLogin3();
	}
	@FXML
	private void goCreateBookingCustInfo() throws IOException {
		BookingSystem.showCreateBookingCustInfo();
	}
}