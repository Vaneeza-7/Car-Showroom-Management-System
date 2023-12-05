package gui;

import java.awt.EventQueue;

import javax.swing.*;

import businessLogic.InvoiceController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateInvoice {

	private JFrame frame;
    private JTextField customerTextField;
    private JTextArea itemDetailsTextArea;

	/**
	 * Create the application.
	 */
	public CreateInvoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 920, 600);
        frame.getContentPane().setBackground(SystemColor.desktop);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Add a JLabel for the logo
        ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");
        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
        logoLabel.setBounds(15, 162, 434, 224);
        frame.getContentPane().add(logoLabel);

        // Add your components for displaying invoice details
        // Example placeholders, replace with your actual components and logic
        JLabel customerLabel = new JLabel("Customer Name:");
        customerLabel.setForeground(SystemColor.window);
        customerLabel.setBounds(459, 119, 150, 20);
        frame.getContentPane().add(customerLabel);

        customerTextField = new JTextField();
        customerTextField.setBounds(580, 120, 200, 20);
        frame.getContentPane().add(customerTextField);

        JLabel itemLabel = new JLabel("Car Details:");
        itemLabel.setForeground(SystemColor.window);
        itemLabel.setBounds(459, 162, 150, 20);
        frame.getContentPane().add(itemLabel);

        itemDetailsTextArea = new JTextArea();
        itemDetailsTextArea.setBounds(580, 183, 248, 200);
        frame.getContentPane().add(itemDetailsTextArea);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(783, 119, 80, 20);
        frame.getContentPane().add(searchButton);

        JButton printButton = new JButton("Create Invoice");
        printButton.setBounds(508, 454, 120, 30);
        frame.getContentPane().add(printButton);
        
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerTextField.getText().trim();
                if (!customerName.isEmpty()) {
                   
                	InvoiceController inv= new InvoiceController();
                	
                	
                    //inv.;   
                	
                
                } else {
                    itemDetailsTextArea.setText("Please enter a customer name.");
                }
            }
        });

        

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(814, 454, 80, 30);
        frame.getContentPane().add(closeButton);
        
        JTextArea txtrGenerateInvoice = new JTextArea();
        txtrGenerateInvoice.setEditable(false);
        txtrGenerateInvoice.setFont(new Font("Tahoma", Font.BOLD, 21));
        txtrGenerateInvoice.setText("                                  Generate Invoice");
        txtrGenerateInvoice.setBackground(new Color(0, 204, 204));
        txtrGenerateInvoice.setBounds(15, 11, 903, 55);
        frame.getContentPane().add(txtrGenerateInvoice);

        // Add ActionListener to closeButton to close the invoice window
        closeButton.addActionListener(e -> frame.dispose());

        // Add ActionListener to searchButton to fetch and display customer details
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerTextField.getText().trim();
                if (!customerName.isEmpty()) {
                   
                	InvoiceController inv= new InvoiceController();
                	String carDetails = inv.fetchAndDisplayCustomerDetails(customerName);
                	itemDetailsTextArea.setText(carDetails);
                
                } else {
                    itemDetailsTextArea.setText("Please enter a customer name.");
                }
            }
        });
    }

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
 //