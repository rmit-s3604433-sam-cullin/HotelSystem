package jebs.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LatestNewBookings {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public LatestNewBookings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//All latest bookings hard coded data
		JLabel lbllatestBookingSummary = new JLabel("<HTML><U>Latest Booking Summary</U></HTML>");
		lbllatestBookingSummary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbllatestBookingSummary.setBounds(182, 11, 229, 22);
		frame.getContentPane().add(lbllatestBookingSummary);
		
		JLabel label_1 = new JLabel("Employee In-Charge");
		label_1.setBounds(456, 69, 117, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Time");
		label_2.setBounds(363, 70, 29, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setBounds(277, 70, 29, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Customer ID");
		label_4.setBounds(171, 69, 73, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Customer Name");
		label_5.setBounds(58, 69, 93, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("No.");
		label_6.setBounds(20, 70, 23, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("1 ");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(26, 110, 11, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("2");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(26, 150, 11, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("3");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(26, 193, 11, 14);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Luke");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(58, 194, 46, 14);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("Tim");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(58, 151, 46, 14);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("Nick");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(58, 111, 46, 14);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("c002");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(171, 111, 46, 14);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("22/04/17");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_14.setBounds(277, 111, 52, 14);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("2pm-3pm");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_15.setBounds(363, 111, 52, 14);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("e003 - Rocky");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_16.setBounds(456, 110, 78, 14);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("e009 - Max");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_17.setBounds(456, 150, 78, 14);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("e012 - Max");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_18.setBounds(456, 193, 78, 14);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("2pm-3pm");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_19.setBounds(363, 194, 52, 14);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("2pm-3pm");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_20.setBounds(363, 151, 52, 14);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("24/04/17");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_21.setBounds(277, 194, 52, 14);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("23/04/17");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_22.setBounds(277, 151, 52, 14);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("c021");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_23.setBounds(171, 194, 46, 14);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("c004");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_24.setBounds(171, 151, 46, 14);
		frame.getContentPane().add(label_24);
		
		//Button label for Owner to go back to Main Booking Summary page
		JLabel lblviewBookingSummary = new JLabel("<HTML><U>View Booking Summary</HTML></U>");
		lblviewBookingSummary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BookingSummary window = new BookingSummary();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblviewBookingSummary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblviewBookingSummary.setBounds(440, 385, 144, 28);
		frame.getContentPane().add(lblviewBookingSummary);
		
		//Button label for Owner to go back to Main Menu
		JLabel label_26 = new JLabel("<HTML><U>Main Menu</HTML></U>");
		label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_26.setBounds(20, 385, 64, 28);
		frame.getContentPane().add(label_26);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
