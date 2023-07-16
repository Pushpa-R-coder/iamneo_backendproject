package iamneo.model;

import java.util.Base64;

public class Project {
    private String name;
    private String email;
    private String dob;
    private String address;
    private String phoneNo;
    private String password;
 

    public Project() {
        
    }

    public Project(String name, String email, String dob, String address, String phoneNo, String password) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phoneNo = phoneNo;
        this.password = password;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
    
}
