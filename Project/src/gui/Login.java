package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.k33ptoo.components.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.DocumentFilter.FilterBypass;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JComboBox<String> comboBox;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	public void onLoginButtonClicked()
	{
		 String selectedValue = (String) getCombobox().getSelectedItem();
		 int userID = Integer.parseInt(textField.getText());
		 String  pwd=null;
		 if (passwordField != null) {
	     	 pwd = new String(passwordField.getPassword());
	     	}
		 
		 LoginController controller=new LoginController(this);
		 if(controller.authenticateUser(userID, pwd, selectedValue))
		 {
			 if(selectedValue=="Staff") {
			 EventQueue.invokeLater(() -> {
	        	 // Dispose the current Signup frame
	        	frame.dispose();
	            Home window = new Home(userID);
				window.getFrame().setVisible(true);
	        });
			 }
			 
			 if(selectedValue=="Customer") {
				 EventQueue.invokeLater(() -> {
		        	 // Dispose the current Signup frame
		        	frame.dispose();
		            CustomerHome window = new CustomerHome(userID);
					window.getFrame().setVisible(true);
		        });
				 }
			 
			 if(selectedValue=="Manager") {
				 EventQueue.invokeLater(() -> {
		        	 // Dispose the current Signup frame
		        	frame.dispose();
		            ManagerHome window = new ManagerHome(userID);
					window.getFrame().setVisible(true);
		        });
				 }
			 
			 
			 
		 }
		 else
		 {
			 EventQueue.invokeLater(() -> {
	        	 // Dispose the current Signup frame
	        	frame.dispose();
	            signup window = new signup();
				window.getFrame().setVisible(true);
	        });
			 
		 }
		 
		 
	}
	
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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1105, 884);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		gradientPanel.kEndColor = new Color(0, 204, 204);
		gradientPanel.setkEndColor(new Color(0, 204, 204));
		gradientPanel.setkStartColor(new Color(0, 0, 0));
		frame.getContentPane().add(gradientPanel, BorderLayout.CENTER);
		gradientPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(513, 11, 300, 299);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\carRound.png"));
		gradientPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField= createNumericFormattedTextField();		
		textField.setBounds(539, 362, 274, 18);
		gradientPanel.add(textField);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textField.setOpaque(false);

		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(541, 321, 99, 41);
		gradientPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(541, 404, 101, 28);
		gradientPanel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(539, 434, 274, 28);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setOpaque(false);

		gradientPanel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Select Role");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(539, 494, 113, 18);
		gradientPanel.add(lblNewLabel_3);
		
		String[] items = {"Customer", "Manager", "Staff"};

        // Create a JComboBox with the sample data
        comboBox = new JComboBox<>(items);
        comboBox.setSize(272, 27);
        comboBox.setLocation(541, 530);

        comboBox.setEditable(false); 
        comboBox.setFocusable(false); 
        comboBox.setBackground(new Color(255, 255, 255)); 

        // Add the JComboBox to the content pane
        gradientPanel.add(comboBox);
		
		KButton btnSignIn = new KButton();
		btnSignIn.setkBorderRadius(30);
		btnSignIn.setkEndColor(new Color(0, 0, 0));
		btnSignIn.setkHoverEndColor(new Color(51, 102, 204));
		btnSignIn.setkHoverStartColor(new Color(0, 204, 204));
		btnSignIn.kHoverForeGround = new Color(0, 0, 0);
		btnSignIn.setkHoverForeGround(new Color(0, 0, 0));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignIn.setText("SIGN IN");
		btnSignIn.setBounds(579, 613, 185, 45);
		gradientPanel.add(btnSignIn);
		
		 btnSignIn.addActionListener(new LoginController(this));
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	public JComboBox<String> getCombobox() {
		return comboBox;
	}

	public void setCombobox(JComboBox<String> combobox) {
		this.comboBox = combobox;
	}
}
