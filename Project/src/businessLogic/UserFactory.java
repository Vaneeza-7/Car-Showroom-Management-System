package businessLogic;

public class UserFactory {

    public static user createUser(int userID, String name, String emailID, String password, String contactInfo, String userType) {
        switch (userType.toLowerCase()) {
            case "manager":
                return new Manager(userID, name, emailID, password, contactInfo, "default_department");
            case "staff":
                return new Staff(userID, name, emailID, password, contactInfo, "default_designation");
            default:
                return new user(userID, name, emailID, password, contactInfo);
        }
    }
}
