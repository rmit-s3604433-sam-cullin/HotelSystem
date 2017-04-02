package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class DayView extends JPanel{

	DefaultTableModel model;
	JLabel label;
	Date day; 
	JTable table;
	
	
	DayView(){
		this.setSize(100,200);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		String [] columns = {"Times"};
		model = new DefaultTableModel(columns,3);
		table = new JTable(model);
		table.setRowHeight(33);
		JScrollPane pane = new JScrollPane(table);
		
		
		this.add(pane,BorderLayout.CENTER);
		this.updateDay();
		
		
	}
		
	void updateDay(){
		Boolean times[] = getAvailable();
		
		int index = 0;
		for(Boolean time: times){
			table.isCellSelected(index, 0);
			if(time){
				model.setValueAt("avalible", index, 0);
				
				
			}else{
				model.setValueAt("Booked", index, 0);
			}
			index ++;
		}
	}
	

	
	Boolean [] getAvailable(){
		Boolean times[] = {true ,false ,true};
		
		/*
		 * SQL code for getting available info for current day selected
		 */
		return times;
	}
	
}