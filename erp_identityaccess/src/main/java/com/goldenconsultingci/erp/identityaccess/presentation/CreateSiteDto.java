package com.goldenconsultingci.erp.identityaccess.presentation;

import lombok.Data;

@Data
public class CreateSiteDto {
    String name;
    String type;
    String addressStreet;
    String addressCity;
    String addressCountry;
    String managerFirstName;
    String managerLastName;
    String managerEmail;
    String managerTelephone;
}
