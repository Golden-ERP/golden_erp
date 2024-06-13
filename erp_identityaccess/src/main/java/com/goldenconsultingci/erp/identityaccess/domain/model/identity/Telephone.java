package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//@Embeddable
public class Telephone extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;

    private String number;

    protected Telephone() {
        super();
    }

    public Telephone(String aNumber) {
        this();
        this.setNumber(aNumber);
    }

    public Telephone(Telephone aTelephone) {
        this(aTelephone.number());
    }

    private void setNumber(String aNumber) {
        this.assertArgumentNotEmpty(aNumber, "Le numéro de téléphone est réquis.");
        this.number = aNumber;
    }

    public String number() {
        return this.number;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }

        if (anObject == null || !this.getClass().equals(anObject.getClass())) {
            return false;
        }

        Telephone typedObject = (Telephone) anObject;

        return this.number().equals(typedObject.number());
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (675109 * 469)
                + this.number().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "number='" + number + '\'' +
                '}';
    }
}
