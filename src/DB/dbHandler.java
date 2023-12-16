package DB;
import java.time.LocalDate;

import businessLogic.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
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
	
	//for Invoice ids
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
				String query = "UPDATE users "
		                + "SET password = ? "
		                + "WHERE userID = ?";
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
		
		public void addCarinDB (car newcar) throws SQLException
		{
			
			String query1="insert into inventory (VINs, LastUpdated) values (?,?)";
			String query = "insert into car (VIN, Make, Model, Year, Price,lastServiceDate, Owner, Color, Mileage, AvailabilityStatus) values (?,?,?,?,?,?,?,?,?,?) ";
			try {
			   PreparedStatement statement = con.prepareStatement(query1);
			   statement.setString(1, newcar.getVin());
			   LocalDate current = LocalDate.now();
				java.sql.Date sqlDate = Date.valueOf(current);
				statement.setDate(2, sqlDate);
				
				int rows = statement.executeUpdate();
				if (rows > 0) {
				     System.out.println("A Car was Added in inventory.");
				}
			
			}
			catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to add car in inventory");
                // Handle any exceptions that may occur during database access
            }
			
			
			try {
			PreparedStatement st = con.prepareStatement(query);
		    
		    st.setString(1, newcar.getVin());
			st.setString(2, newcar.getMake());
			st.setString(3, newcar.getModel());
			st.setInt(4, newcar.getYear());
			st.setDouble(5, newcar.getPrice());
			
			java.util.Date utilDate = newcar.getLastServiceDate(); 
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			st.setDate(6, sqlDate);
			st.setInt(7, 0);
			st.setString(8, newcar.getColor());
			st.setDouble(9, newcar.getMileage());
			st.setString(10, newcar.getAvailability());			
			
			int rows = st.executeUpdate();
			if (rows > 0) {
			     System.out.println("A Car was Added.");
			}
			
			}
			catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to add car");
                // Handle any exceptions that may occur during database access
            }
		
			
		}

		public void removeCarinDB(String vin) {
			// TODO Auto-generated method stub
			String query="DELETE FROM car WHERE vin = ?";
			 
			try{
				PreparedStatement st = con.prepareStatement(query);
				
				st.setString(1, vin);		

				int rows = st.executeUpdate();
				if (rows > 0) {
					System.out.println("Car deleted from Database");
				}
			 
			}
			
			catch(Exception e)
			
			{
				System.out.println("Failed to delete car "+ e);
			}
			
			String query1="DELETE FROM Inventory WHERE VINs = ?";
			 
			try{
				PreparedStatement st1 = con.prepareStatement(query1);
				
				st1.setString(1, vin);		

				int rows = st1.executeUpdate();
				if (rows > 0) {
					System.out.println("Car deleted from Inventory");
				}
			 
			}
			
			catch(Exception e)
			
			{
				System.out.println("Failed to delete car from inventory "+ e);
			}
			
			
		}

		public void updateCarInfo(String vin, String make, String model, int year, String color, double mileage,
				double price, String status) {
			// TODO Auto-generated method stub
			
			String updateQuery = "UPDATE car SET make=?, model=?, year=?, price=?, mileage=?, color=? WHERE vin=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, make);
                preparedStatement.setString(2, model);
                preparedStatement.setInt(3, year);
                preparedStatement.setDouble(4, price);
                preparedStatement.setDouble(5, mileage);
                preparedStatement.setString(6, color);
                preparedStatement.setString(7, vin);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Car information updated successfully");
                } else {
                    System.out.println("Car not found");
                }
            }
        
		catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
			
		
		}

		public void storeInvoice(Invoice invoice) {
			// TODO Auto-generated method stub
			String insertQuery = "INSERT INTO Invoice (Invoice_id, order_id, customer_id, tax, price, total_amount, date, terms_and_conditions) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
            	preparedStatement.setInt(1, invoice.getInvoiceId());
                preparedStatement.setInt(2, invoice.getOrderId());
                preparedStatement.setInt(3, invoice.getCustomerId());
                preparedStatement.setDouble(4, invoice.getTax());
                preparedStatement.setDouble(5, invoice.getPrice());
                preparedStatement.setDouble(6, invoice.getTotalAmount());
                preparedStatement.setDate(7, (Date) invoice.getDate());
                preparedStatement.setString(8, invoice.getTermsAndConditions());

                preparedStatement.executeUpdate();
            }
            
         catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, e.g., log or throw a custom exception
        }
					
	}
		
	    
	    public String fetchAndDisplayCustomerDetails(String customerName) {
	    	String itemDetails="None found";  
	    	String query = "select car.VIN, make, model, year from car inner join purchaseOrder on purchaseOrder.VIN where customerID in (select userID from users inner join customer on customerId where users.Name= ?";
	            try (PreparedStatement preparedStatement = con.prepareStatement(query)) 
	            {
	                preparedStatement.setString(1, customerName);
	                try (ResultSet resultSet = preparedStatement.executeQuery()) 
	                {
	                    if (resultSet.next()) 
	                    {
	                        itemDetails = resultSet.getString("item_details");
	                        
	                        //itemDetailsTextArea.setText("Item Details:\n" + itemDetails);    
	                    } 
	                    else
	                    {
	                        //itemDetailsTextArea.setText("Customer didnot buy any car.");
	                    }
	                }
	                catch (SQLException ex)
	                {
	    	            ex.printStackTrace();
	    	            //itemDetailsTextArea.setText("Error connecting to the database.");
	    	        }
	            }
	        
	            catch (SQLException ex) {
	            ex.printStackTrace();
	            //itemDetailsTextArea.setText("Error connecting to the database.");
	        }
	            
				
	            return itemDetails;
	    }
	    
	    
	    
	    public void createPurchaseOrder(PurchaseOrder purchaseOrder)
	    {
	    	 String insertQuery = "INSERT INTO PurchaseOrder (orderID, CustomerID, Date, VIN, Comments, Status) VALUES (?, ?, ?, ?, ?, ?)";
	            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
	                preparedStatement.setInt(1, purchaseOrder.getOrderID());
	                preparedStatement.setInt(2, purchaseOrder.getCustomerID());
	                preparedStatement.setDate(3, new Date(purchaseOrder.getDate().getTime())); // Assuming purchaseOrder.getDate() returns a java.util.Date
	                preparedStatement.setString(4, purchaseOrder.getVIN());
	                preparedStatement.setString(5, purchaseOrder.getComments());
	                preparedStatement.setString(6, purchaseOrder.getStatus());

	                preparedStatement.executeUpdate();
	            }
	            
	         catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception
	        }
	    }
	    
	    public void saveTestDrive(TestDrive testdrive) {

	            String query = "INSERT INTO TestDrive (VIN, CustomerID, Date, Time, Status, Comments) " +
	                    "VALUES (?, ?, ?, ?, ?, ?)";

	            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	                preparedStatement.setString(1, testdrive.getVIN());
	                preparedStatement.setInt(2, testdrive.getCustomerID());
	              //  preparedStatement.setDate(3, java.sql.Date.valueOf(dateTextField.getText()));
	               // preparedStatement.setTime(4, java.sql.Time.valueOf(timeTextField.getText()));
	                java.sql.Date sqlDate = new java.sql.Date(testdrive.getDate().getTime());
	                preparedStatement.setDate(3, sqlDate);
	                
	                preparedStatement.setTime(4, java.sql.Time.valueOf(testdrive.getTime()));
	                
	                preparedStatement.setString(5, testdrive.getStatus());
	                preparedStatement.setString(6, testdrive.getComments());

	                int affectedRows = preparedStatement.executeUpdate();

	                if (affectedRows > 0) {
	                	System.out.println("TestDrive created successfully in DB");
	                    
	                } 
	                else
	                {
	                	System.out.println("TestDrive failed to go in DB");
	                }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	         
	            
	        }
	    }

		public void saveService(ServiceSchedule service) {
			
			
			// TODO Auto-generated method stub
	        String query = "INSERT INTO ServiceSchedule (VIN, ServiceType, Date, Status, Comments) " +
	                "VALUES (?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	            preparedStatement.setString(1, service.getVIN());
	            preparedStatement.setString(2, service.getServiceType());
	            java.sql.Date sqlDate = new java.sql.Date(service.getDate().getTime());
	              
	            preparedStatement.setDate(3, sqlDate);
	            preparedStatement.setString(4, service.getStatus());
	            preparedStatement.setString(5, service.getComments());

	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("Car service saved in DB");
	            } 
	            else
	            {
                    System.out.println("Car service NOT saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
		}

		public int getNextTransID() {
			// TODO Auto-generated method stub
			int lastUsedID = 0;  // Default value if no ID is found

	        try {
	            String query = "SELECT MAX(TransactionID) FROM payment";  
	           
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

	        return lastUsedID+1;

		}

		public void storeCash(Cash cash) {
			// TODO Auto-generated method stub
	        
	        String query3 = "INSERT INTO Payment (TransactionID, InvoiceID, CustomerID, Amount, Status, PaymentDate) " +
	                "VALUES (?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query3)) {
	            preparedStatement.setInt(1, cash.getTransactionID());
	            preparedStatement.setString(2, null);
	            preparedStatement.setInt(3, cash.getCustomerID());
	            preparedStatement.setDouble(4, cash.getAmount());
	            preparedStatement.setString(5, cash.getStatus());
	            
	            java.sql.Date sqlDate = new java.sql.Date(cash.getPaymentDate().getTime());   
	            preparedStatement.setDate(6, sqlDate);
	           
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("PaymentDetails saved DB");
	            } 
	            else
	            {
                    System.out.println("Payment saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			
			String query = "INSERT INTO PaymentDetails (TransactionID, VIN, CustomerID, Amount, Status, PaymentDate) " +
	                "VALUES (?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	            preparedStatement.setInt(1, cash.getTransactionID());
	            preparedStatement.setString(2, cash.getVin());
	            preparedStatement.setInt(3, cash.getCustomerID());
	            preparedStatement.setDouble(4, cash.getAmount());
	            preparedStatement.setString(5, cash.getStatus());
	            
	            java.sql.Date sqlDate = new java.sql.Date(cash.getPaymentDate().getTime());   
	            preparedStatement.setDate(6, sqlDate);
	           
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("PaymentDetails saved DB");
	            } 
	            else
	            {
                    System.out.println("Payment saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			
			
			
			String query1 = "INSERT INTO cash (TransactionID, AccountNumber, PIN, Bank) " +
	                "VALUES (?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query1)) {
	            preparedStatement.setInt(1, cash.getTransactionID());
	            preparedStatement.setString(2, cash.getAccountNumber());
	            preparedStatement.setInt(3, cash.getPin());
	            preparedStatement.setString(4, cash.getBank());
	          
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("Cash saved DB");
	            } 
	            else
	            {
                    System.out.println("Cash NOT saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			

			
		}

		public void storeCard(CreditCard card) {
			// TODO Auto-generated method stub
			
	        String query3 = "INSERT INTO Payment (TransactionID, InvoiceID, CustomerID, Amount, Status, PaymentDate) " +
	                "VALUES (?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query3)) {
	            preparedStatement.setInt(1, card.getTransactionID());
	            preparedStatement.setString(2, null);
	            preparedStatement.setInt(3, card.getCustomerID());
	            preparedStatement.setDouble(4, card.getAmount());
	            preparedStatement.setString(5, card.getStatus());
	            
	            java.sql.Date sqlDate = new java.sql.Date(card.getPaymentDate().getTime());   
	            preparedStatement.setDate(6, sqlDate);
	           
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

	                   System.out.println("PaymentDetails saved DB");
	            } 
	            else
	            {
	                System.out.println("Payment saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			
			String query = "INSERT INTO PaymentDetails (TransactionID, VIN, CustomerID, Amount, Status, PaymentDate) " +
	                "VALUES (?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	            preparedStatement.setInt(1, card.getTransactionID());
	            preparedStatement.setString(2, card.getVin());
	            preparedStatement.setInt(3, card.getCustomerID());
	            preparedStatement.setDouble(4, card.getAmount());
	            preparedStatement.setString(5, card.getStatus());
	            
	            java.sql.Date sqlDate = new java.sql.Date(card.getPaymentDate().getTime());   
	            preparedStatement.setDate(6, sqlDate);
	           
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("PaymentDetails saved DB");
	            } 
	            else
	            {
                    System.out.println("Payment saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			
			
			
			String query1 = "INSERT INTO CreditCard (TransactionID, CreditCardNumber, Code) " +
	                "VALUES (?, ?, ?)";

	        try (PreparedStatement preparedStatement = con.prepareStatement(query1)) {
	            preparedStatement.setInt(1, card.getTransactionID());
	            preparedStatement.setString(2, card.getCreditCardNumber());
	            preparedStatement.setInt(3, card.getCode());
	          
	            int affectedRows = preparedStatement.executeUpdate();

	            if (affectedRows > 0) {

                       System.out.println("Card saved DB");
	            } 
	            else
	            {
                    System.out.println("Card NOT saved in DB");

	            }
	        }
	     
	        catch (SQLException e) 
	        {
	        e.printStackTrace();
	       }
			
		


			
		}	
}
	    

	    
	    
	    
	    

       
	    
	    
	    





