package businessLogic;

public class CreditCard extends Payment {
	 private String creditCardNumber;
	 private int code;

	 public CreditCard(int transactionID, int customerID, int invoiceID, double amount, String creditCardNumber, int securityCode) {
	     super(transactionID, customerID, invoiceID, amount);
	     this.creditCardNumber = creditCardNumber;
	     this.code = securityCode;
	 }

	 
	 
	 public String getCreditCardNumber() {
		return creditCardNumber;
	}



	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int securityCode) {
		this.code = securityCode;
	}



	public void enterCreditCardDetails() {
	 
	 
	 }
	 
	 
}
