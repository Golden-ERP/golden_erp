package com.goldenconsultingci.erp.juridique.domain.model;

import com.goldenconsultingci.erp.common.domain.Entity;

public class ConseilJuridique extends Entity {
    private String name;
    private String type;
    private String email;
    private String telephone;

    protected ConseilJuridique() {super();}

    public ConseilJuridique(
            String aName, String aType,
            String anEmail,
            String aTelephone) {
        this();
        this.setName(aName);
        this.setType(aType);
        this.setEmail(anEmail);
        this.seTelephone(aTelephone);
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

}
