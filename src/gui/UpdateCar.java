package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import businessLogic.CarInventoryController;

public class UpdateCar {
private String Vin;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UpdateCar(String Vin) {
		this.Vin=Vin;
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
		  frame.setSize(1078, 788);
          frame.getContentPane().setLayout(null);
         
          JTextPane txtpnManageCarsInventory = new JTextPane();
          txtpnManageCarsInventory.setEditable(false);
          txtpnManageCarsInventory.setBackground(new Color(51, 204, 204));
          txtpnManageCarsInventory.setFont(new Font("Tahoma", Font.BOLD, 30));
          txtpnManageCarsInventory.setText("                              Update Car Information");
          txtpnManageCarsInventory.setBounds(0, 0, 1366, 59);
          frame.getContentPane().add(txtpnManageCarsInventory);
          
          JLabel lblNewLabel= new JLabel();
  		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
  		lblNewLabel.setForeground(new Color(255, 255, 255));
  		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
  		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
  		lblNewLabel.setBounds(192, 0, 1151, 700);
  		frame.getContentPane().add(lblNewLabel);
  		
          
          textField = new JTextField(Vin);
          textField.setEditable(false);
          textField.setBounds(292, 158, 86, 20);
          frame.getContentPane().add(textField);
          textField.setColumns(10);
          
          textField_1 = new JTextField();
          textField_1.setBounds(292, 262, 86, 20);
          frame.getContentPane().add(textField_1);
          textField_1.setColumns(10);
          
          textField_2 = new JTextField();
          textField_2.setBounds(292, 376, 86, 20);
          frame.getContentPane().add(textField_2);
          textField_2.setColumns(10);
          
          textField_3 = new JTextField();
          textField_3.setBounds(292, 480, 86, 20);
          frame.getContentPane().add(textField_3);
          textField_3.setColumns(10);
          
          textField_4 = new JTextField();
          textField_4.setBounds(721, 158, 86, 20);
          frame.getContentPane().add(textField_4);
          textField_4.setColumns(10);
          
          textField_5 = new JTextField();
          textField_5.setBounds(721, 262, 86, 20);
          frame.getContentPane().add(textField_5);
          textField_5.setColumns(10);
          
          textField_6 = new JTextField();
          textField_6.setBounds(721, 376, 86, 20);
          frame.getContentPane().add(textField_6);
          textField_6.setColumns(10);
          
          textField_7 = new JTextField();
          textField_7.setBounds(721, 480, 86, 20);
          frame.getContentPane().add(textField_7);
          textField_7.setColumns(10);
          
          JLabel lblNewLabel1 = new JLabel("VIN");
          lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel1.setForeground(new Color(32, 178, 170));
          lblNewLabel1.setBounds(136, 155, 46, 20);
          frame.getContentPane().add(lblNewLabel1);
          
          JLabel lblNewLabel_1 = new JLabel("Make");
          lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_1.setForeground(new Color(32, 178, 170));
          lblNewLabel_1.setBounds(136, 257, 67, 22);
          frame.getContentPane().add(lblNewLabel_1);
          
          JLabel lblNewLabel_2 = new JLabel("Model");
          lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_2.setForeground(new Color(32, 178, 170));
          lblNewLabel_2.setBounds(136, 379, 67, 14);
          frame.getContentPane().add(lblNewLabel_2);
          
          JLabel lblNewLabel_3 = new JLabel("Year");
          lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_3.setForeground(new Color(32, 178, 170));
          lblNewLabel_3.setBounds(136, 483, 46, 14);
          frame.getContentPane().add(lblNewLabel_3);
          
          JLabel lblNewLabel_4 = new JLabel("Color");
          lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_4.setForeground(new Color(32, 178, 170));
          lblNewLabel_4.setBounds(551, 158, 75, 17);
          frame.getContentPane().add(lblNewLabel_4);
          
          JLabel lblNewLabel_5 = new JLabel("Mileage");
          lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_5.setForeground(new Color(32, 178, 170));
          lblNewLabel_5.setBounds(551, 262, 75, 17);
          frame.getContentPane().add(lblNewLabel_5);
          
          JLabel lblNewLabel_6 = new JLabel("Price");
          lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_6.setForeground(new Color(32, 178, 170));
          lblNewLabel_6.setBounds(551, 379, 46, 14);
          frame.getContentPane().add(lblNewLabel_6);
          
          JLabel lblNewLabel_7 = new JLabel("Status");
          lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
          lblNewLabel_7.setForeground(new Color(32, 178, 170));
          lblNewLabel_7.setBounds(551, 464, 75, 36);
          frame.getContentPane().add(lblNewLabel_7);
          
          JLabel lblNewLabel_8 = new JLabel("(cannot be updated)");
          lblNewLabel_8.setForeground(new Color(255, 0, 0));
          lblNewLabel_8.setBounds(284, 189, 119, 14);
          frame.getContentPane().add(lblNewLabel_8);
          
          JButton btnNewButton = new JButton("UPDATE");
          btnNewButton.setBackground(new Color(0, 128, 0));
          btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
          btnNewButton.setForeground(new Color(255, 255, 255));
          btnNewButton.setBounds(431, 632, 127, 36);
          
          btnNewButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  String make = textField_1.getText();
                  String model = textField_2.getText();
                  int year = Integer.parseInt(textField_3.getText());
                  String color = textField_4.getText();
                  double mileage = Double.parseDouble(textField_5.getText());
                  double price = Double.parseDouble(textField_6.getText());
                  String status = textField_7.getText();     
                  
                  CarInventoryController control = new CarInventoryController();
                  control.updateCar(Vin, make, model, year, color, mileage, price, status);
                  JOptionPane.showMessageDialog(null, "Car Updated Successfully");
                  
              }
          });
          
          frame.getContentPane().add(btnNewButton);
        

	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
