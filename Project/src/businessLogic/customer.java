package businessLogic;

import java.util.ArrayList;

public class customer extends user {
    private ArrayList<String> ownedCars;
    private int numberOfCarsOwned;

    public customer(int userID, String name, String emailID, String password, String contactInfo, ArrayList<String> ownedCars, int numberOfCarsOwned)
    {
        super(userID, name, emailID, password, contactInfo);
        this.ownedCars = ownedCars;
        this.numberOfCarsOwned = numberOfCarsOwned;
    }

    public ArrayList<String> getOwnedCars() {
        return ownedCars;
    }

    public void setOwnedCars(ArrayList<String> ownedCars) {
        this.ownedCars = ownedCars;
    }

    public int getNumberOfCarsOwned() {
        return numberOfCarsOwned;
    }

    public void setNumberOfCarsOwned(int numberOfCarsOwned) {
        this.numberOfCarsOwned = numberOfCarsOwned;
    }

    
}

