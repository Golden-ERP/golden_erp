package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.regex.Pattern;

//@Embeddable
public class EmailAddress extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;
    private String address;

    protected EmailAddress() {
        super();
    }

    public EmailAddress(String anAddress) {
        this();
        this.setAddress(anAddress);
    }

    private void setAddress(String anAddress) {
        this.assertArgumentNotEmpty(anAddress, "Adresse email est réquis.");
        this.assertArgumentLength(anAddress, 1, 100, "Email doit comporter 100 caractères ou moins.");
        this.assertArgumentTrue(
                Pattern.matches("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*", anAddress),
                "Format adresse email est invalide.");
        this.address = anAddress;
    }

    public String address() {
        return this.address;
    }
}
