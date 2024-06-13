package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class Society extends ConcurrencySafeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String sigle;
    private String rccm;
    private ContactInformation contactInformation;
    private int numberOfRepresentations;
    private String activityArea;
    private TaxSystem taxSystem;


    private Society() {
        super();
    }

    public Society(
            String aName,
            String aSigle,
            String aRccm,
            ContactInformation aContactInformation,
            int aNumberOfRepresentations,
            String anActivityArea,
            TaxSystem aTaxSystem) {
        this();
        this.setName(aName);
        this.setSigle(aSigle);
        this.setRccm(aRccm);
        this.setContactInformation(aContactInformation);
        this.setNumberOfRepresentations(aNumberOfRepresentations);
        this.setActivityArea(anActivityArea);
        this.setTaxSystem(aTaxSystem);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName,"Le nom de la société est réquies.");
        this.assertArgumentLength(aName, 2, 100, "Le nom de la société doit comporter 100 caratères ou moins.");
        this.name =  aName;
    }

    private void setSigle(String aSigle) {
        this.sigle =  aSigle;
    }

    private void setRccm(String aRccm) {
        this.assertArgumentNotEmpty(aRccm, "Le RCCM de la société est réquis.");
        this.rccm = aRccm;
    }

    private void setContactInformation(ContactInformation aContactInformation) {
        this.assertArgumentNotNull(aContactInformation, "Les informations de contact sont réquises.");
        this.contactInformation = aContactInformation;
    }

    private void setNumberOfRepresentations(int aNumberOfRepresentations) {
        this.assertArgumentRange(aNumberOfRepresentations, 1, 100,
                "Le nombre de représentations doit être superieur à 1.");
        this.numberOfRepresentations = aNumberOfRepresentations;
    }

    private void setActivityArea(String anActivityArea) {
        this.assertArgumentNotEmpty(anActivityArea, "Le secteur d'activité est réquis.");
        this.activityArea =  anActivityArea;
    }

    private void setTaxSystem(TaxSystem aTaxSystem) {
        this.assertArgumentNotNull(aTaxSystem, "Le regime fiscal est obligatoire.");
        this.taxSystem = aTaxSystem;
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

    public ContactInformation contactInformation() {
        return contactInformation;
    }

    public int numberOfRepresentations() {
        return numberOfRepresentations;
    }

    public String activityArea() {
        return activityArea;
    }

    public TaxSystem taxSystem() {
        return taxSystem;
    }

    public boolean canCreateSite(long numberOfExistingSites) {
        return this.numberOfRepresentations > numberOfExistingSites;
    }

}
