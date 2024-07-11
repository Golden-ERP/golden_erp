package com.goldenconsultingci.erp.identityaccess.domain.model.setting;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.io.Serializable;

public class Setting extends Entity implements Serializable {
    private String name;
    private String possibleValues;

    protected Setting() {super();}

    public Setting(String  aName, String aPossibleValues) {
        this();
        this.setName(aName);
        this.setPossibleValues(aPossibleValues);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le nom de paramètre est réquis.");
        this.name =  aName;
    }

    private void setPossibleValues(String aPossibleValues) {
        this.assertArgumentNotEmpty(aPossibleValues, "Le paramètre doit contenir au moins une valeur.");
        this.possibleValues = aPossibleValues;
    }

    public String getName() {
        return name;
    }

    public String getPossibleValues() {
        return possibleValues;
    }

    public void changePossibleValues(String aPossibleValues) {
        this.setPossibleValues(aPossibleValues);
    }
}
