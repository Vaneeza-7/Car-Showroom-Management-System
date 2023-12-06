package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.Objects;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import businessLogic.CarInventoryController;

public class ButtonEditor3 extends DefaultCellEditor{
	 private JButton button;
	    private String action;
	    private JTable carTable;
	    private ScheduleServiceDashboard frame;

	    public ButtonEditor3(JButton button, JTable carTable, ScheduleServiceDashboard viewCars) {
	        super(new JCheckBox());
	        this.button = button;
	        this.button.setOpaque(true);
	        this.carTable = carTable;
	        this.frame=viewCars;

	        // Add action listener to the button
	        this.button.addActionListener(e -> {
	    
	        	int selectedRow = carTable.getSelectedRow();
	            if (selectedRow != -1) {
	            	String vin = Objects.toString(carTable.getValueAt(selectedRow, 0), "");
	            	String model = Objects.toString(carTable.getValueAt(selectedRow, 1), "");
	            	String make = Objects.toString(carTable.getValueAt(selectedRow, 2), "");

	            	action = button.getText(); 
	            	  System.out.println("Selected Action: " + action);
	                  System.out.println("Selected VIN: " + vin);
	                  System.out.println("Selected Model: " + model);
	                  System.out.println("Selected Make: " + make);
	        	
	            if (action.equals("SCHEDULE SERVICE")) {
	            	System.out.println("service button clicked");
	            	frame.getFrame().dispose();
	            	//frame.
	            	EventQueue.invokeLater(() -> {
	               	 // Dispose the current Signup frame
	               	//frame.dispose();
	                   ScheduleService window = new ScheduleService(vin);
	        			window.getFrame().setVisible(true);
	               });
		
	                System.out.println("Schedule button clicked");
	                
	                
	            } 
	            	
	            	
	            	
	            	
	            }
	          
	        });
	     }
	    
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        return button;
	    }
	}
