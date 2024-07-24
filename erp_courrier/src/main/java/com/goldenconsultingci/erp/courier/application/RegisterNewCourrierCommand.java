package com.goldenconsultingci.erp.courier.application;



import java.time.LocalDate;

public class RegisterNewCourrierCommand {
    private String type;
    private String reference;
    private String object;
    private String siteId;
    private LocalDate courrierDate;
    private String registrationNumber;
    private LocalDate arrivalDate;

    public RegisterNewCourrierCommand(String type, String reference, String object, LocalDate courrierDate, String registrationNumber, LocalDate arrivalDate) {
        this.type = type;
        this.reference = reference;
        this.object = object;
        this.courrierDate = courrierDate;
        this.registrationNumber = registrationNumber;
        this.arrivalDate = arrivalDate;
    }

    public String type() {
        return type;
    }

    public String reference() {
        return reference;
    }

    public String object() {
        return object;
    }

    public String siteId() {
        return siteId;
    }

    public LocalDate courrierDate() {
        return courrierDate;
    }

    public String registrationNumber() {
        return registrationNumber;
    }

    public LocalDate arrivalDate() {
        return arrivalDate;
    }
}
