package view;

import javax.swing.JFrame;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField IDinput;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		((JFrame) getFrame()).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Login = new JLabel("John's Electrician Booking System");
		Login.setBounds(61, 21, 306, 30);
		Login.setFont(new Font("Tahoma", Font.BOLD, 18));
		((JFrame) getFrame()).getContentPane().add(Login);
		
		JLabel ID = new JLabel("User ID :");
		ID.setBounds(92, 78, 61, 22);
		ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		((JFrame) getFrame()).getContentPane().add(ID);
		
		JLabel Password = new JLabel("Password :");
		Password.setBounds(81, 122, 72, 22);
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		((JFrame) getFrame()).getContentPane().add(Password);
		
		IDinput = new JTextField();
		IDinput.setBounds(173, 78, 148, 24);
		((JFrame) getFrame()).getContentPane().add(IDinput);
		IDinput.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(171, 177, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:sqlite:BookingSystem.db");
					//Getting data from text field
					String name = IDinput.getText();
					@SuppressWarnings("deprecation")
					String pass = passwordField.getText();
					//Create query
					String query ="SELECT * FROM owner WHERE ownid=? AND password=?";
					String query2 ="SELECT * FROM customer WHERE custid=? AND password =?";
			
					PreparedStatement statement = connection.prepareStatement(query);
					PreparedStatement statement2 = connection.prepareStatement(query2);
				
					statement.setString(1, name);
					statement.setString(2, pass);
					statement2.setString(1, name);
					statement2.setString(2, pass);
					ResultSet set = statement.executeQuery();
					ResultSet set2 = statement2.executeQuery();
					if(set.next()) {
						/*JOptionPane.showMessageDialog(null, "Verification success - Owner Login Successful");*/
						frame.setVisible(false);
						frame.dispose();
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
					else if(set2.next()){
						/*JOptionPane.showMessageDialog(null, "Verification success - Customer Login Successful");*/
						frame.setVisible(false);
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									CustomerMenu window = new CustomerMenu();
									window.getFrame().setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(null, "Connection Successful");

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		getFrame().getContentPane().add(btnLogin);
		
		JLabel lblNewCustomer = new JLabel("New Customer?");
		lblNewCustomer.setBounds(102, 221, 97, 14);
		getFrame().getContentPane().add(lblNewCustomer);
		
		JLabel lblRegister = new JLabel("<HTML><U>Click here to Register!</U></HTML>");
		lblRegister.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Register window = new Register();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblRegister.setBounds(209, 221, 128, 14);
		getFrame().getContentPane().add(lblRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 122, 148, 23);
		frame.getContentPane().add(passwordField);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public Window getFrame1() {
		// TODO Auto-generated method stub
		return frame;
	}
}