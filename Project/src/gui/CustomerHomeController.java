package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerHomeController implements ActionListener {

	private CustomerHome frame;
	public CustomerHomeController (CustomerHome ch)
	{
		this.frame=ch;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        //frame.onViewCarsButtonClicked();
	}

}
