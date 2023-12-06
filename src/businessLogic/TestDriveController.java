package businessLogic;

import java.sql.Time;
import java.util.Date;

import DB.dbHandler;

public class TestDriveController {
	dbHandler dbo;
	TestDrive drive;
	
	public TestDriveController () {
		dbo = new dbHandler();
	    drive = new TestDrive();
	}

	public void createTestDrive(String vin, int customerID, Date date, String time, String status, String comments)
	{
		drive = new TestDrive(vin, customerID, date, time, status, comments);
		drive.scheduleTestDrive(vin, customerID, date, time, status, comments);
		dbo.saveTestDrive(drive);
		
	}
	
	


}
