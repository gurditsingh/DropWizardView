package dropwizard.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by GURDIT_SINGH on 15-08-2014.
 */
public class SignUp {

    private String HID;
    private String hName;
    private String hEmail;
    private String hPassword;
    private String hCreatedBy;


    public SignUp(String HID, String hName, String hEmail, String hPassword, String hCreatedBy) {
        this.HID = HID;
        this.hName = hName;
        this.hEmail = hEmail;
        this.hPassword = hPassword;
        this.hCreatedBy = hCreatedBy;
    }

    public SignUp(String hName, String hEmail, String hPassword) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.HID= UUID.randomUUID().toString();
        this.hName = hName;
        this.hEmail = hEmail;
        this.hPassword = hPassword;
        this.hCreatedBy=dateFormat.format(date);
    }

    public String getHID() {
        return HID;
    }

    public String gethName() {
        return hName;
    }

    public String gethEmail() {
        return hEmail;
    }

    public String gethPassword() {
        return hPassword;
    }

    public String gethCreatedBy() {
        return hCreatedBy;
    }

}
