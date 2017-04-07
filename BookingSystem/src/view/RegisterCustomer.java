package view;

import mainpackage.Customer;
import mainpackage.Person;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterCustomer {

	JFrame frame;
	private JTextField REGIDinput;
	private JTextField REGNAMEinput;
	private JTextField REGPASSinput;
	private JTextField REGADDRSinput;
	private JTextField REGMOBNOinput;
	public JLabel lblLabelError1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RegisterCustomer() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 447);
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
		CustAddress.setBounds(83, 210, 62, 19);
		frame.getContentPane().add(CustAddress);
		
		JLabel CustMobile = new JLabel("Mobile Number :");
		CustMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CustMobile.setBounds(39, 250, 107, 19);
		frame.getContentPane().add(CustMobile);
		
		REGIDinput = new JTextField(10);
		REGIDinput.setBounds(173, 78, 190, 22);
		frame.getContentPane().add(REGIDinput);
		REGIDinput.setColumns(10);
		
		REGNAMEinput = new JTextField();
		REGNAMEinput.setColumns(10);
		REGNAMEinput.setBounds(173, 120, 190, 22);
		frame.getContentPane().add(REGNAMEinput);
		
		REGPASSinput = new JTextField();
		REGPASSinput.setColumns(10);
		REGPASSinput.setBounds(173, 161, 190, 22);
		frame.getContentPane().add(REGPASSinput);
		
		REGADDRSinput = new JTextField();
		REGADDRSinput.setColumns(10);
		REGADDRSinput.setBounds(173, 211, 190, 22);
		frame.getContentPane().add(REGADDRSinput);
		
		REGMOBNOinput = new JTextField();
		REGMOBNOinput.setColumns(10);
		REGMOBNOinput.setBounds(173, 251, 190, 22);
		frame.getContentPane().add(REGMOBNOinput);
		
		JLabel lblLabelError1 = new JLabel("<HTML><font color = 'red'>Invalid ID.</font></HTML>");
		lblLabelError1.setBounds(175, 96, 107, 22);
		frame.getContentPane().add(lblLabelError1);
		lblLabelError1.setVisible(false);
		
		JLabel lblLabelError2 = new JLabel("<HTML><font color = 'red'>Invalid Name.</font></HTML>");
		lblLabelError2.setBounds(175, 137, 107, 22);
		frame.getContentPane().add(lblLabelError2);
		lblLabelError2.setVisible(false);
		
		JLabel lblLabelError3 = new JLabel("<HTML><font color = 'red'>Invalid Password.</font></HTML>");
		lblLabelError3.setBounds(175, 177, 107, 22);
		frame.getContentPane().add(lblLabelError3);
		lblLabelError3.setVisible(false);
		
		JLabel lblLabelError4 = new JLabel("<HTML><font color = 'red'>Invalid Address.</font></HTML>");
		lblLabelError4.setBounds(175, 227, 107, 22);
		frame.getContentPane().add(lblLabelError4);
		lblLabelError4.setVisible(false);
		
		JLabel lblLabelError5 = new JLabel("<HTML><font color = 'red'>Invalid Mobile Number.</font></HTML>");
		lblLabelError5.setBounds(175, 267, 130, 22);
		frame.getContentPane().add(lblLabelError5);
		lblLabelError5.setVisible(false);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
							
				String custid = REGIDinput.getText();
				String name = REGNAMEinput.getText();
				String password = REGPASSinput.getText();
				String address = REGADDRSinput.getText();
				String number = REGMOBNOinput.getText();
				
				Person nC = new Customer();
				//AddCustomer customer = new AddCustomer();
				
				//Input validate customer ID
				nC.setID(custid);
				if(nC.getID() == null) {				
					lblLabelError1.setVisible(true);
				} else {
					lblLabelError1.setVisible(false);
				}
				//Input validate customer Name
				nC.setName(name);
				if(nC.getName() == null) {			
					lblLabelError2.setVisible(true);
				} else {
					lblLabelError2.setVisible(false);
				}
				//Input validate customer Password
				nC.setPassword(password);
				if(nC.getPassword() == null){
					lblLabelError3.setVisible(true);
				} else {
					lblLabelError3.setVisible(false);
				}
				//Input validate customer Address
				nC.setAddress(address);
				if(nC.getAddress() == null){
					lblLabelError4.setVisible(true);
				} else {
					lblLabelError4.setVisible(false);
				}
				//Input validate customer Mobile Number
				nC.setNumber(number);
				if(nC.getNumber() == null){
					lblLabelError5.setVisible(true);
				} else {
					lblLabelError5.setVisible(false);
				}
				
				if(!(nC.getID() == null) && !(nC.getName() == null) && !(nC.getPassword() == null) && !(nC.getNumber() == null)
						&& !(nC.getAddress() == null)){
					nC.addCustomer(nC);
					JOptionPane.showMessageDialog(null,"Registration Successful");
					frame.setVisible(false);
					frame.dispose();
					LoginGUI window = new LoginGUI();
					window.getFrame().setVisible(true);
				}
			}
		});
		
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(161, 313, 100, 30);
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
		lblGoBackMain.setBounds(187, 365, 49, 14);
		frame.getContentPane().add(lblGoBackMain);
		
		JLabel lblCharactersLong = new JLabel("(8-20 characters long)");
		lblCharactersLong.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCharactersLong.setBounds(44, 181, 107, 14);
		frame.getContentPane().add(lblCharactersLong);
		
		frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public Window getFrame() {	
		return frame;
	}
}