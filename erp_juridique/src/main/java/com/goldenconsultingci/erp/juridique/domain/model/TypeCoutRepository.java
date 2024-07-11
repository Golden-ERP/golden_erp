package com.goldenconsultingci.erp.juridique.domain.model;

import java.util.List;

public interface TypeCoutRepository {
    void save(TypeCout typeCout);
    TypeCout referenced(String aRef);
    List<TypeCout> findAll();
}
