package view;

import mainpackage.Employee;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	private JFrame frame = new JFrame();
	private JPanel cards = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JLabel title1 = new JLabel("Add New Employee");
	private JLabel title2 = new JLabel("Add New Employee");
	private JLabel title3 = new JLabel("Add New Employee");
	private JLabel title4 = new JLabel("Add New Employee");
	private JLabel empID = new JLabel("Employee ID:");
	private JLabel empName = new JLabel("Employee name:");
	private JLabel empAddress = new JLabel("Employee address:");
	private JLabel empNumber = new JLabel("Employee number:");
	private JButton submit1 = new JButton("OK");
	private JButton submit2 = new JButton("OK");
	private JButton submit3 = new JButton("OK");
	private JButton submit4 = new JButton("OK");
	private JTextField empidInput = new JTextField(10);
	private JTextField empNameInput = new JTextField(10);
	private JTextField empAddressInput = new JTextField(10);
	private JTextField empNumberInput = new JTextField(10);
	
	CardLayout cl = new CardLayout();
	
	public AddEmployee() {
		Employee nE = new Employee();
		
		cards.setLayout(cl);

		/* Add ID Panel */
		panel1.setLayout(null);
		panel1.add(title1);
		title1.setFont(new Font("Tahoma", Font.BOLD, 18));
		title1.setBounds(105, 20, 178, 22);
		panel1.add(empID);
		empID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		empID.setBounds(60, 65, 100, 19);
		panel1.add(empidInput);
		empidInput.setBounds(163, 63, 110, 22);
		panel1.add(submit1);
		submit1.setFont(new Font("Tohoma", Font.BOLD, 11));
		submit1.setBounds(285,63,50,22);
		panel1.setBackground(Color.BLUE);
		
		/* Add Name Panel */
		panel2.setLayout(null);
		panel2.add(title2);
		title2.setFont(new Font("Tahoma", Font.BOLD, 18));
		title2.setBounds(105, 20, 178, 22);
		panel2.add(empName);
		empName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		empName.setBounds(40, 65, 120, 19);
		panel2.add(empNameInput);
		empNameInput.setBounds(163, 63, 110, 22);
		panel2.add(submit2);
		submit2.setFont(new Font("Tohoma", Font.BOLD, 11));
		submit2.setBounds(285,63,50,22);
		panel2.setBackground(Color.GREEN);
		
		/* Add Address Panel */
		panel3.setLayout(null);
		panel3.add(title3);
		title3.setFont(new Font("Tahoma", Font.BOLD, 18));
		title3.setBounds(105, 20, 178, 22);
		panel3.add(empAddress);
		empAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		empAddress.setBounds(25, 65, 140, 19);
		panel3.add(empAddressInput);
		empAddressInput.setBounds(163, 63, 110, 22);
		panel3.add(submit3);
		submit3.setFont(new Font("Tohoma", Font.BOLD, 11));
		submit3.setBounds(285,63,50,22);
		panel3.setBackground(Color.YELLOW);
		
		/* Add Number Panel */
		panel4.setLayout(null);
		panel4.add(title4);
		title4.setFont(new Font("Tahoma", Font.BOLD, 18));
		title4.setBounds(105, 20, 178, 22);
		panel4.add(empNumber);
		empNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		empNumber.setBounds(25, 65, 140, 19);
		panel4.add(empNumberInput);
		empNumberInput.setBounds(163, 63, 110, 22);
		panel4.add(submit4);
		submit4.setFont(new Font("Tohoma", Font.BOLD, 11));
		submit4.setBounds(285,63,50,22);
		panel4.setBackground(Color.RED);
		
		/* Add cards */
		cards.add(panel1, "1");
		cards.add(panel2, "2");
		cards.add(panel3, "3");
		cards.add(panel4, "4");
		cl.show(cards, "1");
		
		submit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String empid = empidInput.getText();
				System.out.println("empid: " + empid);
		    	if(empid.matches("[0-9]{3}")) {
					empid.trim();
					nE.setID(empid);
					JOptionPane.showMessageDialog(null, "empid: " + nE.getID());
					cl.show(cards, "2");
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : ID number should contain only 3 digits.\nPlease enter a valid ID number");
				}
			}
		});
		
		submit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String empName = empNameInput.getText();
				System.out.println("empName: " + empName);
		    	if(empName.matches("[a-zA-Z ]{1,30}")) {
					nE.setName(empName);
					JOptionPane.showMessageDialog(null, "empName: " + nE.getName());
					cl.show(cards, "3");
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : Please enter a valid employee name");
				}
			}
		});
		
		submit3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String empAddress = empAddressInput.getText();
				if(empAddress.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")) {
					nE.setAddress(empAddress);
					JOptionPane.showMessageDialog(null, "empAddress: " + nE.getAddress());
					cl.show(cards, "4");
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : Please enter a valid employee address");
				}
			}
		});
		
		submit4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String empNumber = empNumberInput.getText();
				if(empNumber.matches("[0-9]{10}")) {
					nE.setNumber(empNumber);
					JOptionPane.showMessageDialog(null, "empName: " + nE.getName());
					JOptionPane.showMessageDialog(null, "empNumber: " + nE.getNumber());
					
					Connection con = null;
					Statement statement = null;
					try {
						con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
						statement = con.createStatement();
						 /* SQL Statement  */
						statement.executeUpdate("INSERT INTO employee values('e" + nE.getID() + "', '" + nE.getName() + "', '" + nE.getAddress() + "', '0" + nE.getNumber() + "')");
						
						JOptionPane.showMessageDialog(null, "Successfully added new employee!");
						
					} catch (Exception e1) {
						System.err.println(e1);
					} finally {
						if (statement != null) {
					        try {
					            statement.close();
					            System.out.println("pass stat closed");
					        } catch (SQLException e1) { System.out.println("statement did not close");}
					    }
					    if (con != null) {
					        try {
					            con.close();
					            System.out.println("pass con closed");
					        } catch (SQLException e1) { }
					    } 
					}
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : Please enter a valid employee number");
				}
			}
		});
		frame.add(cards);
		frame.setBounds(100,100,400,150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

//package view;

/*import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mainpackage.Customer;
import mainpackage.Employee;
import mainpackage.Person;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewEmployee {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	//Launch the application.
	
*/
	/**
	 * Create the application.
	 */
/*	public AddNewEmployee() {
		initialize();
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddNewEmployee = new JLabel("Add New Employee");
		lblAddNewEmployee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddNewEmployee.setBounds(127, 22, 178, 22);
		frame.getContentPane().add(lblAddNewEmployee);
		
		JLabel lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(49, 77, 100, 19);
		frame.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField(10);
		textField.setBounds(171, 76, 190, 22);
		frame.getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("Name :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(94, 121, 49, 19);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String empid = textField.getText();
		    	if(empid.matches("[0-9]{3}")) {
					empid.trim();
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : ID number should contain only 3 digits.\nPlease enter a valid ID number");
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(171, 122, 190, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("Address :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(81, 167, 62, 19);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				if(!name.matches("[a-zA-Z ]{1,30}")) {	
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Name.\nPlease enter a shorter valid name");
				} 
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(171, 168, 190, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("Mobile Number :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(37, 212, 107, 19);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String address = textField_2.getText();
				if(!address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Address.\nPlease enter a new valid address");
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(171, 213, 190, 22);
		frame.getContentPane().add(textField_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField_3.getText();
				if(!number.matches("[0-9]{10}")){
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Mobile Number.\nPlease enter a new valid mobile number");
				}
				String empid = textField.getText();
				String name = textField_1.getText();
				String address = textField_2.getText();
				Employee nE = new Employee(empid,name,address,number);

				Connection con = null;
				Statement statement = null;
				ResultSet resultSet =null;
				try {
					con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					statement = con.createStatement();
					 SQL Statement 
					statement.executeUpdate("INSERT INTO employee values('e"+nE.getID()+"', '"+nE.getName()+"', '"+nE.getAddress()+"', '"+nE.getNumber()+"')");
					
					JOptionPane.showMessageDialog(null, "Successfully added new employee!");
					
				} catch (Exception e1) {
					System.err.println(e1);
				} finally {
					if(resultSet != null){
				    	try {
				    		resultSet.close();
				    		System.out.println("pass result closed");
				    	} catch (SQLException e1){ }
				    }
					if (statement != null) {
				        try {
				            statement.close();
				            System.out.println("pass stat closed");
				        } catch (SQLException e1) { System.out.println("statement did not close");}
				    }
				    if (con != null) {
				        try {
				            con.close();
				            System.out.println("pass con closed");
				        } catch (SQLException e1) { }
				    } 
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setBounds(163, 270, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblGoBackMain = new JLabel("<HTML><U>Go back</U></HTML>");
		lblGoBackMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		lblGoBackMain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGoBackMain.setBounds(185, 315, 49, 14);
		frame.getContentPane().add(lblGoBackMain);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}*/
