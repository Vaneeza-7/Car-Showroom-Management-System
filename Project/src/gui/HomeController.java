package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DB.dbHandler;

public class HomeController implements ActionListener {
	
	private Home homeFrame;

    public HomeController(Home homeFrame) {
        this.homeFrame = homeFrame;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        homeFrame.onManageButtonClicked();
    }
}
