package DB;
import businessLogic.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class dbHandler {

	private String username = "root";
	private String pass = "vcpkf2021";
	Connection con; // connection object
	Integer consumprate[]= {0,0,0,0,0,0,0,0,0,0};
	
	public dbHandler() { // default constructor

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carshowroom", username, pass);
			System.out.println("Connection made to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

	}
	
	public void addUser(int usid, String name, String emID, String pwd, String info)//pass user object here
	{
		try {
			String query= "insert into users (UserID, Name, EmailID, Password, ContactInformation) values(?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1, usid);
			st.setString(2, name);
			st.setString(3, emID);
			st.setString(4, pwd);
			st.setString(5, info);			
						

			int rows = st.executeUpdate();
			if (rows > 0) {
				System.out.println("A User was Added.");
			}
		 
		}
		
		catch(Exception e)
		
		{
			System.out.println("Failed to add user to db "+ e);
		}
		
	}
	
	//for invoice ids
	public int getLastUsedInvoiceIDFromDatabase() {
        int lastUsedID = 0;  // Default value if no ID is found

        try {
            String query = "SELECT MAX(InvoiceID) FROM Invoice";  
           
            PreparedStatement statement = con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery();
                if (resultSet.next())
                {
                    lastUsedID = resultSet.getInt(1);
                }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();  
        }

        return lastUsedID;
    }
	
	//for order ids
	public int getLastUsedOrderIDFromDatabase(){
		int lastUsedID = 0;  // Default value if no ID is found

        try {
            String query = "SELECT MAX(OrderID) FROM purchaseOrder";  
           
            PreparedStatement statement = con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery();
                if (resultSet.next())
                {
                    lastUsedID = resultSet.getInt(1);
                }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();  
        }

        return lastUsedID;
		
	}
	
	public List<car> retreiveCarList() {
	 String vin, make, model, color, status;
		double price;
		int mile, year;
		Date serviceDate;
		
		try {
			String query="select VIN, Make, Model, Year, Price, Color, Mileage, AvailabilityStatus, lastServiceDate from inventory inner join car on car.vin=inventory.VINs where AvailabilityStatus='Available'";
		    PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
           while (resultSet.next())
           {
               vin = resultSet.getString(1);
               make = resultSet.getString(2);
               model = resultSet.getString(3);
               year = resultSet.getInt(4);
               price = resultSet.getDouble(5);
               color = resultSet.getString(6);
               mile = resultSet.getInt(7);
               status = resultSet.getString(8);
               serviceDate=resultSet.getDate(9);
   
               Inventory.getInstance().addCar(vin, make, model, price, year, serviceDate, 0 , color, mile, status);
           }
		} 
         	
		   
		
		catch (SQLException e) {
            e.printStackTrace();  
        }

		
		return Inventory.getInstance().getCars();
		
		
		
	} 
	
	public boolean authenticateUser(int id, String pwd, String role)
	{
		String query;
		if(role=="Manager") {
		
			 query = "select* from users inner join manager on managerId where managerID= ? and password= ?";
		}
		else if(role=="Staff")
		{
			 query = "select* from users inner join staff on staffId where staffID= ? and password= ?";
		}
		else
		{
			 query = "select* from users inner join customer on customerId where customerID= ? and password= ?";				
		}
		
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pwd);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if user exists with the provided credentials
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
    	}    
        
    } 
	
		public user fetchUserData(int id)
		{
			user User = null;
			String query = "SELECT userId, name, emailID, contactInformation, Password FROM users WHERE userId = ?";
            try(PreparedStatement statement = con.prepareStatement(query)){
            statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int userId = resultSet.getInt("userId");
                        String name = resultSet.getString("name");
                        String emailID = resultSet.getString("emailID");
                        String contactInformation = resultSet.getString("contactInformation");
                        String password = resultSet.getString("Password");
                        User = new user(userId, name, emailID, contactInformation, password);
                        
                    }
                }
            }
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Failed to fetch user data");
                    // Handle any exceptions that may occur during database access
                }
			
			return User;
		}
	
		public void updatePassword(int userID, String pass)
		{
			try {
			String query="UPDATE users SET password = ? WHERE userID = ?";
            PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, pass);
			st.setInt(2, userID);			

			int rows = st.executeUpdate();
			if (rows > 0) {
				System.out.println("Password was Updated for user "+ userID);
			}
		 
		}
		
		catch(Exception e)
		
		{
			System.out.println("Failed to update password "+ e);
		}
		

		}
		
		public void addCarinDB (Inventory i)
		{
			//String quer1=
			//String query="insert into car (VIN, Make, Model, Year, Price, Color, Mileage, AvailabilityStatus, lastServiceDate from inventory inner join car on car.vin=inventory.VINs where AvailabilityStatus='Available'";
		    //PreparedStatement statement = con.prepareStatement(query);
		    
		    //st.setInt(1, usid);
			//st.setString(2, name);
			//st.setString(3, emID);
			//st.setString(4, pwd);
			//st.setString(5, info);			
						

			//int rows = st.executeUpdate();
			//if (rows > 0) {
				//System.out.println("A User was Added.");
			//}

            	
			
		}
	
       
}