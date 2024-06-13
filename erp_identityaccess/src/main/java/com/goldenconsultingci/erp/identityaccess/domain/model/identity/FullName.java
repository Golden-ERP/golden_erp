package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//@Embeddable
public class FullName extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;

    protected FullName() {
        super();
    }

    public FullName(String aFirstName, String aLastName) {
        this();
        this.setFirstName(aFirstName);
        this.setLastName(aLastName);
    }

    private void setFirstName(String aFirstName) {
        this.assertArgumentNotEmpty(aFirstName, "Le nom est réquis");
        this.assertArgumentLength(aFirstName, 1, 20, "Le nom doit comporter 20 caractères ou moins.");
        this.firstName =  aFirstName;
    }

    private void setLastName(String aLastName) {
        this.assertArgumentNotEmpty(aLastName, "Le prénoms est réquis.");
        this.lastName = aLastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String asFormatted() {
        return this.firstName() + " " + this.lastName();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || !this.getClass().equals(anObject.getClass())) {
            return false;
        }

        FullName typedObject = (FullName) anObject;

        return this.firstName().equals(typedObject.firstName()) &&
                this.lastName().equals(typedObject.lastName());
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (754102 * 264)
                + this.firstName().hashCode()
                + this.lastName().hashCode();
        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
