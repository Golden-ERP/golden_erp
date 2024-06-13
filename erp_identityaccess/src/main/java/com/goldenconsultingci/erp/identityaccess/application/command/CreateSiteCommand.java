package com.goldenconsultingci.erp.identityaccess.application.command;

public class CreateSiteCommand {
    String name;
    String type;
    String addressStreet;
    String addressCity;
    String addressCountry;
    String managerFirstName;
    String managerLastName;
    String managerEmail;
    String managerTelephone;

    public CreateSiteCommand(String name, String type, String addressStreet, String addressCity, String addressCountry, String managerFirstName, String managerLastName, String managerEmail, String managerTelephone) {
        this.name = name;
        this.type = type;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.managerEmail = managerEmail;
        this.managerTelephone = managerTelephone;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getAddressStreet() {
//        return addressStreet;
//    }
//
//    public String getAddressCity() {
//        return addressCity;
//    }

//    public String getAddressCountry() {
//        return addressCountry;
//    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    public String addressStreet() {
        return addressStreet;
    }

    public String addressCity() {
        return addressCity;
    }

    public String addressCountry() {
        return addressCountry;
    }

    public String managerFirstName() {
        return managerFirstName;
    }

    public String managerLastName() {
        return managerLastName;
    }

    public String managerEmail() {
        return managerEmail;
    }

    public String managerTelephone() {
        return managerTelephone;
    }
}
