package businessLogic;

import java.util.Date;

import DB.dbHandler;

public class ServiceController {
	
	dbHandler dbo;
	ServiceSchedule service;
	
	public ServiceController () {
		dbo = new dbHandler();
	    service = new ServiceSchedule();
	}

	public void createService(String vin,String type, Date date, String status, String comments)
	{
		service=new ServiceSchedule(vin, type, date, status, comments, 0);
		service.scheduleCarService(vin, type, date, status, comments, 0);
		dbo.saveService(service);
		
		
	}


}
