package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;


public class Login {

	private JFrame frame;

	private JTextField userIdInput;
	private JPasswordField passwordInput;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		userIdInput = new JTextField();
		userIdInput.setBounds(151, 53, 130, 26);
		frame.getContentPane().add(userIdInput);
		userIdInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setBounds(26, 58, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PassWord");
		lblNewLabel_1.setBounds(26, 115, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(199, 25, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(151, 165, 130, 29);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(151, 227, 130, 29);
		frame.getContentPane().add(registerButton);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(151, 110, 130, 26);
		frame.getContentPane().add(passwordInput);
		
		JLabel lblNewLabel_3 = new JLabel("New Customer ?");
		lblNewLabel_3.setBounds(161, 206, 130, 16);
		frame.getContentPane().add(lblNewLabel_3);

	}
}
