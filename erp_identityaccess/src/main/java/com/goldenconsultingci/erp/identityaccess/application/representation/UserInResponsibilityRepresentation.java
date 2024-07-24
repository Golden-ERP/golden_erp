package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;

public class UserInResponsibilityRepresentation {
    private String username;
    private String firstName;
    private String lastName;
    private String siteId;
    private String responsibility;

    public UserInResponsibilityRepresentation(User anUser, String aResponsibility, String aSite) {
        this.firstName =  anUser.name().firstName();
        this.lastName =  anUser.name().lastName();
        this.siteId = aSite;
        this.responsibility = aResponsibility;
        this.username = anUser.username();
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSiteId() {
        return siteId;
    }

    public String getResponsibility() {
        return responsibility;
    }
}
