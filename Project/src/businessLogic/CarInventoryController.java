package businessLogic;

import java.sql.SQLException;
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

	public void addCar(String vin, String make, String model, double price, int year, Date date, int ownerid, String color, double mile, String availibility) {
		// TODO Auto-generated constructor stub
		
		Inventory.getInstance().addCar(vin, make, model, price, year, date, ownerid, color,mile, availibility);
		//dbo.addCarinDB(Inventory.getInstance());
	
		newcar = new car(vin, make, model, price, year, date, ownerid, color, mile, availibility);
		
		try {
			dbo.addCarinDB(newcar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteCar()
	{
		
	}
	
	public void updateCar()
	{
		
	}

}
