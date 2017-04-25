package jebs.mainpackage;

import jebs.gui.CustomerMenu;
import jebs.gui.OwnerMenu;
import jebs.view.Menu;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.io.*;
import java.sql.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BookingSystem extends Application {
	
	final static Scanner scan = new Scanner(System.in);
	Stage window;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		/* create instance of menu */
		/* Menu menu = new Menu();
		boolean done = false; */
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			System.out.println("Connection success!");
			Statement statement = con.createStatement();
			
			/* NEVER DELETE THESE!
			statement.executeUpdate("CREATE TABLE customer(custid STRING, name STRING, password STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO customer values('c001','Patrick Bateman', 'abcd1234', '720 Glenhuntly Rd, Glen Huntly 3163', '0470617895')");
			statement.executeUpdate("INSERT INTO customer values('c002','Sean Daley', '1234abcd', '5/20 Sandbelt Close, Heatherton 3202', '0401387466')");
			statement.executeUpdate("CREATE TABLE owner(ownid STRING, businessname STRING, ownername STRING, password STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO owner values('o001', 'JS Electrical PTY', 'John Stewart', 'ownerpass', '24 Lansell Rd, Toorak 3142', '0430614823')");
			statement.executeUpdate("CREATE TABLE employee(empid STRING, name STRING, address STRING, number STRING)");
			statement.executeUpdate("INSERT INTO employee values('e001', 'Patrick Cripps', '256 Warrigal Rd, Oakleigh 3166', '0405841655')");
			statement.executeUpdate("INSERT INTO employee values('e002', 'Marc Murphy', '45 Derby St, Kew 3101', '0430655874')");
			statement.executeUpdate("INSERT INTO employee values('e003', 'Sebastian Vettel', '73 Pakington St, St Kilda 3182', '0408711963')");
			*/
			
			//if you want to delete register test entries
			//statement.executeUpdate("DELETE FROM employee WHERE empid='e004'");
			 
			
			/* perform query, loop through and print all rows */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
			while(resultSet.next()) {
				System.out.print("empid: " + resultSet.getString("empid") + " | ");
				System.out.print("name: " + resultSet.getString("name") + " | ");
				System.out.print("address: " + resultSet.getString("address") + " | ");
				System.out.println("number: 0" + resultSet.getInt("number"));
			}
			System.out.println("");
			/* here for customer */
			ResultSet resultSet2 = statement.executeQuery("SELECT * FROM customer");
			while(resultSet2.next()) {
				System.out.print("custid: " + resultSet2.getString("custid") + " | ");
				System.out.print("name: " + resultSet2.getString("name") + " | ");
				System.out.print("password: " + resultSet2.getString("password") + " | ");
				System.out.print("address: " + resultSet2.getString("address") + " | ");
				System.out.println("number: 0" + resultSet2.getString("number"));
			}
			System.out.println("");
			/* here for owner */
			ResultSet resultSet3 = statement.executeQuery("SELECT * FROM owner");
			while(resultSet3.next()) {
				System.out.print("ownid: " + resultSet3.getString("ownid") + " | ");
				System.out.print("business name: " + resultSet3.getString("businessname") + " | ");
				System.out.print("business owner name: " + resultSet3.getString("ownername") + " | ");
				System.out.print("password: " + resultSet3.getString("password") + " | ");
				System.out.print("address: " + resultSet3.getString("address") + " | ");
				System.out.println("number: 0" + resultSet3.getString("number"));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		launch(args);
		/*while (!done) {
			done = menu.systemMenu();
		}*/
		System.out.println("Program has been terminated.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("John's Electrical");
		
		Image image = new Image(getClass().getResource("/jebs/resources/jebs_logo.png").toURI().toString());
		ImageView iv1 = new ImageView(image);
		iv1.setFitWidth(1);
		iv1.setFitHeight(1);
		iv1.setLayoutX(165);
		iv1.setLayoutY(10);
		
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
		//button.setOnAction(e -> LoginFX.display("Authentication", "authenting.."));
		
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
			LoginValidation lv = new LoginValidation();
			//Check user input if its Owner or Customer
			if(lv.loginIDValidation(id)){
				if(lv.loginPasswordValidation(id, pass) == 1){
					window.close();
					//Customer
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								new CustomerMenu();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else if(lv.loginPasswordValidation(id, pass) == 2){
					//Owner
					System.out.println("Owner");
					window.close();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								new OwnerMenu();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					//Incorrect user name or password
					loginError();
				}
			} else {
				//Incorrect user name or password
				loginError();
			}
		});
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #2B303A");
		layout.getChildren().addAll(iv1, title, userID, password, button);
		
		Scene scene = new Scene(layout, 400, 350);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		window.setScene(scene);
		window.show();
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

}