package dropwizard.core;

import java.util.UUID;

/**
 * Created by gurdits on 8/12/2014.
 */
public class User {

    private String ID;
    private String userEmail;
    private String password;

    public User(String ID, String userEmail, String password) {
        this.ID = ID;
        this.userEmail = userEmail;
        this.password = password;
    }

    public User(String userEmail, String password) {
        ID= UUID.randomUUID().toString();
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

}
