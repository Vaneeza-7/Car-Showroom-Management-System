package businessLogic;

import java.util.ArrayList;
import java.util.Date;

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

}
