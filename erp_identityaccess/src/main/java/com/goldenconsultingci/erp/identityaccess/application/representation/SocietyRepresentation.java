package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.*;

public class SocietyRepresentation {
    private String name;
    private String sigle;
    private String rccm;
    private String primaryTelephone;
    private String secondaryTelephone;
    private String emailAddress;
    private int numberOfRepresentations;
    private String activityArea;
    private String taxSystem;

    public SocietyRepresentation(Society aSociety) {
        super();
        this.initializeFrom(aSociety);
    }

    protected void initializeFrom(Society aSociety) {
        this.name = aSociety.name();
        this.sigle = aSociety.sigle();
        this.rccm =  aSociety.rccm();
        this.emailAddress = aSociety.contactInformation().emailAddress().address();
        this.primaryTelephone = aSociety.contactInformation().primaryTelephone().number();
        this.secondaryTelephone =
                aSociety.contactInformation().secondaryTelephone() == null ?
                        null :
                        aSociety.contactInformation().secondaryTelephone().number();
        this.activityArea = aSociety.activityArea();
        this.numberOfRepresentations = aSociety.numberOfRepresentations();
        this.taxSystem = aSociety.taxSystem().name();

    }

    public String getName() {
        return name;
    }

    public String getSigle() {
        return sigle;
    }

    public String getRccm() {
        return rccm;
    }

    public String getPrimaryTelephone() {
        return primaryTelephone;
    }

    public String getSecondaryTelephone() {
        return secondaryTelephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getNumberOfRepresentations() {
        return numberOfRepresentations;
    }

    public String getActivityArea() {
        return activityArea;
    }

    public String getTaxSystem() {
        return taxSystem;
    }
}
