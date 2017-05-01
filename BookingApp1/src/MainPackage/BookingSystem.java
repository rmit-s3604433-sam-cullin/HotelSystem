package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;

import MainPackage.Login.LoginController;
import MainPackage.Owner.AddTimeDateController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;


public class BookingSystem extends Application {

	private static Stage primaryStage;
	private static Stage registerstage;
	private static Stage loginStage;
	private static BorderPane mainlayout;
	private static AnchorPane startinglayout;
	
	static Connection con = null;
	static Statement statement = null;

	@Override
	public void start(Stage primaryStage) throws IOException {
		BookingSystem.loginStage = primaryStage;
		BookingSystem.loginStage.setTitle("Booking App");
		showLogin();
	}
	public static void showLogin() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(BookingSystem.class.getResource("Login/Login.fxml"));
		startinglayout = loader.load();
		Scene scene = new Scene(startinglayout);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
	}
	
	public static void showLogin2() throws IOException {
		registerstage.close();
		FXMLLoader loader = new FXMLLoader(BookingSystem.class.getResource("Login/Login.fxml"));
		startinglayout = loader.load();
		Scene scene = new Scene(startinglayout);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
	}
	public static void showLogin3() throws IOException {
		primaryStage.close();
		FXMLLoader loader = new FXMLLoader(BookingSystem.class.getResource("Login/Login.fxml"));
		startinglayout = loader.load();
		Scene scene = new Scene(startinglayout);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Varela+Round");
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gruppo");
		loginStage.setScene(scene);
		loginStage.show();
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
		/*FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/AddTimeDate.fxml"));
		BorderPane AddTimeDate = loader.load();
		mainlayout.setCenter(AddTimeDate);*/
		
		Label title = new Label("Add employee shift date/time");
		title.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		title.setUnderline(true);
		title.setLayoutX(35);
		title.setLayoutY(25);
		
		Label subTitle = new Label("Please choose an employee : ");
		subTitle.setStyle("-fx-font-size: 14px;");
		subTitle.setLayoutX(35);
		subTitle.setLayoutY(75);
	
		ChoiceBox<String> cBox = new ChoiceBox<String>();
		cBox.setLayoutX(235);
		cBox.setLayoutY(72);
		cBox.setMinWidth(190);
		try {
			con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
			statement = con.createStatement();
			ResultSet empSet = statement.executeQuery("SELECT empid, name FROM employee");
			while(empSet.next()) {
				cBox.getItems().add(empSet.getString("name"));
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
		
		DatePicker datePicker = new DatePicker();
		
		StringConverter<LocalDate> defaultConverter = datePicker.getConverter();
		
		datePicker.setConverter(new StringConverter<LocalDate>() {
			@Override
			public String toString(LocalDate object) {
				return defaultConverter.toString(object);
			}
			
			@Override
			public LocalDate fromString(String string) {
				LocalDate date = defaultConverter.fromString(string);
				if(date.getDayOfWeek() == DayOfWeek.MONDAY) {
					return date;
				} else {
					// not a Monday. Revert to previous value.
					return datePicker.getValue();
				}
			}
		});
		
		datePicker.setDayCellFactory(dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(empty || item.getDayOfWeek() != DayOfWeek.MONDAY);
			}
		});
		// just for dubugging so we only see Mondays
		datePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
			if(newDate.getDayOfWeek() != DayOfWeek.MONDAY) {
				System.out.println("WARNING: date chosen was not a Monay");
			}
			System.out.println(newDate + " (" + newDate.getDayOfWeek() + ")");
		});
		
		
		Label monday = new Label("Monday");
		monday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		monday.setUnderline(true);
		monday.setLayoutX(35);
		monday.setLayoutY(110);
		Label subMonday = new Label("Please choose times :");
		subMonday.setStyle("-fx-font-size: 14px;");
		subMonday.setLayoutX(35);
		subMonday.setLayoutY(150);
		CheckBox mondayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		mondayBox1.setLayoutX(200);
		mondayBox1.setLayoutY(151);
		CheckBox mondayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		mondayBox2.setLayoutX(350);
		mondayBox2.setLayoutY(151);
		CheckBox mondayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		mondayBox3.setLayoutX(500);
		mondayBox3.setLayoutY(151);
		
		Label tuesday = new Label("Tuesday");
		tuesday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		tuesday.setUnderline(true);
		tuesday.setLayoutX(35);
		tuesday.setLayoutY(180);
		Label subTuesday = new Label("Please choose times :");
		subTuesday.setStyle("-fx-font-size: 14px;");
		subTuesday.setLayoutX(35);
		subTuesday.setLayoutY(220);
		CheckBox tuesdayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		tuesdayBox1.setLayoutX(200);
		tuesdayBox1.setLayoutY(221);
		CheckBox tuesdayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		tuesdayBox2.setLayoutX(350);
		tuesdayBox2.setLayoutY(221);
		CheckBox tuesdayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		tuesdayBox3.setLayoutX(500);
		tuesdayBox3.setLayoutY(221);
		
		Label wednesday = new Label("Wednesday");
		wednesday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		wednesday.setUnderline(true);
		wednesday.setLayoutX(35);
		wednesday.setLayoutY(250);
		Label subWednesday = new Label("Please choose times :");
		subWednesday.setStyle("-fx-font-size: 14px;");
		subWednesday.setLayoutX(35);
		subWednesday.setLayoutY(290);
		CheckBox wednesdayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		wednesdayBox1.setLayoutX(200);
		wednesdayBox1.setLayoutY(291);
		CheckBox wednesdayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		wednesdayBox2.setLayoutX(350);
		wednesdayBox2.setLayoutY(291);
		CheckBox wednesdayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		wednesdayBox3.setLayoutX(500);
		wednesdayBox3.setLayoutY(291);
		
		Label thursday = new Label("Thrusday");
		thursday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		thursday.setUnderline(true);
		thursday.setLayoutX(35);
		thursday.setLayoutY(320);
		Label subThursday = new Label("Please choose times :");
		subThursday.setStyle("-fx-font-size: 14px;");
		subThursday.setLayoutX(35);
		subThursday.setLayoutY(360);
		CheckBox thursdayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		thursdayBox1.setLayoutX(200);
		thursdayBox1.setLayoutY(361);
		CheckBox thursdayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		thursdayBox2.setLayoutX(350);
		thursdayBox2.setLayoutY(361);
		CheckBox thursdayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		thursdayBox3.setLayoutX(500);
		thursdayBox3.setLayoutY(361);
		
		Label friday = new Label("Friday");
		friday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		friday.setUnderline(true);
		friday.setLayoutX(35);
		friday.setLayoutY(390);
		Label subFriday = new Label("Please choose times :");
		subFriday.setStyle("-fx-font-size: 14px;");
		subFriday.setLayoutX(35);
		subFriday.setLayoutY(430);
		CheckBox fridayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		fridayBox1.setLayoutX(200);
		fridayBox1.setLayoutY(431);
		CheckBox fridayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		fridayBox2.setLayoutX(350);
		fridayBox2.setLayoutY(431);
		CheckBox fridayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		fridayBox3.setLayoutX(500);
		fridayBox3.setLayoutY(431);
		
		/*Label monday = new Label("Monday");
		monday.setStyle("-fx-font-size: 18px; -fx-font-style: italic; -fx-font-weight: bold;");
		monday.setUnderline(true);
		monday.setLayoutX(35);
		monday.setLayoutY(110);
		Label subMonday = new Label("Please choose times :");
		subMonday.setStyle("-fx-font-size: 14px;");
		subMonday.setLayoutX(35);
		subMonday.setLayoutY(150);
		CheckBox mondayBox1 = new CheckBox("9:00 AM - 11:30 PM");
		mondayBox1.setLayoutX(200);
		mondayBox1.setLayoutY(151);
		CheckBox mondayBox2 = new CheckBox("11:30 AM - 2:00 PM");
		mondayBox2.setLayoutX(350);
		mondayBox2.setLayoutY(151);
		CheckBox mondayBox3 = new CheckBox("2:00 PM - 5:00 PM");
		mondayBox3.setLayoutX(500);
		mondayBox3.setLayoutY(151);*/
		
		Pane layout = new Pane();
		layout.setStyle("-fx-background-color: #F7F7F7");
		layout.getChildren().addAll(title,subTitle,cBox,datePicker,monday,subMonday,mondayBox1,mondayBox2,mondayBox3,tuesday,subTuesday,tuesdayBox1,tuesdayBox2,tuesdayBox3,
				wednesday,subWednesday,wednesdayBox1,wednesdayBox2,wednesdayBox3,thursday,subThursday,thursdayBox1,thursdayBox2,thursdayBox3,friday,subFriday,
				fridayBox1,fridayBox2,fridayBox3);
		layout.setMinWidth(1000);
		layout.setMinHeight(650);

		mainlayout.setCenter(layout);
	}
	/* For daniel to implement
	 * public static void showWorkingTimes() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/WorkingTimes.fxml"));
		BorderPane WorkingTimes = loader.load();
		mainlayout.setCenter(WorkingTimes);
	}*/
	public static void showBusinessActivities() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/BusinessActivities.fxml"));
		BorderPane BusinessActivities = loader.load();
		mainlayout.setCenter(BusinessActivities);
	}
	public static void showWeeklySummary() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/WeeklySummary.fxml"));
		BorderPane WeeklySummary = loader.load();
		mainlayout.setCenter(WeeklySummary);
	}
	public static void showWeekSummaryCustomer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Customer/CustomerBookingWeekView.fxml"));
		BorderPane WeeklySummary = loader.load();
		mainlayout.setCenter(WeeklySummary);
	}
	public static void showCreateBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/CreateBooking.fxml"));
		BorderPane CreateBooking = loader.load();
		mainlayout.setCenter(CreateBooking);
	}
	public static void showCreateBooking1() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/CreateBooking1.fxml"));
		BorderPane CreateBooking1 = loader.load();
		mainlayout.setCenter(CreateBooking1);
	}
	public static void showCreateBookingCustInfo() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BookingSystem.class.getResource("Owner/CreateBookingCustInfo.fxml"));
		BorderPane CreateBookingCustInfo = loader.load();
		mainlayout.setCenter(CreateBookingCustInfo);
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
