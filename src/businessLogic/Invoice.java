package businessLogic;

import DB.dbHandler;
import java.util.Date;

public class Invoice {
    private int invoiceId;
    private int orderId;
    private int customerId;
    private double tax;
    private double price;
    private Date date;
    private double totalAmount;
    private String termsAndConditions;

    public Invoice(int invoiceId, int orderId, int customerId, double tax, double price, Date date,
                   double totalAmount, String termsAndConditions) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.tax = tax;
        this.price = price;
        this.date = date;
        this.totalAmount = totalAmount;
        this.termsAndConditions = termsAndConditions;
    }

    public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getTermsAndConditions() {
		return termsAndConditions;
	}


	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	
	//removed static
	public Invoice generateInvoice(int orderId, int customerId, double tax, double price,
                                          double totalAmount, String termsAndConditions) {
       
		//int invoiceId = getLastUsedInvoiceIDFromDatabase();
        Date currentDate = new Date();

        return new Invoice(invoiceId, orderId, customerId, tax, price, currentDate, totalAmount, termsAndConditions);
    }
	
	
}
