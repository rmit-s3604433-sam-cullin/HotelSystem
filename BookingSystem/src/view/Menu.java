package view;

import java.awt.EventQueue;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Menu {
  
	final static Scanner scan = new Scanner(System.in);

	private String printMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("======================================");
		System.out.println("   John's Electrician Booking System");
		System.out.println("======================================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("======================================");
		System.out.print("Please Enter Your Choice: ");
		String i = scan.next();
		return i;
	}
	/* first method called here */
	public boolean systemMenu() throws IOException {
		
		boolean exit = false;
		do{
			String x = printMenu();
			switch(x){
				case("1"):
					login();
					break;
				case("2"):
					//addCustomer();
					break;
				case("3"):
					System.out.println("\nThe system will exit now.");
					exit = true;
					break;
				default:
					System.out.println("\nInvalid input\n");
					break;
			}
		} while (!exit);
		
		return true;
	}
	
public void login() {
		
		String ID, password;
		boolean userDone = false, passDone = false;
		Connection con =null;
		Statement statement =null;
		ResultSet resultSet =null;
		
		do{
			System.out.println("\nPlease Enter User ID or 'exit'"); 
			ID = scan.next();
			if(ID.matches("[c][0-9]{3}") | ID.matches("[o][0-9]{3}")) {
				try {
					con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					statement = con.createStatement();
					
					resultSet = statement.executeQuery("SELECT ownid FROM owner");
					while(resultSet.next()) {
						if(ID.equals(resultSet.getString("ownid"))) {
							System.out.println("Admin found!");
							userDone = true;
							break;
						}
					}
					resultSet.close();
					if(!userDone) {
						resultSet = statement.executeQuery("SELECT custid FROM customer");
						while(resultSet.next()) {
							if(ID.equals(resultSet.getString("custid"))) { 
								System.out.println("User found!");
								userDone = true;
								break;
							}
						}
						resultSet.close();
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					//Closing statements for the sql connection
					if (statement != null) {
				        try {
				            statement.close();
				            System.out.println("id state closed");
				        } catch (SQLException e) { System.out.println("id statment still open");}
				    }
				    if (con != null) {
				        try {
				            con.close();
				            System.out.println("id con closed");
				        } catch (SQLException e) { /* ignored */}
				    }  
				}
				if(!userDone) {
					System.out.println("No user found");
					/* remove break to replay user ID input instead of going back to main menu */
					break;
				}
					
			} else if(ID.equals("exit")) {
				System.out.println("You selected exit");
				break;
			} else {
				System.out.println("Input Invalid");
			}
			
		} while(!userDone);

		if(userDone && !passDone) {
			do {
			System.out.println("\nPlease enter user password or 'exit'");
			password = scan.next();
				if(password.equals("exit")){
					System.out.println("You selected exit");
					break;
				} else {
					
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						
						//owner password check
						resultSet = statement.executeQuery("SELECT password FROM owner WHERE ownID='" + ID + "'");
						while(resultSet.next()) {
							if(password.equals(resultSet.getString("password"))) {
								System.out.println("Password correct!");
								//moves to owner menu
								statement.close();
								con.close();
								//ownerMenu();
								passDone = true;
							}
						}
						
						//customer password check
						resultSet = statement.executeQuery("SELECT password FROM customer WHERE custid='" + ID + "'");
						while(resultSet.next()) {
							if(password.equals(resultSet.getString("password"))) { 
								System.out.println("Password correct!");
								//moves to customer menu
								statement.close();
								con.close();
								//customerMenu();
								passDone = true;
							} else {
								System.out.println("Password incorrect");
							}
						}
					} catch (Exception e) {
						System.err.println(e);
					} finally {
						if(resultSet != null){
					    	try {
					    		resultSet.close();
					    		System.out.println("pass result closed");
					    	} catch (SQLException e){ /* ignored */ }
					    }
						if (statement != null) {
					        try {
					            statement.close();
					            System.out.println("pass stat closed");
					        } catch (SQLException e) { System.out.println("statement did not close");}
					    }
					    if (con != null) {
					        try {
					            con.close();
					            System.out.println("pass con closed");
					        } catch (SQLException e) { /* ignored */}
					    } 
					}
				}
			} while(!passDone);
		}
	}

	public void addTimeDate() {
		
		String year = "", month = "", date = "", timeA = "", timeB = "";
		int confirm, choice = 0;
		while(choice == 0 || choice == 1) {		
			scan.nextLine();
			System.out.println("Please enter year :");
			year = scan.nextLine();
			int year1 = Integer.parseInt(year);
			while(year1 < 2017 || year1 > 2017) {
				System.out.println("\nInvalid : You can only add for the current year.");
				System.out.println("Please enter year :");
				year = scan.nextLine();
				year1 = Integer.parseInt(year);
			}
			System.out.println("\nPlease enter month (numeric) :");
			month = scan.nextLine();
			int month1 = Integer.parseInt(month);
			while(month1 > 12 || month1 < 1) {
				System.out.println("\nInvalid : Please enter a valid month");
				System.out.println("Please enter month (numeric) :");
				month = scan.nextLine();
				month1 = Integer.parseInt(month);
				
			}
			if(month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
				System.out.println("\nPlease enter date :");
				date = scan.nextLine();
				int date1 = Integer.parseInt(date);
				while(date1 > 31 || date1 < 1) {
					System.out.println("\nInvalid : Invalid date for that particular month!");
					System.out.println("Please enter date :");
					date = scan.nextLine();
					date1 = Integer.parseInt(date);
				}
			}
			else {
				System.out.println("\nPlease enter date :");
				date = scan.nextLine();
				int date1 = Integer.parseInt(date);
				if(date1 > 30 || date1 < 1) {
					System.out.println("\nInvalid : Invalid date for that particular month!");
					System.out.println("Please enter date :");
					date = scan.nextLine();
					date1 = Integer.parseInt(date);
				}
			}
			System.out.println("\nPlease enter the starting time (24-hours system) :");
			timeA = scan.next();
			int time1 = Integer.parseInt(timeA);
			if(time1 < 900) {
				System.out.println("\nInvalid : Invalid working time schedule!");
				System.out.println("Please enter a time slot (24-hours system) :");
				timeA = scan.nextLine();
				time1 = Integer.parseInt(date);
			}
			System.out.println("\nPlease enter the ending time (24-hours system) :");
			timeB = scan.next();
			int time2 = Integer.parseInt(timeB);
			if(time2 > 1700) {
				System.out.println("\nInvalid : Invalid working time schedule!");
				System.out.println("Please enter a time slot (24-hours system) :");
				timeB = scan.nextLine();
				time2 = Integer.parseInt(date);
			}
			System.out.println("\nConfirm adding this time and date? (1 - Yes/2 - No)");
			confirm = scan.nextInt();
			if(confirm == 1) {
				System.out.println("\nSuccessfully added new time and date to system!");
				System.out.println(year + "/" + month + "/" + date + timeA + "-" + timeB);
			}
			else {
				System.out.println("Successfully cancelled adding new time and date to system!");
			}
			System.out.println("Press 1 to repeat process");
			System.out.println("Press 2 for Main Menu");
			choice = scan.nextInt();
		}
	}
}