package com.goldenconsultingci.erp.common.domain;


public class ConcurrencySafeEntity extends Entity {

    private static final long serialVersionUID = 1L;
    private int concurrencyVersion;

    protected ConcurrencySafeEntity() {
        super();
    }

    public int concurrencyVersion() {
        return this.concurrencyVersion;
    }

    protected void setConcurrencyVersion(int aVersion) {
        this.concurrencyVersion =  aVersion;
    }
}
