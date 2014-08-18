package dropwizard.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Project {

    @JsonProperty
    public String UID;
    @JsonProperty
    public String fname;
    @JsonProperty
    public String lname;
    @JsonProperty
    public String phone;
    @JsonProperty
    public String email;

    public Project(String UID, String fname, String lname, String phone, String email) {
        this.UID = UID;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public Project(String fname, String lname, String phone, String email) {
        this.UID= UUID.randomUUID().toString();
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUID() {
        return UID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
