package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;
import java.util.Objects;

public class Destinataire extends AssertionConcern {
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;

    private Destinataire()  {
        super();
    }

    public Destinataire(String aFirstName, String aLastName, String anUsername, String anEmailAddress)  {
        this();
        this.setFirstName(aFirstName);
        this.setLastName(aLastName);
        this.setUsername(anUsername);
        this.setEmailAddress(anEmailAddress);
    }

    private void setLastName(String aLastName) {
        if (aLastName != null) {
            this.assertArgumentLength(aLastName, 50,
                    "Le prénom  doit comprter 50 caractères ou moins.");
        }
        this.lastName = aLastName;
    }

    private void setFirstName(String aFirstName) {
        if (aFirstName != null) {
            this.assertArgumentLength(aFirstName, 50,
                    "Le nom  doit comprter 50 caractères ou moins.");
        }
        this.firstName = aFirstName;
    }

    private void setUsername(String anUsername) {
        this.assertArgumentNotEmpty(anUsername, "Le nom d'utilisateur doit être fourni.");
        this.assertArgumentLength(anUsername, 50,
                "Le nom d'utilisateur doit comprter 50 caractères ou moins.");
        this.username = anUsername;
    }

    private void setEmailAddress(String anEmailAddress) {
        if (anEmailAddress != null) {
            this.assertArgumentLength(anEmailAddress, 100,
                    "L'adresse email doit comporter 100 caratères ou moins");
        }
        this.emailAddress = anEmailAddress;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (57556 * 56)
                + this.username().hashCode();
        return hashCodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        Destinataire typedObject = (Destinataire) obj;
        return this.username().equals(typedObject.username());
    }
    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String username() {
        return username;
    }

    public String emailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Destinataire{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

