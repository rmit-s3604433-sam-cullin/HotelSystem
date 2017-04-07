package view;

import mainpackage.Employee;

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

public class RegisterEmployee {

	private JFrame frame;
	private JTextField EMPIDinput;
	private JTextField EMPNAMEinput;
	private JTextField EMPADDRSinput;
	private JTextField EMPMOBNOinput;
	public JLabel lblLabelError1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RegisterEmployee() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Registration = new JLabel("Employee Registration");
		Registration.setFont(new Font("Tahoma", Font.BOLD, 18));
		Registration.setBounds(116, 22, 208, 22);
		frame.getContentPane().add(Registration);
		
		JLabel EmpID = new JLabel("Employee ID :");
		EmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpID.setBounds(86, 79, 65, 19);
		frame.getContentPane().add(EmpID);
		
		JLabel EmpName = new JLabel("Name :");
		EmpName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpName.setBounds(96, 119, 49, 19);
		frame.getContentPane().add(EmpName);
		
		JLabel EmpAddress = new JLabel("Address :");
		EmpAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpAddress.setBounds(83, 210, 62, 19);
		frame.getContentPane().add(EmpAddress);
		
		JLabel EmpMobile = new JLabel("Mobile Number :");
		EmpMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpMobile.setBounds(39, 250, 107, 19);
		frame.getContentPane().add(EmpMobile);
		
		EMPIDinput = new JTextField(10);
		EMPIDinput.setBounds(173, 78, 190, 22);
		frame.getContentPane().add(EMPIDinput);
		EMPIDinput.setColumns(10);
		
		EMPNAMEinput = new JTextField();
		EMPNAMEinput.setColumns(10);
		EMPNAMEinput.setBounds(173, 120, 190, 22);
		frame.getContentPane().add(EMPNAMEinput);
		
		EMPADDRSinput = new JTextField();
		EMPADDRSinput.setColumns(10);
		EMPADDRSinput.setBounds(173, 211, 190, 22);
		frame.getContentPane().add(EMPADDRSinput);
		
		EMPMOBNOinput = new JTextField();
		EMPMOBNOinput.setColumns(10);
		EMPMOBNOinput.setBounds(173, 251, 190, 22);
		frame.getContentPane().add(EMPMOBNOinput);
		
		JLabel lblLabelError1 = new JLabel("<HTML><font color = 'red'>Invalid ID.</font></HTML>");
		lblLabelError1.setBounds(175, 96, 107, 22);
		frame.getContentPane().add(lblLabelError1);
		lblLabelError1.setVisible(false);
		
		JLabel lblLabelError2 = new JLabel("<HTML><font color = 'red'>Invalid Name.</font></HTML>");
		lblLabelError2.setBounds(175, 137, 107, 22);
		frame.getContentPane().add(lblLabelError2);
		lblLabelError2.setVisible(false);
		
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
							
				String empid = EMPIDinput.getText();
				String name = EMPNAMEinput.getText();
				String address = EMPADDRSinput.getText();
				String number = EMPMOBNOinput.getText();
				
				Employee nE = new Employee();
				//AddCustomer customer = new AddCustomer();
				
				//Input validate customer ID
				nE.setID(empid);
				if(nE.getID() == null) {				
					lblLabelError1.setVisible(true);
				} else {
					lblLabelError1.setVisible(false);
				}
				//Input validate customer Name
				nE.setName(name);
				if(nE.getName() == null) {			
					lblLabelError2.setVisible(true);
				} else {
					lblLabelError2.setVisible(false);
				}
				//Input validate customer Address
				nE.setAddress(address);
				if(nE.getAddress() == null){
					lblLabelError4.setVisible(true);
				} else {
					lblLabelError4.setVisible(false);
				}
				//Input validate customer Mobile Number
				nE.setNumber(number);
				if(nE.getNumber() == null){
					lblLabelError5.setVisible(true);
				} else {
					lblLabelError5.setVisible(false);
				}
				
				if(!(nE.getID() == null) && !(nE.getName() == null) && !(nE.getNumber() == null)
						&& !(nE.getAddress() == null)){
					nE.addEmployee(nE);
					JOptionPane.showMessageDialog(null,"Registration Successful");
					frame.setVisible(false);
					frame.dispose();
					new Login();
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
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
