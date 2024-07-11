package com.goldenconsultingci.erp.juridique.domain.model;

import java.util.List;

public interface TypeDossierRepository {
    void save(TypeDossier typeDossier);
    TypeDossier referenced(String aRef);
    List<TypeDossier> findAll();
}
