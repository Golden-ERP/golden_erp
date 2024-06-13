package com.goldenconsultingci.erp.identityaccess.application.command;

public class RegisterUserCommand {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String telephone;
    private String username;
    private String password;
    private String gender;
    private String occupation;

    public RegisterUserCommand(String firstName, String lastName, String emailAddress, String telephone, String username, String password, String gender, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.occupation = occupation;
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

    public String telephone() {
        return telephone;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String gender() {
        return gender;
    }

    public String occupation() {
        return occupation;
    }
}
