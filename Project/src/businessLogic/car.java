package businessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class car {
    private String vin;
    private String make;
    private String model;
    private double price;
    private int year;
    private Date lastServiceDate;
    private String ownerId;
    private String color;
    private double mileage;
    private List<ServiceSchedule> serviceSchedules;//aggregation with car
    //represented by SHCEDULE OF SERVICE in the SD
    private List<TestDrive> testDrives; //aggregation with car


    // Constructors
    public car() {
        // Default constructor
    }

    public car(String vin, String make, String model, double price, int year, Date lastServiceDate, String ownerId, String color, double mileage) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
        this.lastServiceDate = lastServiceDate;
        this.ownerId = ownerId;
        this.color = color;
        this.mileage = mileage;
        this.serviceSchedules= new ArrayList<>();
        this.testDrives = new ArrayList<>();

    }

    // Getters and Setters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public List<ServiceSchedule> getServiceSchedules() {
        return new ArrayList<>(serviceSchedules); // Return a copy to protect the original list
    }

    public List<TestDrive> getDriveSchedules() {
        return new ArrayList<>(testDrives); // Return a copy to protect the original list
    }
    
    public void updateServiceSchedule(ServiceSchedule serviceSchedule) {
        this.serviceSchedules.add(serviceSchedule);
    }
    
    public void updateDriveSchedule(TestDrive testDrive) {
        testDrives.add(testDrive);
    }

    //public PurchaseOrder getPurchaseOrderByVIN(String vin) {
      //  for (PurchaseOrder order : purchaseOrders) {
        //    if (order.getVin().equals(vin)) {
          //      return order;
            //}
        //}
        //return null; // If no matching PurchaseOrder found
    //}
}
