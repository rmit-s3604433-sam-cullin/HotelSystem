package jebs.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

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
		
		//Button label for customer to view available time and date to book for an appointment
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
							// there is no more login, change the scene instead
							// new Login();
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
	// --------------------------------------> change the scene <---------------------------------
	public static Scene menu() {
		
		Pane layout = new Pane();
		Scene scene2 = new Scene(layout, 1200, 800);
		
		return scene2;
	
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
