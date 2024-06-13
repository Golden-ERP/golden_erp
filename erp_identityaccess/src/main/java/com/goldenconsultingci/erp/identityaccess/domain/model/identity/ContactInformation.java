package com.goldenconsultingci.erp.identityaccess.domain.model.identity;


import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;

public class ContactInformation
        extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;
    private Telephone primaryTelephone;
    private Telephone secondaryTelephone;
    private EmailAddress emailAddress;

    protected ContactInformation() {
        super();
    }

    public ContactInformation(
            Telephone aPrimaryTelephone,
            Telephone aSecondaryTelephone,
            EmailAddress anEmailAddress) {
        this();
        this.setPrimaryTelephone(aPrimaryTelephone);
        this.setSecondaryTelephone(aSecondaryTelephone);
        this.setEmailAddress(anEmailAddress);
    }

    public ContactInformation(ContactInformation aContactInformation) {
        this(
                aContactInformation.primaryTelephone(),
                aContactInformation.secondaryTelephone(),
                aContactInformation.emailAddress());
    }

    public ContactInformation changePrimaryTelephone(Telephone aPrimaryTelephone) {
        return new ContactInformation(
                aPrimaryTelephone,
                this.secondaryTelephone(),
                this.emailAddress());
    }

    public ContactInformation changeSecondaryTelephone(Telephone aSecondaryTelephone) {
        return new ContactInformation(
                this.primaryTelephone(),
                aSecondaryTelephone,
                this.emailAddress());
    }

    public ContactInformation changeEmailAddress(EmailAddress anEmailAddress) {
        return new ContactInformation(
                this.primaryTelephone(),
                this.secondaryTelephone(),
                anEmailAddress);
    }

    private void setPrimaryTelephone(Telephone aPrimaryTelephone) {
        this.assertArgumentNotNull(aPrimaryTelephone, "Le numéro de téléphone est réquis.");
        this.primaryTelephone = aPrimaryTelephone;
    }

    private void setSecondaryTelephone(Telephone aSecondaryTelephone) {
        this.secondaryTelephone = aSecondaryTelephone;
    }

    private void setEmailAddress(EmailAddress anEmailAddress) {
        this.assertArgumentNotNull(anEmailAddress, "L'adresse email est réquis.");
        this.emailAddress = anEmailAddress;
    }

    public Telephone primaryTelephone() {
        return primaryTelephone;
    }

    public Telephone secondaryTelephone() {
        return secondaryTelephone;
    }

    public EmailAddress emailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || !this.getClass().equals(anObject.getClass())) {
            return false;
        }
        ContactInformation typedObject = (ContactInformation) anObject;
        return this.primaryTelephone().equals(typedObject.primaryTelephone()) &&
                this.emailAddress().equals(typedObject.emailAddress()) &&
                ((this.secondaryTelephone() == null && typedObject.secondaryTelephone() == null) ||
                        (this.secondaryTelephone() != null && this.secondaryTelephone().equals(typedObject.secondaryTelephone())));
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (745183 * 136)
                + this.primaryTelephone().hashCode()
                + this.emailAddress().hashCode()
                + (this.secondaryTelephone() == null ? 0:this.secondaryTelephone().hashCode());
        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "primaryTelephone=" + primaryTelephone +
                ", secondaryTelephone=" + secondaryTelephone +
                ", emailAddress=" + emailAddress +
                '}';
    }
}
