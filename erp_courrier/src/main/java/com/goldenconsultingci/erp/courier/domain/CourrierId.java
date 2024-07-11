package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;

public class CourrierId extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private CourrierId() {
        super();
    }

    public CourrierId(String anId) {
        this();
        this.setId(anId);
    }

    public CourrierId(CourrierId aCourrierId) {
        this(aCourrierId.id());
    }

    private void setId(String anId) {
        this.assertArgumentNotEmpty(anId, "ID est requis.");
        this.id = anId;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (76487 * 34)
                + this.id().hashCode();
        return hashCodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        CourrierId typedObject = (CourrierId) obj;
        return this.id().equals(((CourrierId) obj).id());
    }

    @Override
    public String toString() {
        return this.id();
    }

    public String id() {
        return id;
    }
}
