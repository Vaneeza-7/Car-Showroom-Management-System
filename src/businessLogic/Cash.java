package businessLogic;

public class Cash extends Payment {
private String accountNumber;
private int pin;
private String bank;

// Constructor
public Cash(int transactionID, int customerID, int invoiceID, double amount, String accountNumber, int pin, String bank) {
   super(transactionID, customerID, invoiceID, amount);
   this.accountNumber = accountNumber;
   this.pin = pin;
   this.bank = bank;
}


public String getAccountNumber() {
	return accountNumber;
}


public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}


public int getPin() {
	return pin;
}


public void setPin(int pin) {
	this.pin = pin;
}


public String getBank() {
	return bank;
}


public void setBank(String bank) {
	this.bank = bank;
}


public void enterCashDetails() {

}


}
