package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import lombok.Data;

@Data
public class UserInSiteRepresentation {
    private String username;
    private String firstName;
    private String lastName;
    private String siteId;

    public UserInSiteRepresentation(User anUser, String aSiteId) {
        this.initialize(anUser, aSiteId);
    }

    private void initialize(User anUser, String aSiteId) {
        this.username =  anUser.username();
        this.firstName = anUser.name().firstName();
        this.lastName = anUser.name().lastName();
        this.siteId = aSiteId;
    }
}
