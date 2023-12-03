package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DB.dbHandler;

public class CarViewFacade {

	dbHandler dbo;
	List<car> cars;
	
	public CarViewFacade() {
		dbo = new dbHandler();
		cars= new ArrayList<>();
	}

	public List<car> retreiveCars() {
		// TODO Auto-generated constructor stub
		
		List<car> cars= dbo.retreiveCarList();
		return cars;
		
	}

}
