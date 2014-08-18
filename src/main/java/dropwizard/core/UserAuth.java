package dropwizard.core;

/**
 * Created by gurdits on 8/14/2014.
 */
public class UserAuth {

    public static String ROLE_ADMIN="Admin";
    public static String ROLE_EDITOR="Editor";

    private String userName;
    private String password;
    private String userRole;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
