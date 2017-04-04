package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingSummary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingSummary window = new BookingSummary();
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
	public BookingSummary() {
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
		
		JLabel lblBookingSummary = new JLabel("<HTML><U>Booking Summary</U></HTML>");
		lblBookingSummary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookingSummary.setBounds(203, 11, 171, 22);
		frame.getContentPane().add(lblBookingSummary);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		/*lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblNewLabel.setBounds(58, 69, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		/*lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblCustomerId.setBounds(171, 69, 73, 14);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblDate = new JLabel("Date");
		/*lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblDate.setBounds(277, 70, 29, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		/*lblTime.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblTime.setBounds(363, 70, 29, 14);
		frame.getContentPane().add(lblTime);
		
		JLabel lblEmployeeIncharge = new JLabel("Employee In-Charge");
		/*lblEmployeeIncharge.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblEmployeeIncharge.setBounds(456, 69, 117, 14);
		frame.getContentPane().add(lblEmployeeIncharge);
		
		JLabel lblNo = new JLabel("No.");
		/*lblNo.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		lblNo.setBounds(20, 70, 23, 14);
		frame.getContentPane().add(lblNo);
		
		JLabel label = new JLabel("1 ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(26, 110, 11, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNick.setBounds(58, 111, 46, 14);
		frame.getContentPane().add(lblNick);
		
		JLabel lblC = new JLabel("c002");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblC.setBounds(171, 111, 46, 14);
		frame.getContentPane().add(lblC);
		
		JLabel label_1 = new JLabel("12/04/17");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(277, 111, 52, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblpmpm = new JLabel("2pm-3pm");
		lblpmpm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpmpm.setBounds(363, 111, 52, 14);
		frame.getContentPane().add(lblpmpm);
		
		JLabel lblERocky = new JLabel("e003 - Rocky");
		lblERocky.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblERocky.setBounds(456, 110, 78, 14);
		frame.getContentPane().add(lblERocky);
		
		JLabel label_2 = new JLabel("2");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(26, 150, 11, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblTim = new JLabel("Tim");
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTim.setBounds(58, 151, 46, 14);
		frame.getContentPane().add(lblTim);
		
		JLabel lblC_1 = new JLabel("c004");
		lblC_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblC_1.setBounds(171, 151, 46, 14);
		frame.getContentPane().add(lblC_1);
		
		JLabel label_5 = new JLabel("15/04/17");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(277, 151, 52, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("2pm-3pm");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(363, 151, 52, 14);
		frame.getContentPane().add(label_6);
		
		JLabel lblEMax = new JLabel("e009 - Max");
		lblEMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEMax.setBounds(456, 150, 78, 14);
		frame.getContentPane().add(lblEMax);
		
		JLabel label_3 = new JLabel("3");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(26, 193, 11, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblLuke = new JLabel("Luke");
		lblLuke.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLuke.setBounds(58, 194, 46, 14);
		frame.getContentPane().add(lblLuke);
		
		JLabel lblC_2 = new JLabel("c021");
		lblC_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblC_2.setBounds(171, 194, 46, 14);
		frame.getContentPane().add(lblC_2);
		
		JLabel label_8 = new JLabel("17/04/17");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(277, 194, 52, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("2pm-3pm");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(363, 194, 52, 14);
		frame.getContentPane().add(label_9);
		
		JLabel lblEMax_1 = new JLabel("e012 - Max");
		lblEMax_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEMax_1.setBounds(456, 193, 78, 14);
		frame.getContentPane().add(lblEMax_1);
		
		JLabel lblMainMenu = new JLabel("<HTML><U>Main Menu</HTML></U>");
		lblMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							OwnerMenu window = new OwnerMenu();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMainMenu.setBounds(20, 385, 64, 28);
		frame.getContentPane().add(lblMainMenu);
		
		JLabel lblviewLatestBookings = new JLabel("<HTML><U>View Latest Bookings</HTML></U>");
		lblviewLatestBookings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LatestNewBookings window = new LatestNewBookings();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblviewLatestBookings.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblviewLatestBookings.setBounds(450, 385, 134, 28);
		frame.getContentPane().add(lblviewLatestBookings);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
