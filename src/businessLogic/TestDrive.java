package businessLogic;

import java.util.Date;

public class TestDrive {
    private String VIN;
    private int customerID;
    private Date date;
    private String time;
    private String status;
    private String comments;

    // Constructor
    public TestDrive(String VIN, int customerID, Date date, String time, String status, String comments) {
        this.VIN = VIN;
        this.customerID = customerID;
        this.date = date;
        this.time = time;
        this.status = status;
        this.comments = comments;
    }

    public TestDrive() {
		// TODO Auto-generated constructor stub
    	this.VIN = null;
        this.customerID = 0;
        this.date = null;
        this.time = null;
        this.status = null;
        this.comments = null;
    
    }

	// Getters and setters
    public String getVIN() {
        return VIN;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }
    
   // get Car by VIN
    public car getCar(String VIN) {
    	
        // Loop through the list of existing cars
        for (car existingCar : Inventory.getInstance().getCars()) {
            if (existingCar.getVin().equals(VIN)) {
                
                return existingCar;
            }
        }
        
        return null;
    }

public void scheduleTestDrive(String VIN, int customerID, Date date, String time, String status, String comments) {
        
    	car foundCar =getCar(VIN); //local car object

        if (foundCar != null) {
        	
            TestDrive newTestDrive = new TestDrive(VIN, customerID, date, time, status, comments); 

            foundCar.updateDriveSchedule(newTestDrive); //nonsense

            for (car existingCar : Inventory.getInstance().getCars()) {
                if (existingCar.getVin().equals(VIN)) {
                    
                	existingCar.updateDriveSchedule(newTestDrive);
                }    
            
              }
      }
            
        else {
            
        	System.out.println("Car with VIN " + VIN + " not found.");
        }
    }

    
}
