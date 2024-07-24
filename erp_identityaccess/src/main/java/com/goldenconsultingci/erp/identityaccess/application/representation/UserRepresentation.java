package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;

public class UserRepresentation {
    private String username;
    private String firstName;
    private String lastName;
    private String telephone;
    private String emailAddress;
    private String occupation;
    private String gender;

    public UserRepresentation(User anUser) {
        if (anUser == null) {
            throw new RuntimeException("Impossible de traiter la réquete.");
        }
        this.initialize(anUser);
    }

    private void initialize(User anUser) {
        this.username = anUser.username();
        this.firstName = anUser.name().firstName();
        this.lastName = anUser.name().lastName();
        this.telephone = anUser.telephone().number();
        this.emailAddress = anUser.emailAddress().address();
//        this.occupation = anUser.actor().occupation();
        this.gender = anUser.actor().gender().toString();
    }
}
