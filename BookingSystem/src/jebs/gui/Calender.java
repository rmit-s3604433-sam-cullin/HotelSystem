package jebs.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Calender extends JPanel {

	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel label;

	Calender() {

		
		this.setSize(300,200);
		this.setLayout(new BorderLayout());
		this.setVisible(true);


		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton b1 = new JButton("<-");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		JButton b2 = new JButton("->");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(b1,BorderLayout.WEST);
		panel.add(label,BorderLayout.CENTER);
		panel.add(b2,BorderLayout.EAST);


		String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		model = new DefaultTableModel(null,columns);
		JTable table = new JTable(model){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row,int column){
				return false;
			};
		};
		table.setCellSelectionEnabled(true);
		
		JScrollPane pane = new JScrollPane(table);
		
		this.add(panel,BorderLayout.NORTH);
		this.add(pane,BorderLayout.CENTER);

		this.updateMonth();

	}

	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		label.setText(month + " " + year);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}

	}

}