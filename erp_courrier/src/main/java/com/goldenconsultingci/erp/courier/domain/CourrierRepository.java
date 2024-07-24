package com.goldenconsultingci.erp.courier.domain;

import java.util.List;
import java.util.UUID;

public interface CourrierRepository {

    void save(Courrier aCourrier);

    Courrier ofId(CourrierId anId);
    default CourrierId nextIdentity() {
        String randomString = UUID.randomUUID().toString().toUpperCase();
        String substring = randomString.substring(0, randomString.indexOf("-"));
        return new CourrierId(substring);
    }

    List<Courrier> ofSite(String aSiteId);

    void delete(Courrier courrier);

    List<Courrier> courriersOfShareHolder(String anUsername);
}
