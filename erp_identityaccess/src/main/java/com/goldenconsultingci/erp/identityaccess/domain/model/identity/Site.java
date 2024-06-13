package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Site extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String siteId;
    private String name;
    private SiteType type;
    private GeographicalAddress geographicalAddress;
    private Manager manager;
    private Set<Direction> directions;

    protected Site() {
        super();
        this.setDirections(new HashSet<>(0));
    }

    public Site(
            String anIdentity,
            String aSiteName,
            SiteType aType,
            GeographicalAddress aGeographicalAddress,
            Manager aManager) {
        this();
        this.setSiteId(anIdentity);
        this.setName(aSiteName);
        this.setType(aType);
        this.setGeographicalAddress(aGeographicalAddress);
        this.setManager(aManager);
    }

    private void setManager(Manager aManager) {
        this.assertArgumentNotNull(aManager, "Le manager su site est réquis.");
        this.manager = aManager;
    }

    private void setType(SiteType aType) {
        this.assertArgumentNotNull(aType, "Le type Bureau/Agence/Filliale est réquis.");
        this.type = aType;
    }

    private void setSiteId(String anIdentity) {
        this.assertArgumentNotEmpty(anIdentity, "L'Identifiant est réquis.");
        this.siteId = anIdentity;
    }

    private void setName(String aSiteName) {
        this.assertArgumentNotEmpty(aSiteName, "Le nom de du site est réquis.");
        this.assertArgumentLength(aSiteName, 1, 100,
                "Le nom du site/representaton doit comporter 100 caractères ou moins.");
        this.name = aSiteName;
    }

    private void setGeographicalAddress(GeographicalAddress aGeographicalAddress) {
        this.assertArgumentNotNull(aGeographicalAddress, "L'adresse geographique est réquis.");
        this.geographicalAddress = aGeographicalAddress;
    }

    private void setDirections(Set<Direction>  aDirections) {
        this.directions = aDirections;
    }
    public Manager manager() {
        return manager;
    }

    public String siteId() {
        return siteId;
    }

    public String name() {
        return name;
    }

    public SiteType type() {
        return type;
    }

    public Set<Direction> directions() {
        return this.directions;
    }

    public GeographicalAddress geographicalAddress() {
        return geographicalAddress;
    }

    public void addDirection(Direction aDirection) {
        this.directions().add(aDirection);
    }

    public void changeManager(Manager aManager) {
        this.setManager(aManager);
    }
}
