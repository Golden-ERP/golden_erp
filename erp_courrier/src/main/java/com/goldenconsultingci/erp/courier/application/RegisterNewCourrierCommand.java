package com.goldenconsultingci.erp.courier.application;

import com.goldenconsultingci.erp.common.domain.TaxSystem;
import com.goldenconsultingci.erp.courier.domain.CourrierId;
import com.goldenconsultingci.erp.courier.domain.CourrierType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterNewCourrierCommand {
    private String type;
    private String reference;
    private String object;
    private String siteId;
    private LocalDate courrierDate;
    private String registrationNumber;
    private LocalDate arrivalDate;

    public RegisterNewCourrierCommand(String type, String reference, String object, String siteId, LocalDate courrierDate, String registrationNumber, LocalDate arrivalDate) {
        this.type = type;
        this.reference = reference;
        this.object = object;
        this.siteId = siteId;
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
