package MainPackage.Owner;

import Object.Customer;
import Object.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateBookingCustInfoController {

	@FXML
	TextField customername;
	@FXML
	TextField customernumber;
	@FXML
	TextArea customeraddress;
	@FXML
	Button next;
	@FXML
	Label invalidcustname;
	@FXML
	Label invalidcustnumber;
	@FXML
	Label invalidcustaddress;
	
	@FXML
	private void onNext() {
		
		if(customername.getText().equals("")) {
			invalidcustname.setVisible(true);
		}
		else {
			invalidcustname.setVisible(false);
		}
		if(customernumber.getText().equals("")) {
			invalidcustnumber.setVisible(true);
		}
		else {
			invalidcustnumber.setVisible(false);
		}
		if(customeraddress.getText().equals("")) {
			invalidcustaddress.setVisible(true);
		}
		else {
			invalidcustaddress.setVisible(false);
		}
		if(!customername.getText().equals("") && !customernumber.getText().equals("") && !customeraddress.getText().equals("")) {
			String name = customername.getText();
			String number = customernumber.getText();
			String address = customeraddress.getText();
			
			Person nC = new Customer();
			
			nC.setName(name);
			if(nC.getName() == null) {			
				invalidcustname.setVisible(true);
			} else {
				invalidcustname.setVisible(false);
			}
			nC.setNumber(number);
			if(nC.getNumber() == null){
				invalidcustnumber.setVisible(true);
			} else {
				invalidcustnumber.setVisible(false);
			}
			nC.setAddress(address);
			if(nC.getAddress() == null){
				invalidcustaddress.setVisible(true);
			} else {
				invalidcustaddress.setVisible(false);
			}
		}
	}
}
