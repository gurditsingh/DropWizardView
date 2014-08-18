package dropwizard.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by GURDIT_SINGH on 15-08-2014.
 */
public class Member {

    private String MID;
    private String mName;
    private String mEmail;
    private String mPassword;
    private String mCreatedBy;



    public Member(String MID, String mName, String mEmail, String mPassword, String mCreatedBy) {
        this.MID = MID;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mCreatedBy = mCreatedBy;
    }

    public Member(String mName, String mEmail, String mPassword) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.MID= UUID.randomUUID().toString();
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mCreatedBy=dateFormat.format(date);
    }

    public String getMID() {
        return MID;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public String getmCreatedBy() {
        return mCreatedBy;
    }
}
