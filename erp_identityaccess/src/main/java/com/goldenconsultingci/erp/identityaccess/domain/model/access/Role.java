package com.goldenconsultingci.erp.identityaccess.domain.model.access;

import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;
import com.goldenconsultingci.erp.common.domain.Entity;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Department;

public class Role extends ConcurrencySafeEntity {
    private String name;
    private String description;

    protected Role() {
        super();
    }

    public Role(String aRoleName, String aDescription) {
        this();
        this.setName(aRoleName);
        this.setDescription(aDescription);
    }

    private void setName(String aRoleName) {
        this.assertArgumentNotEmpty(aRoleName, "Le nom du role est réquis.");
        this.name =  aRoleName;
    }

    private void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
