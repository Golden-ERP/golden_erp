package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public enum TaxSystem {
    TE, RME, RSI, RNI;

    public static TaxSystem from(String aName) {
        for (TaxSystem t:TaxSystem.values()) {
            if (t.name().equalsIgnoreCase(aName)) {
                return t;
            }
        }

        throw new IllegalArgumentException("Ce regime fiscale n'est pas pris en charge. TE, RME, RSI, RNI");
    }
}
