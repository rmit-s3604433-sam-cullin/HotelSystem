package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import mainpackage.Customer;
import mainpackage.Person;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {

	JFrame frame;
	private JTextField REGIDinput;
	private JTextField REGNAMEinput;
	private JTextField REGPASSinput;
	private JTextField REGADDRSinput;
	private JTextField REGMOBNOinput;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Registration = new JLabel("Customer Registration");
		Registration.setFont(new Font("Tahoma", Font.BOLD, 18));
		Registration.setBounds(116, 22, 208, 22);
		frame.getContentPane().add(Registration);
		
		JLabel CustID = new JLabel("User ID :");
		CustID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustID.setBounds(86, 79, 65, 19);
		frame.getContentPane().add(CustID);
		
		JLabel CustName = new JLabel("Name :");
		CustName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustName.setBounds(96, 119, 49, 19);
		frame.getContentPane().add(CustName);
		
		JLabel CustPassword = new JLabel("Password :");
		CustPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustPassword.setBounds(74, 160, 71, 19);
		frame.getContentPane().add(CustPassword);
		
		JLabel CustAddress = new JLabel("Address :");
		CustAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustAddress.setBounds(83, 202, 62, 19);
		frame.getContentPane().add(CustAddress);
		
		JLabel CustMobile = new JLabel("Mobile Number :");
		CustMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustMobile.setBounds(39, 242, 107, 19);
		frame.getContentPane().add(CustMobile);
		
		REGIDinput = new JTextField(10);
		REGIDinput.setBounds(173, 78, 190, 22);
		frame.getContentPane().add(REGIDinput);
		REGIDinput.setColumns(10);
		
		REGNAMEinput = new JTextField();
		REGNAMEinput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String custid = REGIDinput.getText();
				
				if(custid.matches("[0-9]{3}")) {
					custid.trim();
				} else {
					JOptionPane.showMessageDialog(null,"Invalid : ID number should contain only 3 digits.\nPlease enter a valid ID number");
				}
			}
		});
		REGNAMEinput.setColumns(10);
		REGNAMEinput.setBounds(173, 120, 190, 22);
		frame.getContentPane().add(REGNAMEinput);
		
		REGPASSinput = new JTextField();
		REGPASSinput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = REGNAMEinput.getText();
				if(!name.matches("[a-zA-Z ]{1,30}")) {
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Name.\nPlease enter a shorter valid name");
				}
			}
		});
		REGPASSinput.setColumns(10);
		REGPASSinput.setBounds(173, 161, 190, 22);
		frame.getContentPane().add(REGPASSinput);
		
		REGADDRSinput = new JTextField();
		REGADDRSinput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = REGPASSinput.getText();
				if(!password.matches("[a-zA-Z0-9,./';:?><{}|+=-_()*&^%$#@!`~]{8,20}")){
					JOptionPane.showMessageDialog(null,"Invalid : Password must be at least 8 characters long and max 20.\nPlease enter a new valid password");
				} 
			}
		});
		REGADDRSinput.setColumns(10);
		REGADDRSinput.setBounds(173, 203, 190, 22);
		frame.getContentPane().add(REGADDRSinput);
		
		REGMOBNOinput = new JTextField();
		REGMOBNOinput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String address = REGADDRSinput.getText();
				if(!address.matches("[a-zA-Z0-9 ,./':-|_`~&$@#+()]{2,40}")){
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Address.\nPlease enter a new valid address");
				} 
			}
		});
		REGMOBNOinput.setColumns(10);
		REGMOBNOinput.setBounds(173, 243, 190, 22);
		frame.getContentPane().add(REGMOBNOinput);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = REGMOBNOinput.getText();
				if(!number.matches("[0-9]{10}")){
					JOptionPane.showMessageDialog(null,"Invalid : Invalid Mobile Number.\nPlease enter a new valid mobile number");
				}
				String custid = REGIDinput.getText();
				String name = REGNAMEinput.getText();
				String password = REGPASSinput.getText();
				String address = REGADDRSinput.getText();
				Person nC = new Customer(custid,name,password,address,number);
				
				Connection con = null;
				Statement statement = null;
				try {
					con = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					statement = con.createStatement();
					/* SQL Statement */
					statement.executeUpdate("INSERT INTO customer values('c" + nC.getID() + "', '" + nC.getName() + "', '" + nC.getPassword() + "', '" + nC.getAddress() + "', '0" + nC.getNumber() + "')");

					JOptionPane.showMessageDialog(null, "\nRegistration Successful!");
					frame.setVisible(false);
					frame.dispose();
					
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
				        } catch (SQLException e1) { /* ignored */}
				    } 
				}
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(161, 296, 100, 30);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblGoBackMain = new JLabel("<HTML><U>Go back</U></HTML>");
		lblGoBackMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		lblGoBackMain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGoBackMain.setBounds(187, 348, 49, 14);
		frame.getContentPane().add(lblGoBackMain);
	}

	public Window getFrame() {
		
		return frame;
	}

}