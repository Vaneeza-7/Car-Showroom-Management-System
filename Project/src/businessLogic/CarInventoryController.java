package businessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DB.dbHandler;

public class CarInventoryController {

	
	dbHandler dbo;
	car newcar;
	List<car> cars;
	
	
	public CarInventoryController() {
		dbo = new dbHandler();
		newcar = new car();
		cars= new ArrayList<>();
	}

	public void addCar(String vin, String make, String model, double price, int year, Date date, int ownerid, String color, int mileage, String availibility) {
		// TODO Auto-generated constructor stub
		
		Inventory.getInstance().addCar(vin, make, model, price, year, date, ownerid, color,mileage, availibility);
		dbo.addCarinDB(Inventory.getInstance());
	
		
	}
	
	public void deleteCar()
	{
		
	}
	
	public void updateCar()
	{
		
	}

}
