package com.goldenconsultingci.erp.identityaccess.presentation;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String telephone;
    private String username;
    private String password;
    private String gender;
    private String occupation;
}
