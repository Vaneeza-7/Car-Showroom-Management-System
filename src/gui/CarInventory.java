package gui;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.k33ptoo.components.KGradientPanel;

import businessLogic.CarInventoryController;
import businessLogic.CarViewFacade;
import businessLogic.car;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.*;

public class CarInventory {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CarInventory() {
		initialize();
	}

	  private static void pickDate(JFrame parentFrame, JTextField dateTextField) {
          JDialog dateDialog = new JDialog(parentFrame, "Date Picker", true);
          dateDialog.getContentPane().setLayout(new FlowLayout());

          JDatePicker picker = new JDatePicker();
          JButton selectButton = new JButton("Select");

          selectButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Date selectedDate = picker.getDate();
                  if (selectedDate != null) {
                      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                      dateTextField.setText(dateFormat.format(selectedDate));
                  }

                  dateDialog.dispose();
              }
          });

          dateDialog.getContentPane().add(picker);
          dateDialog.getContentPane().add(selectButton);
          dateDialog.setSize(300, 200);
          dateDialog.setLocationRelativeTo(parentFrame);
          dateDialog.setVisible(true);
      }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1078, 788);
            frame.getContentPane().setLayout(null);
           
            JTextPane txtpnManageCarsInventory = new JTextPane();
            txtpnManageCarsInventory.setEditable(false);
            txtpnManageCarsInventory.setBackground(new Color(51, 204, 204));
            txtpnManageCarsInventory.setFont(new Font("Tahoma", Font.BOLD, 30));
            txtpnManageCarsInventory.setText("                              Manage Cars Inventory");
            txtpnManageCarsInventory.setBounds(0, 0, 1366, 59);
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
                tableModel.addRow(new Object[]{Car.getVin(), Car.getModel(), Car.getMake(), Car.getYear(), Car.getColor(), Car.getMileage(), Car.getLastServiceDate(), Car.getPrice(), Car.getAvailability(), "DELETE", "UPDATE"});
            }

            // Create the JTable with the populated model
            JTable carTable = new JTable(tableModel);
            carTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 102)));
            carTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
            carTable.setBounds(213, 148, 883, 505);
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
             carTable.getColumnModel().getColumn(9).setMinWidth(100);
             carTable.getColumnModel().getColumn(10).setMinWidth(100);
             carTable.getColumnModel().getColumn(8).setMinWidth(95);
             

             carTable.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor2(new JButton("DELETE"), carTable, this));
             carTable.getColumnModel().getColumn(10).setCellEditor(new ButtonEditor2(new JButton("UPDATE"), carTable, this));
          
             
            // Add the JTable to a JScrollPane for scrollability
           // JScrollPane scrollPane = new JScrollPane(carTable);
          

            // Add the JScrollPane to the frame
            frame.getContentPane().add(carTable);
            
            textField = new JTextField();
            textField.setBounds(241, 664, 86, 20);
            frame.getContentPane().add(textField);
            textField.setColumns(10);
            
            textField_1 = new JTextField();
            textField_1.setBounds(335, 664, 86, 20);
            frame.getContentPane().add(textField_1);
            textField_1.setColumns(10);
            
            textField_2 = new JTextField();
            textField_2.setBounds(430, 664, 86, 20);
            frame.getContentPane().add(textField_2);
            textField_2.setColumns(10);
            
            textField_3 = new JTextField();
            textField_3.setBounds(526, 664, 86, 20);
            frame.getContentPane().add(textField_3);
            textField_3.setColumns(10);
            
            textField_4 = new JTextField();
            textField_4.setBounds(621, 664, 86, 20);
            frame.getContentPane().add(textField_4);
            textField_4.setColumns(10);
            
            textField_5 = new JTextField();
            textField_5.setBounds(714, 664, 86, 20);
            frame.getContentPane().add(textField_5);
            textField_5.setColumns(10);
            
            textField_6 = new JTextField();
            textField_6.setBounds(806, 664, 86, 20);
            frame.getContentPane().add(textField_6);
            textField_6.setColumns(10);
            
            textField_7 = new JTextField();
            textField_7.setBounds(897, 664, 86, 20);
            frame.getContentPane().add(textField_7);
            textField_7.setColumns(10);
            
            btnNewButton = new JButton("ADD");
            btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
            btnNewButton.setBackground(new Color(0, 204, 204));
            btnNewButton.setForeground(new Color(255, 255, 255));
            btnNewButton.setBounds(993, 661, 89, 23);
            frame.getContentPane().add(btnNewButton);
            
                                   
                     // Add ActionListener to the button
                        btnNewButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            	String vin= textField.getText();
                            	String make= textField_1.getText();
                            	String model= textField_2.getText();
                            	int year= Integer.parseInt(textField_3.getText());
                            	String color = textField_4.getText();;
                            	double mile= Double.parseDouble(textField_5.getText());
                            	String avail= textField_7.getText();
                            	LocalDate currentDate = LocalDate.now();
                            	 Date date = java.sql.Date.valueOf(currentDate);
                            	//WHYYY
                            	double price = Double.parseDouble(textField_6.getText());


                                CarInventoryController control = new CarInventoryController();
                                control.addCar(vin, make, model, price, year, date , 0, color, mile, avail);
                            	
                            	
                                JOptionPane.showMessageDialog(null, "Car Added Successfully");
                            }
                        });


            
            frame.setVisible(true);
       
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
