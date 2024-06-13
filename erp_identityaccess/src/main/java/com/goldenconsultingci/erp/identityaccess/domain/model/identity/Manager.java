package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;

public class Manager extends AssertionConcern implements Serializable {
    private FullName name;
    private Telephone telephone;
    private EmailAddress emailAddress;

    protected Manager() {
        super();
    }

    public Manager(Manager aManager) {
        this(
                aManager.name(),
                aManager.telephone(),
                aManager.emailAddress());
    }

    public Manager(FullName aName, Telephone aTelephone, EmailAddress anEmail) {
        this();
        this.setName(aName);
        this.setTelephone(aTelephone);
        this.setEmailAddress(anEmail);
    }

    private void setName(FullName aName) {
        this.assertArgumentNotNull(aName, "Le nom du responsable est réquis.");
        this.name = aName;
    }

    private void setTelephone(Telephone aTelephone) {
        this.assertArgumentNotNull(aTelephone, "Telephone du responsable  est requis.");
        this.telephone = aTelephone;
    }

    private void setEmailAddress(EmailAddress anEmail) {
        this.assertArgumentNotNull(anEmail, "Adresse email du responsable est requis.");
        this.emailAddress = anEmail;
    }

    public FullName name() {
        return name;
    }

    public Telephone telephone() {
        return telephone;
    }

    public EmailAddress emailAddress() {
        return this.emailAddress;
    }



    @Override
    public String toString() {
        return "Manager{" +
                "name=" + name() +
                ", telephone=" + telephone() +
                ", email=" + emailAddress() +
                '}';
    }
}
