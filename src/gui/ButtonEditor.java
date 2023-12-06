package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.Objects;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

// ButtonEditor class to handle button clicks
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String action;
    private JTable carTable;
    private ViewCars frame;

    public ButtonEditor(JButton button, JTable carTable, ViewCars frame) {
        super(new JCheckBox());
        this.button = button;
        this.button.setOpaque(true);
        this.carTable = carTable;
        this.frame=frame;

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
        	
            if (action.equals("PURCHASE ORDER")) {
            	frame.getFrame().dispose();
            	frame.showPurchaseFrame(vin);
            	
                System.out.println("PURCHASE ORDER button clicked");
                
            } else if (action.equals("SCHEDULE TEST DRIVE")) {
            	frame.getFrame().dispose();
            	frame.showTestDriveFrame(vin);
            	

            	
                System.out.println("SCHEDULE TEST DRIVE button clicked");
            }
          }
        });
     }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}

