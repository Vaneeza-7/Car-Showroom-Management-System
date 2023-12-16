package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DB.dbHandler;

public class PaymentController {
	
	dbHandler dbo;
    Payment pay;	
	
	public PaymentController() {
		dbo = new dbHandler();
		pay = new Payment();
	}

	public void addCash(int customerID, String vin, double amount, String accNum, int pin, String bank)
	{
		int transID = dbo.getNextTransID();
		Cash cash = new Cash(transID, customerID, vin, amount, accNum, pin, bank);
		dbo.storeCash(cash);
	}
	
	public void addCredit(int customerID, String vin, double amount, String cardnum, int cvv)
	{
		int transID = dbo.getNextTransID();
		CreditCard card = new CreditCard(transID, customerID, vin, amount, cardnum, cvv);
		dbo.storeCard(card);
		
	}


}
