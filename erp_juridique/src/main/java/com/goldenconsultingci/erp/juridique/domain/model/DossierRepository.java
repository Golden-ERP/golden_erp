package com.goldenconsultingci.erp.juridique.domain.model;

import java.util.List;

public interface DossierRepository {
    void save(Dossier aDossier);
    Dossier ofId(DossierId anIdentity);
    List<Dossier> findAll(String siteId);
}
