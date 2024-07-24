package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;

public class ShareHolderId extends AssertionConcern implements Serializable {
    private String id;
    private String siteId;
    private ShareHolderId() {super();}
    private ShareHolderId(String aSiteId, String anId) {
        this();
        this.setSiteId(aSiteId);
        this.setId(anId);
    }

    private void setSiteId(String aSiteId) {
        this.assertArgumentNotEmpty(aSiteId, "ID du site doit être fourni.");
        this.siteId =  aSiteId;
    }

    private void setId(String anId) {
        this.assertArgumentNotEmpty(anId, "ID utilisateur doit être fourni.");
        this.id = anId;
    }

    public String id() {
        return id;
    }

    public String siteId() {
        return siteId;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (46776 * 67)
                + this.siteId().hashCode()
                + this.id().hashCode();
        return hashCodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }

        ShareHolderId typedObject = (ShareHolderId) obj;
        return this.id().equals(typedObject.id()) &&
                this.siteId().equals(typedObject.siteId());
    }

    @Override
    public String toString() {
        return "ShareHolderId{" +
                "id='" + id + '\'' +
                ", siteId='" + siteId + '\'' +
                '}';
    }
}
