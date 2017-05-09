package MainPackage.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainPackage.BookingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {
	
	@SuppressWarnings("unused")
	private BookingSystem main;
	@FXML
	Label login;
	@FXML
	TextField userid;
	@FXML
	PasswordField userpassword;
	@FXML
	Button submit;
	@FXML
	Label regLabel;
	@FXML
	Hyperlink regText;
		
	public void onLogin(ActionEvent event) throws IOException {
		
		String ID = userid.getText();
		String password = userpassword.getText();
		
		
		if(loginIDValidation(ID) == true){
			if(loginPasswordValidation(ID, password) == 1){
				// Launch Customer Menu
				BookingSystem.log.info("Customer Logged in");
				BookingSystem.showCustomerMenu();
			} else if(loginPasswordValidation(ID, password) == 2){
				// Launch Owner Menu
				BookingSystem.log.info("Owner Logged in");
				BookingSystem.showOwnerMenu();
			} else {
				loginError();
				userid.setText("");
				userpassword.setText("");
			}
		} else if (loginIDValidation(ID) == false){
			// Incorrect user name or password
			loginError();
			userid.setText("");
			userpassword.setText("");
		}
	}
	public boolean loginIDValidation(String ID){
		Connection con = null;
		Statement statement = null;
		boolean id = false;		
		if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")){	
			try{
				con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
				statement = con.createStatement();	
				ResultSet ownerSet = statement.executeQuery("SELECT ownid FROM owner");
				ResultSet customerSet = statement.executeQuery("SELECT custid FROM customer");		
				if(customerSet.next() || ownerSet.next()){
					BookingSystem.log.debug("ID found");
					id = true;
				}
				else {
					BookingSystem.log.debug("ID not found");
					id = false;
				}
			}catch (SQLException e1) {
				BookingSystem.log.error(e1.toString());
				e1.printStackTrace();
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
		}
		return id;
	}
	public int loginPasswordValidation(String ID, String password){	
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int i = 0;	
		try{
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			//use string ID and password together
			if(ID.contains("o")){
				resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownid='" + ID + "'");		
				if(resultSet.next()){			
					if(password.equals(resultSet.getString("password"))) {
						BookingSystem.log.debug("Correct password");
						i = 2;
					}
				}
			}
			else if(ID.contains("c")){
				resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
				if(resultSet.next()){
					if(password.equals(resultSet.getString("password"))) {
						BookingSystem.log.debug("Correct password");
						i = 1;
					}
				}
			}
		}catch (SQLException e){
			BookingSystem.log.error(e.toString());
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) { BookingSystem.log.error(e1.toString());}
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e1) { BookingSystem.log.error(e1.toString());}
		}
		return i;
	}
	public void onSignUp() throws IOException {
		BookingSystem.showRegisterMenu();
	}
	public static void loginError() {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Access Denied");
		window.setMinWidth(50);
		
		Label label = new Label();
		label.setText("Username or password entered was incorrect.");
		label.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-text-fill: #E5E5E5;");
		label.setLayoutX(10);
		label.setLayoutY(12);
		
		Button closeButton = new Button("Close");
		closeButton.setStyle("-fx-font-family: 'Varela Round'; -fx-background-radius: 3; -fx-background-color: #10EE99; "
				+ "-fx-padding: 5 15 5 15; -fx-effect: innershadow(one-pass-box, #2B443A, 7, 0.3, 0, -1);");
		closeButton.setLayoutX(110);
		closeButton.setLayoutY(37);
		closeButton.setOnAction(e -> window.close());
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #2B303A");
		layout.getChildren().addAll(label,closeButton);
		//layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 280, 75);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		window.setScene(scene);
		window.showAndWait();
		
	}
}
