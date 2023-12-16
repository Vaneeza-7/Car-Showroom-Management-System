package businessLogic;

import java.util.Date;

public class Payment {
 private int transactionID;
 private int customerID;
 //private int invoiceID;
 private double amount;
 private String status;
 private Date paymentDate;
private String vin;

 public Payment(int transactionID, int customerID, String vin, double amount) {
     this.transactionID = transactionID;
     this.customerID = customerID;
     this.vin = vin;
     this.amount = amount;
     this.status = "Paid"; // Payment status initially set to Pending
     this.paymentDate = new Date(); // Payment date initially set to null
 }

public Payment() {
	// TODO Auto-generated constructor stub
	 this.transactionID = 0;
     this.customerID = 0;
     this.vin = null;
     this.amount = 0.0;
     this.status = "Paid"; // Payment status initially set to Pending
     this.paymentDate = new Date();
}

public int getTransactionID() {
	return transactionID;
}


public void setTransactionID(int transactionID) {
	this.transactionID = transactionID;
}


public int getCustomerID() {
	return customerID;
}


public void setCustomerID(int customerID) {
	this.customerID = customerID;
}




public String getVin() {
	return vin;
}

public void setVin(String vin) {
	this.vin = vin;
}

public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public Date getPaymentDate() {
	return paymentDate;
}


public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}


 public void makePayment() {
     this.status = "Paid";
     this.paymentDate = new Date();
 }
 
public void choosePaymentMode(String mode)
 {
	//switch (mode.toLowerCase()) {
   // case "cash":
    //    Cash cash = new Cash(this.transactionID, this.customerID, this.invoiceID, this.amount, null, null, );
  //      cash.enterCashDetails(accountNumber, pin, bank);
        
   // case "credit card":
     //   return new CreditCard();
    //default:
      //  return new Cash();
      //}
 }
 
 
}

