package gui;

import javax.swing.*;
import DB.dbHandler;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class signup {

	//favouring composition over inheritance, not tightly coupled
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JTextArea txtrWriteHere;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//signup window = new signup();
					//window.frame.setVisible(true);
					//dbHandler d = new dbHandler();
					
			//	} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the application.
	 */
	public signup() {
		initialize();
	}

	//convert to numeric text field
	private static JTextField createNumericFormattedTextField() {
		JTextField textField = new JTextField(10);
        PlainDocument doc = (PlainDocument) textField.getDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                currentText += text;

                if (currentText.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Beep for invalid input
                }
            }
        });

        textField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                return textField.getText().matches("[0-9]*");
            }
        });

        return textField;
    }
	
	 public void onSignupButtonClicked() {
		String pwd = null;
     	int usID = Integer.parseInt(textField_2.getText());
     	String name=textField.getText();
     	String emID=textField_1.getText();
     	String info=txtrWriteHere.getText();
     	if (passwordField != null) {
     	    pwd = new String(passwordField.getPassword());
     	}
     	if (passwordField_1 != null && passwordField_1==passwordField) {
     	    String pwd1 = new String(passwordField_1.getPassword());
     	}
     	
     	if (chckbxNewCheckBox.isSelected()) 
     	{
             System.out.println("Checkbox is checked. Proceeding...");
             
             
         } else {
             // Throw a warning or exception
             JOptionPane.showMessageDialog(frame, "Checkbox is unchecked. Please check it.",
                     "Warning", JOptionPane.WARNING_MESSAGE);

             // Alternatively, you can throw an exception
             // throw new RuntimeException("Checkbox is unchecked. Please check it.");
         }
     	
         System.out.println("SIGN UP button clicked");
         dbHandler dd = new dbHandler();
         dd.addUser(usID, name, emID, pwd, info);
         
	        // Open the Home frame
	        EventQueue.invokeLater(() -> {
	        	 // Dispose the current Signup frame
		       // dispose();
	           // carInventory carInventoryFrame = new carInventory();
	            //carInventoryFrame.setVisible(true);
	        	
	        	//this.frame.setVisible(false);
	        	frame.dispose();
	            Home window = new Home(usID);
				window.getFrame().setVisible(true);
	        });
	    }
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 835, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel= new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
		lblNewLabel.setBounds(192, 0, 1151, 700);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" SIGN UP TO GET YOUR DREAM CAR");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1.setBounds(274, 32, 435, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBounds(56, 508, 163, 31);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 175, 63, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		lblNewLabel_2.setLabelFor(textField);
		textField.setBounds(56, 203, 163, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Screenshot 2023-05-13 051758.png"));
		lblNewLabel_3.setBounds(10, 203, 46, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email ID");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 245, 86, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setLabelFor(passwordField);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 475, 100, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		lblNewLabel_4.setLabelFor(textField_1);
		textField_1.setBounds(56, 276, 163, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\email logo.jpg"));
		lblNewLabel_6.setBounds(10, 276, 46, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Screenshot 2023-05-13 052224.png"));
		lblNewLabel_7.setBounds(10, 508, 46, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("User ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(10, 100, 75, 22);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_2 = new JTextField(); //make user id a numeric field 
		textField_2= createNumericFormattedTextField();
		lblNewLabel_8.setLabelFor(textField_2);
		textField_2.setBounds(56, 131, 163, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\idicon.jpg"));
		lblNewLabel_9.setBounds(10, 131, 46, 31);
		frame.getContentPane().add(lblNewLabel_9);
		
		txtrWriteHere = new JTextArea();
		txtrWriteHere.setText("write address here...");
		txtrWriteHere.setBounds(10, 363, 209, 101);
		frame.getContentPane().add(txtrWriteHere);
		
		JLabel lblNewLabel_10 = new JLabel("Contact Information");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 330, 186, 22);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Confirm Password");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_11.setBounds(10, 562, 198, 20);
		frame.getContentPane().add(lblNewLabel_11);
		
		passwordField_1 = new JPasswordField();
		lblNewLabel_11.setLabelFor(passwordField_1);
		passwordField_1.setBounds(56, 593, 163, 31);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Screenshot 2023-05-13 052224.png"));
		lblNewLabel_12.setBounds(10, 593, 46, 31);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Terms and Conditions");
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_13.setBounds(340, 96, 198, 31);
		frame.getContentPane().add(lblNewLabel_13);
		
		JTextArea txtrtermsAndConditions = new JTextArea();
		txtrtermsAndConditions.setFont(new Font("Monospaced", Font.ITALIC, 13));
		txtrtermsAndConditions.setText("**Terms and Conditions for Car Showroom Registration:**\r\n\r\n1. Eligibility:\r\n   - To register with our car showroom, you must be at least \r\n18 years old and possess a valid driver's license.\r\n\r\n2. Accurate Information:\r\n   - You agree to provide accurate, current, and complete information\r\n during the registration process. Any false or misleading information\r\n may result in the termination of your registration.\r\n\r\n3. Account Security:\r\n   - You are responsible for maintaining the confidentiality of\r\n your account information, including your username and password. \r\nAny activities conducted under your account are your responsibility.\r\n\r\n4. Authorized Use:\r\n   - Your registration is for personal use only. You agree not to \r\nauthorize others to use your account, and you may not assign or\r\n otherwise transfer your account to any other person or entity.\r\n");
		txtrtermsAndConditions.setBounds(340, 131, 435, 369);
		frame.getContentPane().add(txtrtermsAndConditions);
		
		chckbxNewCheckBox = new JCheckBox("I have read, understood and agree to these terms and conditions.");
		chckbxNewCheckBox.setBounds(340, 505, 435, 37);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(495, 573, 94, 31);
		frame.getContentPane().add(btnNewButton);
		
		//invoke action listener
	     btnNewButton.addActionListener(new signupController(this));
	     
				
	}
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
