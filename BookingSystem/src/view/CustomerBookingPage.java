package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerBookingPage {

	private JFrame frame;
	@SuppressWarnings("unused")
	private JTable table;

	/*
	 * Launch the application.
	 */


	/*
	 * Create the application.
	 */
	public CustomerBookingPage() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 521, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make a Booking");
		lblNewLabel.setBounds(172, 6, 117, 16);
		getFrame().getContentPane().add(lblNewLabel);
		
		Calender calender = new Calender();
		calender.setBounds(23,23,250,200);
		getFrame().getContentPane().add(calender);
		
		DayView day = new DayView();
		day.setBounds(293,53,100,170);
		getFrame().getContentPane().add(day);
		
		JButton btnNewButton = new JButton("Book!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* code for checking if the booking is valid and either
				 * prompt the user to chose another date
				 * or add the booking to the database
				 */
			}
		});
		btnNewButton.setBounds(398, 69, 117, 99);
		frame.getContentPane().add(btnNewButton);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}