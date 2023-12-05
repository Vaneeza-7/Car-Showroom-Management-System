package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businessLogic.CarInventoryController;
import businessLogic.CarViewFacade;
import businessLogic.car;

public class ViewCars {
   int userID;
	private JFrame frame;

	/**
	 * Launch the application.
	
	/**
	 * Create the application.
	 * @param userId 
	 */
	public ViewCars(int userId) {
		this.userID=userId;
		initialize();
	}



	public void showPurchaseFrame(String vin)
	{
		
		EventQueue.invokeLater(() -> {
        	 // Dispose the current Signup frame
        	frame.dispose();
            GivePurchaseOrder window = new GivePurchaseOrder(userID, vin);
 			window.getFrame().setVisible(true);
        });
   	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(848, 509);
        frame.getContentPane().setLayout(null);
       
        JTextPane txtpnManageCarsInventory = new JTextPane();
        txtpnManageCarsInventory.setBounds(0, 0, 1367, 59);
        txtpnManageCarsInventory.setEditable(false);
        txtpnManageCarsInventory.setBackground(new Color(51, 204, 204));
        txtpnManageCarsInventory.setFont(new Font("Tahoma", Font.BOLD, 30));
        txtpnManageCarsInventory.setText("                              Select your Dream Ride ");
        frame.getContentPane().add(txtpnManageCarsInventory);
        
        // Initialize the table model
        CarViewFacade facade = new CarViewFacade();
        List<car> cars = facade.retreiveCars();
        
        String[] columnNames = {"VIN", "Make", "Model", "Year", "Color", "Mileage", "Last Service Date", "Price", "Status", "Actions", "Actions"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        //tableModel.setColumnIdentifiers(columnNames);
        tableModel.addRow(columnNames);
        for (car Car : cars) {
        	System.out.println("A row added");
            tableModel.addRow(new Object[]{Car.getVin(), Car.getModel(), Car.getMake(), Car.getYear(), Car.getColor(), Car.getMileage(), Car.getLastServiceDate(), Car.getPrice(), Car.getAvailability(), "PURCHASE ORDER", "SCHEDULE TEST DRIVE"});
        }

        // Create the JTable with the populated model
        JTable carTable = new JTable(tableModel);
        carTable.setBounds(113, 111, 1073, 522);
        carTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 102)));
        carTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
        carTable.setBackground(new Color(0, 0, 0));

        carTable.setForeground(Color.WHITE);
        carTable.setFont(new Font("Times New Roman", Font.BOLD, 16));
        carTable.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        carTable.getTableHeader().setBackground(new Color(0, 0, 102));
        carTable.getTableHeader().setForeground(Color.WHITE);
        carTable.setRowHeight(30);

        // Center-align numeric columns
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        carTable.getColumnModel().getColumn(3).setCellRenderer(leftRenderer); // Adjust column index as needed

        // Center-align status column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        carTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer); // Adjust column index as needed
         carTable.getColumnModel().getColumn(6).setMinWidth(120);
        
      // Add a button as the last column
         carTable.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
         carTable.getColumnModel().getColumn(10).setCellRenderer(new ButtonRenderer());
         carTable.getColumnModel().getColumn(9).setMinWidth(150);
         carTable.getColumnModel().getColumn(10).setMinWidth(150);
         carTable.getColumnModel().getColumn(8).setMinWidth(95);
        // Add the JTable to a JScrollPane for scrollability
       // JScrollPane scrollPane = new JScrollPane(carTable);
         
         carTable.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor(new JButton("PURCHASE ORDER"), carTable, this));
         carTable.getColumnModel().getColumn(10).setCellEditor(new ButtonEditor(new JButton("SCHEDULE TEST DRIVE"), carTable, this));
      
         

        // Add the JScrollPane to the frame
        frame.getContentPane().add(carTable);
        
        frame.setVisible(true);
   
}

public JFrame getFrame() {
	// TODO Auto-generated method stub
	return frame;
}

		
}


