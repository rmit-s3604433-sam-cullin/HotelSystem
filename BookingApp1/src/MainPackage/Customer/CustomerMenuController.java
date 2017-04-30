package MainPackage.Customer;

import java.io.IOException;

import MainPackage.BookingSystem;
import javafx.fxml.FXML;

public class CustomerMenuController {

	@FXML
	private void goLogout() throws IOException {
		BookingSystem.showLogin3();
	}
}
