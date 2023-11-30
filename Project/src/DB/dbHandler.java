package DB;

import java.sql.*;
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
	
	
}
