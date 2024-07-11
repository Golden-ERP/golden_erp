package com.goldenconsultingci.erp.courier.presentation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterCourrierDto {
    private String type;
    private String reference;
    private String object;
    private String siteId;
    private String courrierDate;
    private String registrationNumber;
    private String arrivalDate;
}
