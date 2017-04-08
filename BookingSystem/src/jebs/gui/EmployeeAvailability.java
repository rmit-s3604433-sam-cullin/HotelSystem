package jebs.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;

import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeAvailability {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public EmployeeAvailability() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Page content including title and tab panels
		JLabel lblemployeeAvailability = new JLabel("<HTML><U>Employee Availability</U></HTML>");
		lblemployeeAvailability.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblemployeeAvailability.setBounds(175, 22, 202, 22);
		frame.getContentPane().add(lblemployeeAvailability);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 75, 533, 367);
		frame.getContentPane().add(tabbedPane_2);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.addTab("April", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Week 1", null, tabbedPane, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Monday", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("No.");
		label_3.setBounds(21, 56, 23, 14);
		panel.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(104, 55, 60, 17);
		panel.add(lblEmployee);
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("Time");
		label_1.setBounds(247, 55, 29, 14);
		panel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_7 = new JLabel("2pm-3pm");
		label_7.setBounds(247, 96, 165, 14);
		panel.add(label_7);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_8 = new JLabel("2pm-3pm");
		label_8.setBounds(247, 136, 146, 14);
		panel.add(label_8);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblpmpmpmpm = new JLabel("2pm-3pm / 4pm-5pm");
		lblpmpmpmpm.setBounds(247, 179, 146, 14);
		panel.add(lblpmpmpmpm);
		lblpmpmpmpm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_13 = new JLabel("e012 - Max");
		label_13.setBounds(104, 178, 78, 14);
		panel.add(label_13);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_14 = new JLabel("e009 - Max");
		label_14.setBounds(104, 135, 78, 14);
		panel.add(label_14);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_15 = new JLabel("e003 - Rocky");
		label_15.setBounds(104, 95, 78, 14);
		panel.add(label_15);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_4 = new JLabel("1 ");
		label_4.setBounds(27, 96, 11, 14);
		panel.add(label_4);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_5 = new JLabel("2");
		label_5.setBounds(27, 136, 11, 14);
		panel.add(label_5);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_6 = new JLabel("3");
		label_6.setBounds(27, 179, 11, 14);
		panel.add(label_6);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label_10 = new JLabel("<HTML><U>06/04/2017</U></HTML>");
		label_10.setBounds(21, 22, 68, 14);
		panel.add(label_10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tuesday", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("No.");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(21, 60, 23, 14);
		panel_1.add(label);
		
		JLabel label_2 = new JLabel("Employee");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(104, 59, 60, 17);
		panel_1.add(label_2);
		
		JLabel label_9 = new JLabel("Time");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(247, 59, 29, 14);
		panel_1.add(label_9);
		
		JLabel lblpmpm = new JLabel("10am-12pm / 4pm-5pm");
		lblpmpm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpmpm.setBounds(247, 100, 165, 14);
		panel_1.add(lblpmpm);
		
		JLabel lblamampmpm = new JLabel("9am-11am / 2pm-3pm");
		lblamampmpm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblamampmpm.setBounds(247, 140, 146, 14);
		panel_1.add(lblamampmpm);
		
		JLabel label_12 = new JLabel("e009 - Max");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(104, 139, 78, 14);
		panel_1.add(label_12);
		
		JLabel label_16 = new JLabel("e003 - Rocky");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_16.setBounds(104, 99, 78, 14);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("1 ");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_17.setBounds(27, 100, 11, 14);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("2");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_18.setBounds(27, 140, 11, 14);
		panel_1.add(label_18);
		
		JLabel label_11 = new JLabel("<HTML><U>07/04/2017</U></HTML>");
		label_11.setBounds(21, 22, 68, 14);
		panel_1.add(label_11);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Wednesday", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Thursday", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Friday", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Saturday", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Week 2", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Week 3", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Week 4", null, panel_8, null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("May", null, panel_9, null);
		
		//Button Label to go back Main Menu
		JLabel label_19 = new JLabel("<HTML><U>Main Menu</HTML></U>");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
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
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_19.setBounds(20, 471, 64, 28);
		frame.getContentPane().add(label_19);

	}
	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}