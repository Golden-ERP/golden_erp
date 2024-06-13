package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public interface SocietyRepository {
    void save(Society aSociety);
    Society findSociety();

}
