package businessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Inventory {
	private static Inventory instance;
    private ArrayList<car> VINs;
    private Date lastUpdated;

    // Private constructor. for SINGLETON pattern
    private Inventory() {
        VINs = new ArrayList<>();
        lastUpdated = new Date();
    }

    // Public method to get the instance of Inventory
    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    
    // Getters and Setters
    public ArrayList<car> getCars() {
        return VINs;
    }

    public void setCars(ArrayList<car> cars) {
        this.VINs = cars;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
   
    public void addCar(String vin, String make, String model, double price, int year,
           Date lastServiceDate, int ownerId,  String color, double mileage, String availability) {
          
    	  car newCar = new car(vin, make, model, price, year, lastServiceDate, 0, color, mileage, availability);
          VINs.add(newCar);
          lastUpdated = new Date();
}

    public void removeCar(String vin)
    {
    	Iterator<car> iterator = VINs.iterator();
    	while (iterator.hasNext()) {
    	    car Car = iterator.next();
    	    if (Car.getVin()==vin) {
    	        iterator.remove();  // Use iterator's remove method
    	    }
    	}
    	 
    }
    

}
