package gui;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;

import businessLogic.TestDriveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


public class ScheduleTestDrive {
int customerID;
	String VIN;
	private JFrame frame;
	private JTextField vinTextField, customerIDTextField, dateTextField, timeTextField, statusTextField, commentsTextField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public ScheduleTestDrive(int customerID, String VIN) {
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
		frame.setBounds(100, 100, 820, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

        // Add an image to the frame
        ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");
        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
        logoLabel.setBounds(29, 152, 430, 182);
        frame.getContentPane().add(logoLabel);

        JLabel lblNewLabel = new JLabel("Schedule Test Drive");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(151, 11, 424, 53);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblVin = new JLabel("VIN:");
        lblVin.setForeground(SystemColor.text);
        lblVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblVin.setBounds(520, 152, 70, 14);
        frame.getContentPane().add(lblVin);

        JLabel lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setForeground(SystemColor.text);
        lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCustomerID.setBounds(490, 198, 100, 19);
        frame.getContentPane().add(lblCustomerID);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setForeground(SystemColor.text);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDate.setBounds(520, 250, 70, 14);
        frame.getContentPane().add(lblDate);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setForeground(SystemColor.text);
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTime.setBounds(520, 300, 70, 14);
        frame.getContentPane().add(lblTime);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setForeground(SystemColor.text);
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStatus.setBounds(520, 350, 70, 14);
        frame.getContentPane().add(lblStatus);

        JLabel lblComments = new JLabel("Comments:");
        lblComments.setForeground(SystemColor.text);
        lblComments.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblComments.setBounds(457, 402, 100, 14);
        frame.getContentPane().add(lblComments);

        vinTextField = new JTextField(VIN);
        vinTextField.setBounds(600, 152, 120, 20);
        frame.getContentPane().add(vinTextField);
        vinTextField.setColumns(10);

        String custm=String.valueOf(customerID);
        customerIDTextField = new JTextField(custm);
        customerIDTextField.setBounds(600, 200, 120, 20);
        frame.getContentPane().add(customerIDTextField);
        customerIDTextField.setColumns(10);

        dateTextField = new JTextField("yyyy-mm-dd");
        dateTextField.setBounds(600, 250, 120, 20);
        frame.getContentPane().add(dateTextField);
        dateTextField.setColumns(10);

        timeTextField = new JTextField("HH:mm:ss");
        timeTextField.setBounds(600, 300, 120, 20);
        frame.getContentPane().add(timeTextField);
        timeTextField.setColumns(10);

        statusTextField = new JTextField();
        statusTextField.setBounds(600, 350, 120, 20);
        frame.getContentPane().add(statusTextField);
        statusTextField.setColumns(10);

        commentsTextField = new JTextField();
        commentsTextField.setBounds(567, 402, 166, 20);
        frame.getContentPane().add(commentsTextField);
        commentsTextField.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setBackground(new Color(100, 149, 237));
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSave.setBounds(325, 456, 113, 31);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Date schedDate = java.sql.Date.valueOf(dateTextField.getText());
            	Time time = java.sql.Time.valueOf(timeTextField.getText());
            	
            	String stat = statusTextField.getText();
            	String com = commentsTextField.getText();
            	
            	
                TestDriveController stc=new TestDriveController();
                stc.createTestDrive(VIN, customerID, schedDate, timeTextField.getText(), stat, com);
                
                JOptionPane.showMessageDialog(frame, "Test Drive saved successfully");
                clearFields();
                
            }
        });
        frame.getContentPane().add(btnSave);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 204, 204));
        textArea.setBounds(0, 0, 1074, 82);
        frame.getContentPane().add(textArea);

		
}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
	

private void clearFields() {
    vinTextField.setText("");
    customerIDTextField.setText("");
    dateTextField.setText("");
    timeTextField.setText("");
    statusTextField.setText("");
    commentsTextField.setText("");
}
}
