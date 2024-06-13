package com.goldenconsultingci.erp.identityaccess.domain.model.identity;


import com.goldenconsultingci.erp.common.AssertionConcern;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserId extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    protected UserId() {
        super();
    }

    public UserId(String anId) {
       this();
       this.setId(anId);
    }


    public String id() {
        return id;
    }

    private void setId(String anId) {
        this.assertArgumentNotEmpty(anId, "ID utilisateur est réquis.");
        this.id = anId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }

        UserId typedOject = (UserId) obj;
        return this.id().equals(typedOject.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.id();
    }
}
