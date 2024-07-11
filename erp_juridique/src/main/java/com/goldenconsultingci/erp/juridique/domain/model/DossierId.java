package com.goldenconsultingci.erp.juridique.domain.model;

import com.goldenconsultingci.erp.common.AssertionConcern;
import com.goldenconsultingci.erp.common.DateConverter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class DossierId extends AssertionConcern implements Serializable {
    private static final long serialVersionUID =  1L;

    private String id;
    private DossierId() {super();}

    private DossierId(String anId) {
        this();
        this.setId(anId);
    }
    public static DossierId generate() {
        LocalDate date = DateConverter.currentDate();
        String prefix = DateConverter.toString(date).replace("-", "");
        String random = UUID.randomUUID().toString().toUpperCase();
        String substr = random.substring(0, random.indexOf("-"));
        return new DossierId(prefix + substr);
    }
    public static DossierId from(String dossierId) {
        return new DossierId(dossierId);
    }

    private void setId(String anId) {
        this.assertArgumentNotEmpty(anId, "ID dossier est réquis.");
        this.id =  anId;
    }

    public String id() {
        return id;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (564 * 89)
                + this.id().hashCode();
        return hashCodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj ==null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        return this.id().equals(((DossierId) obj).id());
    }

    @Override
    public String toString() {
        return this.id();
    }
}
