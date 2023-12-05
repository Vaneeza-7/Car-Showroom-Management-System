package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DB.dbHandler;

public class ManagerHomeController implements ActionListener {
	
	private ManagerHome homeFrame;

    public ManagerHomeController(ManagerHome homeFrame) {
        this.homeFrame = homeFrame;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        homeFrame.onManageInvoicesButtonClicked();
    }
}
