package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import java.util.List;
import java.util.UUID;

public interface SiteRepository {
    void add(Site aSite);
    List<Site> findAll();
    Site ofId(String id);
    void remove(Site aSite);

    default
    public String nextIdentity() {
        return UUID.randomUUID().toString();
    }

    long count();

    Site named(String aSiteName);
}
