package com.goldenconsultingci.erp.identityaccess.application.representation;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.*;

public class SiteRepresentation {
    private String siteId;
    private String name;
    private String type;
    private FullName managerName;
    private String managerEmailAddress;
    private String managerTelephone;
    private GeographicalAddress geographicalAddress;

    public SiteRepresentation(Site aSite) {
        super();
        this.initializer(aSite);
    }

    private void initializer(Site aSite) {
        this.name = aSite.name();
        this.type = aSite.type().name();
        this.siteId = aSite.siteId();
        this.geographicalAddress = aSite.geographicalAddress();
        this.managerName = aSite.manager().name();
        this.managerEmailAddress = aSite.manager().emailAddress().address();
        this.managerTelephone =  aSite.manager().telephone().number();
    }

    public String getSiteId() {
        return siteId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public GeographicalAddress getGeographicalAddress() {
        return geographicalAddress;
    }

    public FullName getManagerName() {
        return managerName;
    }

    public String getManagerEmailAddress() {
        return managerEmailAddress;
    }

    public String getManagerTelephone() {
        return managerTelephone;
    }
}
