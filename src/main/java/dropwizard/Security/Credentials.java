package dropwizard.Security;

/**
 * Created by gurdits on 8/14/2014.
 */
public class Credentials {

    private String token;

    public Credentials(String customeHeader) {
        token=customeHeader;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
