package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Responsibility;

public class ResponsibilityRepresentation {
    private String name;
    private String description;

    private ResponsibilityRepresentation() {
        super();
    }

    public ResponsibilityRepresentation(Responsibility aResponsibility) {
        this.name = aResponsibility.name();
        this.description = aResponsibility.description();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
