package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DB.dbHandler;

public class UserController {
	
	dbHandler dbo;
	user User;
	
	public UserController() {
		dbo = new dbHandler();
		User=null;
	}

	public user retreiveUserInfo(int id) {
		// TODO Auto-generated constructor stub
		
		User= dbo.fetchUserData(id);
		return User;
		
	}
	
	public void changePassword(int id, String pass)
	{
		dbo.updatePassword(id, pass);
		
	}

}
