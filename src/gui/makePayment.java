package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogic.PaymentController;

public class makePayment {

	int customerID;
	String VIN;
	private JFrame frame;
    private JTextField cardNumberField;
    private JTextField cvvField;
    private JTextField vinField;
    private JTextField AmountField;
    private JTextField pinField;
    private JTextField BankField;
    private JTextField accountNumberField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public makePayment(int customerID, String VIN) {
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
		frame.setBounds(100, 100, 1318, 788);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  frame.getContentPane().setLayout(null);

	        JButton confirmpayment = new JButton("Confirm Payment");
	        confirmpayment.setBounds(895, 532, 133, 38);
	        frame.getContentPane().add(confirmpayment);


	        JLabel paymentmthod = new JLabel("Choose Payment Method");
	        paymentmthod.setForeground(SystemColor.textHighlightText);
	        paymentmthod.setBounds(518, 200, 133, 20);
	        frame.getContentPane().add(paymentmthod);

	        JComboBox<String> comboBox = new JComboBox<>();
	        comboBox.addItem("Credit Card");
	        comboBox.addItem("Cash");
	        comboBox.setBounds(682, 200, 179, 21);
	        frame.getContentPane().add(comboBox);

	        JLabel lblNewLabel = new JLabel("Card number");
	        lblNewLabel.setForeground(SystemColor.textHighlightText);
	        lblNewLabel.setBounds(518, 255, 97, 20);
	        frame.getContentPane().add(lblNewLabel);

	        cardNumberField = new JTextField();
	        cardNumberField.setBounds(682, 256, 86, 19);
	        frame.getContentPane().add(cardNumberField);
	        cardNumberField.setColumns(10);

	        JLabel lblCvv = new JLabel("CVV");
	        lblCvv.setForeground(SystemColor.textHighlightText);
	        lblCvv.setBounds(518, 292, 97, 20);
	        frame.getContentPane().add(lblCvv);

	        cvvField = new JTextField();
	        cvvField.setBounds(682, 292, 86, 19);
	        frame.getContentPane().add(cvvField);
	        cvvField.setColumns(10);

	        Panel panel = new Panel();
	        panel.setBackground(SystemColor.control);
	        panel.setBounds(30, 35, 421, 411);
	        frame.getContentPane().add(panel);
	        ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");
	        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
	        logoLabel.setBackground(new Color(0, 0, 0));

	        logoLabel.setBounds(557, 0, 512, 334);
	        panel.add(logoLabel);
	        panel.add(logoLabel);
	        vinField = new JTextField(VIN);
	        vinField.setBounds(1137, 200, 133, 20);
	        frame.getContentPane().add(vinField);
	        vinField.setColumns(10);
	        
	        AmountField = new JTextField();
	        AmountField.setBounds(1137, 255, 133, 20);
	        frame.getContentPane().add(AmountField);
	        AmountField.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("VIN");
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(1038, 203, 46, 14);
	        frame.getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Amount");
	        lblNewLabel_2.setForeground(new Color(255, 255, 255));
	        lblNewLabel_2.setBounds(1038, 252, 46, 20);
	        frame.getContentPane().add(lblNewLabel_2);
	        
	        pinField = new JTextField();
	        pinField.setBounds(682, 403, 86, 20);
	        frame.getContentPane().add(pinField);
	        pinField.setColumns(10);
	        
	        BankField = new JTextField();
	        BankField.setBounds(682, 434, 86, 20);
	        frame.getContentPane().add(BankField);
	        BankField.setColumns(10);
	        
	        accountNumberField = new JTextField();
	        accountNumberField.setBounds(682, 371, 86, 20);
	        frame.getContentPane().add(accountNumberField);
	        accountNumberField.setColumns(10);
	        
	        JLabel lblNewLabel_3 = new JLabel("Account Number");
	        lblNewLabel_3.setForeground(new Color(255, 255, 255));
	        lblNewLabel_3.setBounds(518, 371, 97, 14);
	        frame.getContentPane().add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("PIN");
	        lblNewLabel_4.setForeground(new Color(255, 255, 255));
	        lblNewLabel_4.setBounds(518, 406, 46, 14);
	        frame.getContentPane().add(lblNewLabel_4);
	        
	        JLabel lblNewLabel_5 = new JLabel("Bank");
	        lblNewLabel_5.setForeground(new Color(255, 255, 255));
	        lblNewLabel_5.setBounds(518, 437, 46, 14);
	        frame.getContentPane().add(lblNewLabel_5);

	        // Add ActionListener to comboBox for dynamic UI updates
	        comboBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateUIBasedOnPaymentMethod((String) comboBox.getSelectedItem());
	            }
	        });

	        // Add ActionListener to Confirm Payment button to navigate to InvoiceForm
	        confirmpayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //navigateToInvoiceForm();
	            	String paymentMethod = (String) comboBox.getSelectedItem();
	            	if ("Cash".equals(paymentMethod)) {
	    	            
                        double amt = Double.parseDouble(AmountField.getText());
                        
                        double amount = Double.parseDouble(AmountField.getText());
	            		String accNum = accountNumberField.getText();
	            		String bank = BankField.getText();
	                     int pin = Integer.parseInt(pinField.getText()); 
	                     
	                     PaymentController control= new PaymentController();
	                     control.addCash(customerID, VIN, amount, accNum, pin, bank);
                         JOptionPane.showMessageDialog(null, "Payment Done Successfully");
	                    
	    	        }
	            	else
	            	{
	            		String cardNum = cardNumberField.getText();
	                     int cvv = Integer.parseInt(cvvField.getText()); 
	                     double amount = Double.parseDouble(AmountField.getText());
	                     
	                     PaymentController control= new PaymentController();
	                     control.addCredit(customerID, VIN, amount, cardNum, cvv);
                         JOptionPane.showMessageDialog(null, "Payment Done Successfully");
	                     
	    	            
	            	}
	            	
	            }
	        });
	}
	    

	    // Method to update UI components based on the selected payment method
	    private void updateUIBasedOnPaymentMethod(String paymentMethod) {
	        // Hide or show components based on the selected payment method
	        if ("Cash".equals(paymentMethod)) {
	            cardNumberField.setVisible(false);
	            cvvField.setVisible(false);
	            pinField.setVisible(true);
	            accountNumberField.setVisible(true);
	            BankField.setVisible(true);
	        } else {
	            pinField.setVisible(false);
	            accountNumberField.setVisible(false);
	            BankField.setVisible(false);
	            cardNumberField.setVisible(true);
	            cvvField.setVisible(true);
	            
	        }
	    }

	    // Method to navigate to InvoiceForm
	    private void navigateToInvoiceForm() {
	        frame.dispose(); // Close the current frame
	        //CreateInvoice invoiceForm = new CreateInvoice();
	       // invoiceForm.showWindow();
	    }

		public JFrame getFrame() {
			// TODO Auto-generated method stub
			return frame;
		}
}



//
