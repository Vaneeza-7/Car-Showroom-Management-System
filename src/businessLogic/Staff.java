package businessLogic;

public class Staff extends user {
    private String designation;

    // Constructors
    public Staff(int userID, String name, String emailID, String password, String contactInfo, String designation) {
        super(userID, name, emailID, password, contactInfo);
        this.designation = designation;
    }

    // Getter and Setter
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
