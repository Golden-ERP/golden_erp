package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public class UserDescriptor {
    private String username;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String siteId;

    public UserDescriptor(String username, String firstName, String lastName, String emailAddress, String siteId) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.siteId =  siteId;
    }

    public String username() {
        return username;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String emailAddress() {
        return emailAddress;
    }

    public String siteId() {
        return siteId;
    }
}
