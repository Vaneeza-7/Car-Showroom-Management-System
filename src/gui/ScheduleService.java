package gui;

import javax.swing.*;

import businessLogic.ServiceController;
import businessLogic.TestDriveController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ScheduleService {
String VIN;
	private JFrame frame;
	private JTextField vinTextField;
	private JTextField serviceTypeTextField;
	private JTextField dateTextField;
	private JTextField statusTextField;
	private JTextField commentsTextField;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ScheduleService(String VIN) {
		this.VIN=VIN;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 913, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 frame.getContentPane().setLayout(null);

	        ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");
	        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
	        logoLabel.setBounds(29, 148, 423, 239);
	        frame.getContentPane().add(logoLabel);
	        JLabel lblNewLabel = new JLabel("Schedule Car for Service");
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
	        lblNewLabel.setBounds(160, 11, 370, 49);
	        frame.getContentPane().add(lblNewLabel);

	        JLabel lblVin = new JLabel("VIN:");
	        lblVin.setForeground(SystemColor.text);
	        lblVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblVin.setBounds(519, 164, 70, 14);
	        frame.getContentPane().add(lblVin);

	        JLabel lblServiceType = new JLabel("Service Type:");
	        lblServiceType.setForeground(SystemColor.text);
	        lblServiceType.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblServiceType.setBounds(489, 198, 100, 19);
	        frame.getContentPane().add(lblServiceType);

	        JLabel lblDate = new JLabel("Date:");
	        lblDate.setForeground(SystemColor.text);
	        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblDate.setBounds(519, 250, 70, 14);
	        frame.getContentPane().add(lblDate);

	        JLabel lblStatus = new JLabel("Status:");
	        lblStatus.setForeground(SystemColor.text);
	        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblStatus.setBounds(519, 289, 70, 14);
	        frame.getContentPane().add(lblStatus);

	        JLabel lblComments = new JLabel("Comments:");
	        lblComments.setForeground(SystemColor.text);
	        lblComments.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblComments.setBounds(489, 332, 100, 14);
	        frame.getContentPane().add(lblComments);

	        JButton btnSave = new JButton("Save");
	        btnSave.setBackground(new Color(0, 102, 255));
	        btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnSave.setBounds(335, 474, 100, 31);
	        btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            	String serType = serviceTypeTextField.getText();
	            	Date schedDate = java.sql.Date.valueOf(dateTextField.getText());
	            	String status= statusTextField.getText();
	            	String comments = commentsTextField.getText();
	            	//saveServiceSchedule();
	            	
	            	 ServiceController stc=new ServiceController();
	                 stc.createService(VIN, serType, schedDate, status, comments);
	                 
	                 JOptionPane.showMessageDialog(frame, "Service Schedule saved successfully");
	                 clearFields();
	                
	            }
	        });
	        frame.getContentPane().add(btnSave);
	        
	        vinTextField = new JTextField(VIN);
	        vinTextField.setBounds(609, 164, 96, 19);
	        frame.getContentPane().add(vinTextField);
	        vinTextField.setColumns(10);
	        
	        serviceTypeTextField = new JTextField();
	        serviceTypeTextField.setColumns(10);
	        serviceTypeTextField.setBounds(609, 200, 96, 19);
	        frame.getContentPane().add(serviceTypeTextField);
	        
	        dateTextField = new JTextField();
	        dateTextField.setColumns(10);
	        dateTextField.setBounds(609, 245, 96, 19);
	        frame.getContentPane().add(dateTextField);
	        
	        statusTextField = new JTextField();
	        statusTextField.setColumns(10);
	        statusTextField.setBounds(609, 289, 96, 19);
	        frame.getContentPane().add(statusTextField);
	        
	        commentsTextField = new JTextField();
	        commentsTextField.setColumns(10);
	        commentsTextField.setBounds(609, 332, 96, 19);
	        frame.getContentPane().add(commentsTextField);
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setEditable(false);
	        textArea.setBackground(new Color(0, 204, 204));
	        textArea.setBounds(0, 0, 1027, 93);
	        frame.getContentPane().add(textArea);

		
	}

private void clearFields() {
    vinTextField.setText("");
    serviceTypeTextField.setText("");
    dateTextField.setText("");
    statusTextField.setText("");
    commentsTextField.setText("");
}

public JFrame getFrame() {
	// TODO Auto-generated method stub
	return frame;
}

}
