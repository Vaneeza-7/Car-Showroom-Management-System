package gui;


import java.awt.Component;
import java.awt.EventQueue;
import java.util.Objects;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import businessLogic.CarInventoryController;

// ButtonEditor class to handle button clicks
class ButtonEditor2 extends DefaultCellEditor {
    private JButton button;
    private String action;
    private JTable carTable;
    private CarInventory frame;

    public ButtonEditor2(JButton button, JTable carTable, CarInventory viewCars) {
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
        	
            if (action.equals("DELETE")) {
            	System.out.println("DELETE button clicked");
            	CarInventoryController control = new CarInventoryController();
            	control.deleteCar(vin);
            	JOptionPane.showMessageDialog(null, "Car Deleted Successfully");
            	
                System.out.println("DELETE button clicked");
                
                
            } else if (action.equals("UPDATE")) {
            	System.out.println("UPDATE button clicked");
            	
            	frame.getFrame().dispose();
            	//frame.
            	EventQueue.invokeLater(() -> {
               	 // Dispose the current Signup frame
               	//frame.dispose();
                   UpdateCar window = new UpdateCar(vin);
        			window.getFrame().setVisible(true);
               });
	
            	
            	
            }
          }
        });
     }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}

