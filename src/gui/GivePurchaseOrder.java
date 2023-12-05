package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import businessLogic.PurchaseOrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GivePurchaseOrder {
	int customerID;
	String VIN;
	private JFrame frame;
    private JTextField orderIdTextField, customerIdTextField, dateTextField, vinTextField, commentsTextField, statusTextField;


	/**
	 * Launch the application.
		/**
	 * Create the application.
	 */
	public GivePurchaseOrder(int customerID, String VIN) {
		 this.customerID=customerID;
		this.VIN=VIN;
		 initialize();
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
        txtpnManageCarsInventory.setText("                              Enter Purchase Order Details ");
        frame.getContentPane().add(txtpnManageCarsInventory);
        
        // Add a JLabel for the logo
	    ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");
	    frame.getContentPane().setLayout(null);
	    JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
	    logoLabel.setBounds(27, 141, 425, 207);
	    frame.getContentPane().add(logoLabel);

    JLabel lblOrderId = new JLabel("Order ID:");
    lblOrderId.setBounds(517, 150, 70, 14);
    lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblOrderId.setForeground(SystemColor.text);
    frame.getContentPane().add(lblOrderId);

    JLabel lblCustomerId = new JLabel("Customer ID:");
    lblCustomerId.setBounds(490, 184, 90, 14);
    lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblCustomerId.setForeground(SystemColor.text);
    frame.getContentPane().add(lblCustomerId);

    JLabel lblVin = new JLabel("VIN:");
    lblVin.setBounds(517, 270, 70, 14);
    lblVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblVin.setForeground(SystemColor.text);
    frame.getContentPane().add(lblVin);

    JLabel lblComments = new JLabel("Comments:");
    lblComments.setBounds(490, 307, 90, 14);
    lblComments.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblComments.setForeground(SystemColor.text);
    frame.getContentPane().add(lblComments);

    JLabel lblStatus = new JLabel("Status:");
    lblStatus.setBounds(517, 350, 70, 14);
    lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblStatus.setForeground(SystemColor.text);
    frame.getContentPane().add(lblStatus);

    PurchaseOrderController order = new PurchaseOrderController();
	int orderID = order.fetchOrderID();
	String orderint = String.valueOf(orderID);
    
    orderIdTextField = new JTextField(orderint);
    orderIdTextField.setBounds(597, 144, 120, 20);
    frame.getContentPane().add(orderIdTextField);
    orderIdTextField.setColumns(10);
    
    String customint = String.valueOf(customerID);
    

    customerIdTextField = new JTextField(customint);
    customerIdTextField.setBounds(597, 184, 120, 20);
    frame.getContentPane().add(customerIdTextField);
    customerIdTextField.setColumns(10);

    vinTextField = new JTextField(VIN);
    vinTextField.setBounds(597, 268, 120, 20);
    frame.getContentPane().add(vinTextField);
    vinTextField.setColumns(10);

    commentsTextField = new JTextField();
    commentsTextField.setBounds(597, 307, 166, 20);
    frame.getContentPane().add(commentsTextField);
    commentsTextField.setColumns(10);

    statusTextField = new JTextField("Pending");
    statusTextField.setBounds(597, 348, 120, 20);
    frame.getContentPane().add(statusTextField);
    statusTextField.setColumns(10);

    JButton btnSave = new JButton("Confirm Order");
    btnSave.setBounds(425, 456, 133, 31);
    btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
    frame.getContentPane().add(btnSave);
    
    btnSave.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
        			
        	String comments= commentsTextField.getText();
        	String status = statusTextField.getText();
        	PurchaseOrderController order = new PurchaseOrderController();
        	
            order.createPurchaseOrder(orderID, customerID, VIN, comments);
            JOptionPane.showMessageDialog(null, "Order Placed Successfully");
        }
    });
    frame.getContentPane().add(btnSave);

}

	
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}




    private void savePurchaseOrder() {
        // Move database configuration to constants or configuration file
        String url = "jdbc:mysql://your_database_host:your_database_port/your_database";
        String user = "your_database_username";
        String password = "your_database_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO PurchaseOrder (OrderID, CustomerID, Date, VIN, Comments, Status) " +
                    "VALUES (?, ?, CURRENT_DATE(), ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(orderIdTextField.getText()));
                preparedStatement.setInt(2, Integer.parseInt(customerIdTextField.getText()));
                preparedStatement.setString(3, vinTextField.getText());
                preparedStatement.setString(4, commentsTextField.getText());
                preparedStatement.setString(5, statusTextField.getText());

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(frame, "Purchase Order saved successfully");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to save Purchase Order");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error connecting to the database or saving Purchase Order");
        }
    }
    private void fetchPurchaseOrder(int orderID) {
        String url = "jdbc:mysql://your_database_host:your_database_port/your_database";
        String user = "your_database_username";
        String password = "your_database_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM PurchaseOrder WHERE OrderID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, orderID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        customerIdTextField.setText(String.valueOf(resultSet.getInt("CustomerID")));
                        dateTextField.setText(resultSet.getDate("Date").toString());
                        vinTextField.setText(resultSet.getString("VIN"));
                        commentsTextField.setText(resultSet.getString("Comments"));
                        statusTextField.setText(resultSet.getString("Status"));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Purchase Order not found");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error connecting to the database");
        }
    }

    private void clearFields() {
        orderIdTextField.setText("");
        customerIdTextField.setText("");
        dateTextField.setText("");
        vinTextField.setText("");
        commentsTextField.setText("");
        statusTextField.setText("");
    }
}
