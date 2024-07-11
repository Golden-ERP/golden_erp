package com.goldenconsultingci.erp.juridique.domain.model;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.io.Serializable;

public class TypeDossier extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reference;
    private String type;

    protected TypeDossier() {
        super();
    }
    public TypeDossier(String aReference, String aType) {
        this();
        this.setReference(aReference);
        this.setType(aType);
    }

    private void setReference(String aReference) {
        this.assertArgumentNotEmpty(aReference, "Le référence est réquise.");
        this.reference = aReference;
    }

    private void setType(String aType) {
        this.assertArgumentNotEmpty(aType, "Le type de réquis.");
        this.type = aType;
    }

    public String reference() {
        return reference;
    }

    public String type() {
        return type;
    }
}
