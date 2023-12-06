package businessLogic;

import java.util.Date;

public class ServiceSchedule {
    private String VIN;
    private String serviceType;
    private Date date;
    private String status;
    private String comments;
    private int empID;

    public ServiceSchedule(String VIN, String serviceType, Date date, String status, String comments, int empID ) {
        this.VIN = VIN;
        this.serviceType = serviceType;
        this.date = date;
        this.status = status;
        this.comments = comments;
        this.empID=empID;
    }

    public ServiceSchedule() {
		// TODO Auto-generated constructor stub
    	this.VIN = null;
        this.serviceType = null;
        this.date = null;
        this.status = null;
        this.comments = null;
        this.empID=0;
	}

	public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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
    
    public void scheduleCarService(String VIN, String serviceType, Date date, String status, String comments, int empID) {
        
    	car foundCar =getCar(VIN);

        if (foundCar != null) {
        	
            // Create a new service schedule and associate it with the car
            ServiceSchedule newSchedule = new ServiceSchedule(VIN, serviceType, date, status, comments, empID); 

            // Add the new schedule to the car
            foundCar.updateServiceSchedule(newSchedule);//just for the sake of sd

            for (car existingCar : Inventory.getInstance().getCars()) {
                if (existingCar.getVin().equals(VIN)) {
                    
                	existingCar.updateServiceSchedule(newSchedule);
                }    
            
              }
        }
            
        else {
            
        	System.out.println("Car with VIN " + VIN + " not found.");
        }
    }

}

