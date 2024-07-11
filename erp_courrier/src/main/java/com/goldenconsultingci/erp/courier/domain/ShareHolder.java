package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;

public class ShareHolder extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;
    private String role;
    private String identity;
    private String name;
    private String siteId;

    protected ShareHolder() {
        super();
    }

    public ShareHolder(
            String anIdentity,
            String aRoleName,
            String aName,
            String aSiteId) {
        this();
        this.setIdentity(anIdentity);
        this.setRole(aRoleName);
        this.setName(aName);
        this.setSiteId(aSiteId);

    }

    private void setIdentity(String anIdentity) {
        this.assertArgumentNotEmpty(anIdentity, "ID du porteur d'action est réquis.");
        this.identity = anIdentity;
    }

    public void setRole(String aRolaName) {
        this.assertArgumentNotEmpty(aRolaName, "Le role du porteur d'action est réquis.");
        this.role = aRolaName;
    }

    public void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le nom du proteur est réquis.");
        this.name = aName;
    }

    public void setSiteId(String siteId) {
        this.assertArgumentNotEmpty(siteId, "ID Site doit etre fourni.");
        this.siteId = siteId;
    }

    public String role() {
        return role;
    }

    public String identity() {
        return identity;
    }

    public String name() {
        return this.name;
    }

    public String siteId() {
        return siteId;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (75509 * 56)
                + this.identity().hashCode()
                + this.siteId().hashCode();

        return hashCodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        ShareHolder typedObject = (ShareHolder) obj;
        return this.identity().equals(typedObject.identity()) &&
                this.siteId().equals(typedObject.siteId()) ;
    }

    @Override
    public String toString() {
        return "ShareHolder{" +
                "role='" + role + '\'' +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", siteId='" + siteId + '\'' +
                '}';
    }
}
