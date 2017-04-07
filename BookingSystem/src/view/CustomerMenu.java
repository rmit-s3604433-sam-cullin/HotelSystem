package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerMenu {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public CustomerMenu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("<HTML><U>John's Electrician Booking System</U></HTML>");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(65, 21, 306, 30);
		frame.getContentPane().add(label);
		
		//Button label for customer to view the available date and time to book an appointment
		JLabel lblViewAvailable = new JLabel("View Available Date & Time");
		lblViewAvailable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblViewAvailable.setBounds(125, 74, 175, 22);
		frame.getContentPane().add(lblViewAvailable);
		
		//Button label for customer to logout of the system
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new LoginGUI();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLogout.setBounds(184, 107, 50, 22);
		frame.getContentPane().add(lblLogout);
		
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
