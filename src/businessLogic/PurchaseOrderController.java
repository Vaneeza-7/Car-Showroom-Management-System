package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DB.dbHandler;

public class PurchaseOrderController {
	
	dbHandler dbo;
	PurchaseOrder order;
	
	public PurchaseOrderController () {
		dbo = new dbHandler();
	    order = new PurchaseOrder();
	}

	public void createPurchaseOrder(int orderID, int customerID, String VIN, String comments) {
		// TODO Auto-generated method stub
		//order.setOrderID(orderID);
		
		order= order.givePurchaseOrder(orderID, customerID, VIN, comments);
		dbo.createPurchaseOrder(order);
		
		
		
	}
	

   public int fetchOrderID()
   {
	 return dbo.getLastUsedOrderIDFromDatabase()+1;
	   
   }
	
		
	}
	


