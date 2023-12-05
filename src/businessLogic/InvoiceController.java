package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DB.dbHandler;

public class InvoiceController {
	

	dbHandler dbo;
	car newcar;
	Invoice voice;
	
	public InvoiceController() {
		dbo = new dbHandler();
		newcar = new car();

	}
	
	public void createInvoice(int orderId, int customerId, double tax, double price,
            double totalAmount, String termsAndConditions)
	{
		voice = new Invoice();
		int invoiceId = 1 + dbo.getLastUsedInvoiceIDFromDatabase();
		voice.setInvoiceId(invoiceId);
		Invoice newvoice = voice.generateInvoice(orderId, customerId, tax, price,totalAmount, termsAndConditions);
		dbo.storeInvoice(newvoice);
		
		
	}
	
	 public String fetchAndDisplayCustomerDetails(String customerName)
	 {
		 
		 return dbo.fetchAndDisplayCustomerDetails(customerName);
	 }


}
