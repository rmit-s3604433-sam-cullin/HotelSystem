package view;

import java.awt.EventQueue;

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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddNewEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					Statement statement = con.createStatement();
				
					/* SQL Statement */
					statement.executeUpdate("INSERT INTO employee values('e"+nE.getID()+"', '"+nE.getName()+"', '"+nE.getAddress()+"', '"+nE.getNumber()+"')");
					
					JOptionPane.showMessageDialog(null, "Successfully added new employee!");
					
				} catch (Exception e1) {
					System.err.println(e1);
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
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							OwnerMenu window = new OwnerMenu();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
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
}
