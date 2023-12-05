package businessLogic;

public class user {

	private int UserID;
	private String name, emailID, password, contactInfo;
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public user(int userID, String name, String emailID, String password, String contactInfo) {
		super();
		UserID = userID;
		this.name = name;
		this.emailID = emailID;
		this.password = password;
		this.contactInfo = contactInfo;
	}
	
	
};

