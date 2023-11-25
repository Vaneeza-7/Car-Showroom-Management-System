package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import DB.dbHandler;

/*public class signupController {

	public signupController() {
		// TODO Auto-generated constructor stub
		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                
            }
        });

	}

}
*/


public class signupController implements ActionListener {

    private signup signupFrame;

    public signupController(signup signupFrame) {
        this.signupFrame = signupFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        signupFrame.onSignupButtonClicked();
    }
}




