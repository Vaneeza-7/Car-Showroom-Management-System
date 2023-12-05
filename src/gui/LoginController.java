package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DB.dbHandler;

public class LoginController implements ActionListener {

    private Login loginFrame;

    public LoginController(Login loginFrame) {
        this.loginFrame = loginFrame;
    }

    public boolean authenticateUser(int id, String pwd, String role)
    {
    	dbHandler dbo=new dbHandler();
		return dbo.authenticateUser(id, pwd, role);
    	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        loginFrame.onLoginButtonClicked();
    }
}