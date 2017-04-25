package jebs.gui;

import javax.swing.JFrame;
import java.awt.Window;

import javax.swing.JTextField;

import jebs.mainpackage.LoginValidation;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Login = new JLabel("John's Electrician Booking System");
		Login.setBounds(61, 21, 306, 30);
		Login.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(Login);
		
		JLabel ID = new JLabel("User ID :");
		ID.setBounds(92, 78, 61, 22);
		ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(ID);
		
		JLabel Password = new JLabel("Password :");
		Password.setBounds(81, 122, 72, 22);
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(Password);
		
		IDinput = new JTextField();
		IDinput.setBounds(173, 78, 148, 24);
		frame.getContentPane().add(IDinput);
		IDinput.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(171, 177, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			
			//Once Login button is clicked, it stores all user input into respective String
			public void actionPerformed(ActionEvent e) {
				String id = IDinput.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				//Input validates user input data with system and database
				LoginValidation lv = new LoginValidation();
				lv.loginIDValidation(id);
				//Check user input if its Owner or Customer
				if(lv.loginIDValidation(id)){
					if(lv.loginPasswordValidation(id, password) == 1){
						frame.setVisible(false);
						frame.dispose();
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
					}
					else if(lv.loginPasswordValidation(id, password) == 2){
						//Owner
						System.out.println("Owner");
						frame.setVisible(false);
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									new OwnerMenu();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else {
						//Incorrect user name or password
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
				}
				//Invalid User ID
				else {
					JOptionPane.showMessageDialog(null, "Invalid User ID");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewCustomer = new JLabel("New Customer?");
		lblNewCustomer.setBounds(102, 221, 97, 14);
		frame.getContentPane().add(lblNewCustomer);
		
		//Button label for new customer to register themselves into the system
		JLabel lblRegister = new JLabel("<HTML><U>Click here to Register!</U></HTML>");
		lblRegister.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new RegisterCustomer();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblRegister.setBounds(209, 221, 128, 14);
		frame.getContentPane().add(lblRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 122, 148, 23);
		frame.getContentPane().add(passwordField);
		
		frame.setVisible(true);
		
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