package com.goldenconsultingci.erp.juridique.domain.model;

import com.goldenconsultingci.erp.common.domain.Entity;

public class Tiers extends Entity {
    private static final long srialVersionUID =  1L;
    private String name;
    private String type;
    private String email;
    private String telephone;
    private String activityArea;

    protected Tiers() {super();}

    public Tiers(
            String aName, String aType,
            String anEmail, String aTelephone,
            String anActivityArea) {
        this();
        this.setName(aName);
        this.setType(aType);
        this.setEmail(anEmail);
        this.seTelephone(aTelephone);
        this.setActivityArrea(anActivityArea);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le libéllé du tiers est réquis.");
        this.name = aName;
    }

    private void setType(String aType) {
        this.assertArgumentNotEmpty(aType, "Le type de tiers est réquis.");
        this.type = aType;
    }

    private void setEmail(String anEmail) {
        this.email = anEmail;
    }

    private void seTelephone(String aTelephone) {
        this.telephone =  aTelephone;
    }

    private void setActivityArrea(String anActivityArea) {
        this.activityArea = anActivityArea;
    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    public String email() {
        return email;
    }

    public String telephone() {
        return telephone;
    }

    public String activityArea() {
        return activityArea;
    }
}
