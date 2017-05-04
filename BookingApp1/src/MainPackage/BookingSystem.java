package MainPackage;

import java.io.IOException;

import MainPackage.Login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BookingSystem extends Application {

	private static Stage primaryStage;
	private static Stage registerstage;
	private static Stage loginStage;
	private static BorderPane mainlayout;
	private static AnchorPane startinglayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		BookingSystem.loginStage = primaryStage;
		BookingSystem.loginStage.setTitle("Booking App");
		showLogin();
	}
	public static void showLogin() throws IOException {
		
		Label title = new Label("Login");
		title.setStyle("-fx-font-family: 'Gruppo'; -fx-font-weight: 800; -fx-font-size: 60; -fx-text-fill: #D8D8D8;");
		title.setLayoutX(125);
		title.setLayoutY(75);
		
		TextField userID = new TextField();
		userID.setPromptText("Enter user ID");
		userID.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		userID.setLayoutX(80);
		userID.setLayoutY(160);
		
		PasswordField password = new PasswordField();
		password.setPromptText("Enter password");
		password.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		password.setLayoutX(80);
		password.setLayoutY(200);
		
		Button button = new Button("Login");
		button.setStyle("-fx-font-family: 'Varela Round'; -fx-background-radius: 3; -fx-background-color: #10EE99; "
				+ "-fx-padding: 6 25 6 25; -fx-effect: innershadow(one-pass-box, #2B443A, 7, 0.3, 0, -1);");
		button.setLayoutX(163);
		button.setLayoutY(250);
		button.setOnAction(e -> {
			String id = userID.getText();
			String pass = password.getText();
			
			//Input validates user input data with system and database
			LoginController lc = new LoginController();
			//Check user input if its Owner or Customer
			if(lc.loginIDValidation(id)){
				if(lc.loginPasswordValidation(id, pass) == 1){
					// Customer Menu
					try {
						showCustomerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if(lc.loginPasswordValidation(id, pass) == 2){
					// Owner Menu
					System.out.println("Owner");
					try {
						showOwnerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					// Incorrect user name or password
					loginError();
				}
			} else {
				// Incorrect user name or password
				loginError();
			}
		});
		
		Label regLabel = new Label();
		regLabel.setText("Not registered yet?");
		regLabel.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-text-fill: #D8D8D8;");
		regLabel.setLayoutX(110);
		regLabel.setLayoutY(325);
		
		Hyperlink regText = new Hyperlink();
		regText.setText("Click here!");
		regText.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 13; -fx-text-fill: #10EE99; -fx-border-color: transparent;");
		regText.setLayoutX(225);
		regText.setLayoutY(321);
		regText.setOnAction(e -> {
			try {
				showRegisterMenu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #2B303A");
		layout.getChildren().addAll(title, userID, password, button,regLabel,regText);
		
		Scene scene = new Scene(layout, 400, 350);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
		layout.requestFocus();
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
	
	public static void showLogin2() throws IOException {
		registerstage.close();
		Label title = new Label("Login");
		title.setStyle("-fx-font-family: 'Gruppo'; -fx-font-weight: 800; -fx-font-size: 60; -fx-text-fill: #D8D8D8;");
		title.setLayoutX(125);
		title.setLayoutY(75);
		
		TextField userID = new TextField();
		userID.setPromptText("Enter user ID");
		userID.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		userID.setLayoutX(80);
		userID.setLayoutY(160);
		
		PasswordField password = new PasswordField();
		password.setPromptText("Enter password");
		password.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		password.setLayoutX(80);
		password.setLayoutY(200);
		
		Button button = new Button("Login");
		button.setStyle("-fx-font-family: 'Varela Round'; -fx-background-radius: 3; -fx-background-color: #10EE99; "
				+ "-fx-padding: 6 25 6 25; -fx-effect: innershadow(one-pass-box, #2B443A, 7, 0.3, 0, -1);");
		button.setLayoutX(163);
		button.setLayoutY(250);
		button.setOnAction(e -> {
			String id = userID.getText();
			String pass = password.getText();
			
			//Input validates user input data with system and database
			LoginController lc = new LoginController();
			//Check user input if its Owner or Customer
			if(lc.loginIDValidation(id)){
				if(lc.loginPasswordValidation(id, pass) == 1){
					// Customer Menu
					try {
						showCustomerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if(lc.loginPasswordValidation(id, pass) == 2){
					// Owner Menu
					System.out.println("Owner");
					try {
						showOwnerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					// Incorrect user name or password
					loginError();
				}
			} else {
				// Incorrect user name or password
				loginError();
			}
		});
		
		Label regLabel = new Label();
		regLabel.setText("Not registered yet?");
		regLabel.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-text-fill: #D8D8D8;");
		regLabel.setLayoutX(110);
		regLabel.setLayoutY(325);
		
		Hyperlink regText = new Hyperlink();
		regText.setText("Click here!");
		regText.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 13; -fx-text-fill: #10EE99; -fx-border-color: transparent;");
		regText.setLayoutX(225);
		regText.setLayoutY(321);
		regText.setOnAction(e -> {
			try {
				showRegisterMenu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #2B303A");
		layout.getChildren().addAll(title, userID, password, button,regLabel,regText);
		
		Scene scene = new Scene(layout, 400, 350);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
		layout.requestFocus();
	}
	public static void showLogin3() throws IOException {
		primaryStage.close();
		Label title = new Label("Login");
		title.setStyle("-fx-font-family: 'Gruppo'; -fx-font-weight: 800; -fx-font-size: 60; -fx-text-fill: #D8D8D8;");
		title.setLayoutX(125);
		title.setLayoutY(75);
		
		TextField userID = new TextField();
		userID.setPromptText("Enter user ID");
		userID.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		userID.setLayoutX(80);
		userID.setLayoutY(160);
		
		PasswordField password = new PasswordField();
		password.setPromptText("Enter password");
		password.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-background-color: white; -fx-min-width: 250px; "
				+ "-fx-max-height: 50px; -fx-effect: innershadow(one-pass-box, gray, 5, 0.3, 1, 1);");
		password.setLayoutX(80);
		password.setLayoutY(200);
		
		Button button = new Button("Login");
		button.setStyle("-fx-font-family: 'Varela Round'; -fx-background-radius: 3; -fx-background-color: #10EE99; "
				+ "-fx-padding: 6 25 6 25; -fx-effect: innershadow(one-pass-box, #2B443A, 7, 0.3, 0, -1);");
		button.setLayoutX(163);
		button.setLayoutY(250);
		button.setOnAction(e -> {
			String id = userID.getText();
			String pass = password.getText();
			
			//Input validates user input data with system and database
			LoginController lc = new LoginController();
			//Check user input if its Owner or Customer
			if(lc.loginIDValidation(id)){
				if(lc.loginPasswordValidation(id, pass) == 1){
					// Customer Menu
					try {
						showCustomerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if(lc.loginPasswordValidation(id, pass) == 2){
					// Owner Menu
					System.out.println("Owner");
					try {
						showOwnerMenu();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					// Incorrect user name or password
					loginError();
				}
			} else {
				// Incorrect user name or password
				loginError();
			}
		});
		
		Label regLabel = new Label();
		regLabel.setText("Not registered yet?");
		regLabel.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 12; -fx-text-fill: #D8D8D8;");
		regLabel.setLayoutX(110);
		regLabel.setLayoutY(325);
		
		Hyperlink regText = new Hyperlink();
		regText.setText("Click here!");
		regText.setStyle("-fx-font-family: 'Varela Round'; -fx-font-size: 13; -fx-text-fill: #10EE99; -fx-border-color: transparent;");
		regText.setLayoutX(225);
		regText.setLayoutY(321);
		regText.setOnAction(e -> {
			try {
				showRegisterMenu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #2B303A");
		layout.getChildren().addAll(title, userID, password, button,regLabel,regText);
		
		Scene scene = new Scene(layout, 400, 350);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
		layout.requestFocus();
	}
	public static void showRegisterMenu() throws IOException {
		loginStage.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Register/Register.fxml"));
		startinglayout = loader.load();
		
		registerstage = new Stage();
		registerstage.setTitle("Booking App");
		registerstage.initOwner(primaryStage);
		Scene scene = new Scene(startinglayout);
		registerstage.setScene(scene);
		registerstage.show();
	}
	public static void showOwnerMenu() throws IOException {
		loginStage.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/OwnerMenu.fxml"));
		mainlayout = loader.load();
		
		primaryStage = new Stage();
		primaryStage.setTitle("Owner Menu");
		primaryStage.initOwner(loginStage);
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void showAddEmployee() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/AddEmployee.fxml"));
		BorderPane AddEmployee = loader.load();
		mainlayout.setCenter(AddEmployee);
	}
	public static void showAddTimeDate() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/AddTimeDate.fxml"));
		BorderPane AddTimeDate = loader.load();
		mainlayout.setCenter(AddTimeDate);
	}
	public static void showWorkingTimes() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/WorkingTimes.fxml"));
		BorderPane WorkingTimes = loader.load();
		mainlayout.setCenter(WorkingTimes);
	}
	public static void showBusinessActivities() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/BusinessActivities.fxml"));
		BorderPane BusinessActivities = loader.load();
		mainlayout.setCenter(BusinessActivities);
	}
	public static void showWeeklySummary() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/WeekBookingSummary.fxml"));
		BorderPane WeeklySummary = loader.load();
		mainlayout.setCenter(WeeklySummary);
	}
	public static void showWeekSummaryCustomer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Customer/CustomerBookingWeekView.fxml"));
		BorderPane WeeklySummary = loader.load();
		mainlayout.setCenter(WeeklySummary);
	}
	public static void showCreateBookingCustInfo() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/CreateBookingCustInfo.fxml"));
		BorderPane CreateBookingCustInfo = loader.load();
		mainlayout.setCenter(CreateBookingCustInfo);
	}
	public static void showCreateBookingDetails() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/CreateBookingDetails.fxml"));
		BorderPane CreateBookingDetails = loader.load();
		mainlayout.setCenter(CreateBookingDetails);
	}
	public static void showCustomerMenu() throws IOException {
		loginStage.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Customer/CustomerMenu.fxml"));
		mainlayout = loader.load();
		
		primaryStage = new Stage();
		primaryStage.setTitle("Customer Menu");
		primaryStage.initOwner(loginStage);
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
