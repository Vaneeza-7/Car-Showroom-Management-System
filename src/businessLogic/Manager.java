package businessLogic;

public class Manager extends user {
    private String department;

    // Constructor
    public Manager(int userID, String name, String emailID, String password, String contactInfo, String department) {
        super(userID, name, emailID, password, contactInfo);
        this.department = department;
    }

    // Getter and Setter
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

