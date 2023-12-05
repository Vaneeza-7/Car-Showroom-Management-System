package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class GivePurchaseOrder {

	private JFrame frame;

	/**
	 * Launch the application.
		/**
	 * Create the application.
	 */
	public GivePurchaseOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
       
	}

	
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
