package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public enum SiteType {
    BUREAU("BUREAUX DE REPRESENTATION"), AGENCES("AGENCES"), FILIALES("FILIALES");

    private final String name;

    private SiteType(String aName) {
        this.name = aName;
    }

    public SiteType from(String aName) {
        for (SiteType s: SiteType.values()) {
            if (s.name().equalsIgnoreCase(aName)) {
                return s;
            }
        }

        throw new IllegalArgumentException("Type de site nom supporté.");
    }


}
