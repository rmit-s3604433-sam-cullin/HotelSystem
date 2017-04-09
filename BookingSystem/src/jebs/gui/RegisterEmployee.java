package jebs.gui;

import jebs.object.Employee;

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
		frame.setBounds(100, 100, 450, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Registration = new JLabel("Employee Registration");
		Registration.setFont(new Font("Tahoma", Font.BOLD, 18));
		Registration.setBounds(117, 22, 210, 30);
		frame.getContentPane().add(Registration);
		
		JLabel EmpID = new JLabel("Employee ID :");
		EmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpID.setBounds(49, 77, 100, 19);
		frame.getContentPane().add(EmpID);
		
		JLabel EmpName = new JLabel("Name :");
		EmpName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpName.setBounds(94, 121, 49, 19);
		frame.getContentPane().add(EmpName);
		
		JLabel EmpAddress = new JLabel("Address :");
		EmpAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpAddress.setBounds(81, 167, 62, 19);
		frame.getContentPane().add(EmpAddress);
		
		JLabel EmpMobile = new JLabel("Mobile Number :");
		EmpMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmpMobile.setBounds(37, 212, 107, 19);
		frame.getContentPane().add(EmpMobile);
		
		EMPIDinput = new JTextField(10);
		EMPIDinput.setBounds(171, 76, 190, 22);
		frame.getContentPane().add(EMPIDinput);
		EMPIDinput.setColumns(10);
		
		EMPNAMEinput = new JTextField();
		EMPNAMEinput.setColumns(10);
		EMPNAMEinput.setBounds(171, 122, 190, 22);
		frame.getContentPane().add(EMPNAMEinput);
		
		EMPADDRSinput = new JTextField();
		EMPADDRSinput.setColumns(10);
		EMPADDRSinput.setBounds(171, 168, 190, 22);
		frame.getContentPane().add(EMPADDRSinput);
		
		EMPMOBNOinput = new JTextField();
		EMPMOBNOinput.setColumns(10);
		EMPMOBNOinput.setBounds(171, 213, 190, 22);
		frame.getContentPane().add(EMPMOBNOinput);
		
		JLabel lblLabelError1 = new JLabel("<HTML><font color = 'red'>Invalid ID.</font></HTML>");
		lblLabelError1.setBounds(175, 96, 107, 22);
		frame.getContentPane().add(lblLabelError1);
		lblLabelError1.setVisible(false);
		
		JLabel lblLabelError2 = new JLabel("<HTML><font color = 'red'>Invalid Name.</font></HTML>");
		lblLabelError2.setBounds(175, 140, 107, 22);
		frame.getContentPane().add(lblLabelError2);
		lblLabelError2.setVisible(false);
		
		JLabel lblLabelError4 = new JLabel("<HTML><font color = 'red'>Invalid Address.</font></HTML>");
		lblLabelError4.setBounds(175, 187, 107, 22);
		frame.getContentPane().add(lblLabelError4);
		lblLabelError4.setVisible(false);
		
		JLabel lblLabelError5 = new JLabel("<HTML><font color = 'red'>Invalid Mobile Number.</font></HTML>");
		lblLabelError5.setBounds(175, 230, 162, 22);
		frame.getContentPane().add(lblLabelError5);
		lblLabelError5.setVisible(false);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			
			//Once the Register button is clicked, it stores all the user input into respective String
			public void actionPerformed(ActionEvent e) {
							
				String empid = EMPIDinput.getText();
				String name = EMPNAMEinput.getText();
				String address = EMPADDRSinput.getText();
				String number = EMPMOBNOinput.getText();
				
				Employee nE = new Employee();
				
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
				//If all input is valid, it stores the new employee data into the database
				if(!(nE.getID() == null) && !(nE.getName() == null) && !(nE.getNumber() == null)
						&& !(nE.getAddress() == null)){
					nE.addEmployee(nE);
					JOptionPane.showMessageDialog(null,"Successfully added new employee!");
					frame.setVisible(false);
					frame.dispose();
					new Login();
				}
			}
		});
		
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(164, 284, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		//Go back button for Owner to return to Main Menu
		JLabel lblGoBackMain = new JLabel("<HTML><U>Go back</U></HTML>");
		lblGoBackMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		lblGoBackMain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGoBackMain.setBounds(186, 329, 49, 14);
		frame.getContentPane().add(lblGoBackMain);
		
		frame.setVisible(true);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}