package businessLogic;

import DB.dbHandler;
import java.util.Date;

public class PurchaseOrder {
    private int orderID;
    private int customerID;
    private Date date;
    private String VIN;
    private String comments;
    private String status;

    // Constructor
    public PurchaseOrder(int orderID, int customerID, Date date, String VIN, String comments, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.date = date;
        this.VIN = VIN;
        this.comments = comments;
        this.status = status;
    }
    
    public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getVIN() {
		return VIN;
	}


	public void setVIN(String vIN) {
		VIN = vIN;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
    public PurchaseOrder givePurchaseOrder(int customerID, String VIN, String comments) {
       
    	//int orderID = getLastUsedOrderIDFromDatabase();
    	Date currentDate = new Date();
        String defaultStatus = "Pending";
        return new PurchaseOrder(orderID, customerID, currentDate, VIN, comments, defaultStatus);
    }
    
    

    
}
