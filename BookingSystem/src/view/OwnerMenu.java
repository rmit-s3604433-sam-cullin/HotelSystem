package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OwnerMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public OwnerMenu() {
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
		
		JLabel label = new JLabel("<HTML><U>John's Electrician Booking System</U></HTML>");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(64, 21, 306, 30);
		frame.getContentPane().add(label);
		
		JLabel label2 = new JLabel("Add New Employee");
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddNewEmployee window = new AddNewEmployee();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		label2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label2.setBounds(146, 69, 124, 22);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Add Work Time / Dates");
		label3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label3.setBounds(134, 102, 148, 22);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("View Booking Summary");
		label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		label4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label4.setBounds(134, 135, 148, 22);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("View Employee Availability");
		label5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label5.setBounds(125, 168, 205, 22);
		frame.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("Logout");
		label6.addMouseListener(new MouseAdapter() {
			/*@Override*/
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		label6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label6.setBounds(180, 201, 49, 22);
		frame.getContentPane().add(label6);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
