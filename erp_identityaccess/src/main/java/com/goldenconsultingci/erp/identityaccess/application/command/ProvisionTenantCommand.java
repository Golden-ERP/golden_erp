package com.goldenconsultingci.erp.identityaccess.application.command;

public class ProvisionTenantCommand {
    private String name;
    private String sigle;
    private String rccm;
    private int numberOfRepresentations;
    private String activityArea;
    private String taxSystem;
    private String primaryTelephone;
    private String secondaryTelephone;
    private String emailAddress;

    public ProvisionTenantCommand() {
        super();
    }

    public ProvisionTenantCommand(String name, String sigle, String rccm, int numberOfRepresentations, String activityArea, String taxSystem, String primaryTelephone, String secondaryTelephone, String emailAddress) {
        this.name = name;
        this.sigle = sigle;
        this.rccm = rccm;
        this.numberOfRepresentations = numberOfRepresentations;
        this.activityArea = activityArea;
        this.taxSystem = taxSystem;
        this.primaryTelephone = primaryTelephone;
        this.secondaryTelephone = secondaryTelephone;
        this.emailAddress = emailAddress;
    }

    public String name() {
        return name;
    }

    public String sigle() {
        return sigle;
    }

    public String rccm() {
        return rccm;
    }

    public int numberOfRepresentations() {
        return numberOfRepresentations;
    }

    public String activityArea() {
        return activityArea;
    }

    public String taxSystem() {
        return taxSystem;
    }

    public String primaryTelephone() {
        return primaryTelephone;
    }

    public String secondaryTelephone() {
        return secondaryTelephone;
    }

    public String emailAddress() {
        return emailAddress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getRccm() {
        return rccm;
    }

    public void setRccm(String rccm) {
        this.rccm = rccm;
    }

    public int getNumberOfRepresentations() {
        return numberOfRepresentations;
    }

    public void setNumberOfRepresentations(int numberOfRepresentations) {
        this.numberOfRepresentations = numberOfRepresentations;
    }

    public String getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(String activityArea) {
        this.activityArea = activityArea;
    }

    public String getTaxSystem() {
        return taxSystem;
    }

    public void setTaxSystem(String taxSystem) {
        this.taxSystem = taxSystem;
    }

    public String getPrimaryTelephone() {
        return primaryTelephone;
    }

    public void setPrimaryTelephone(String primaryTelephone) {
        this.primaryTelephone = primaryTelephone;
    }

    public String getSecondaryTelephone() {
        return secondaryTelephone;
    }

    public void setSecondaryTelephone(String secondaryTelephone) {
        this.secondaryTelephone = secondaryTelephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
