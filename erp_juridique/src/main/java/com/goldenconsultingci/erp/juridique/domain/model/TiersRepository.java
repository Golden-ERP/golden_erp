package com.goldenconsultingci.erp.juridique.domain.model;

import java.util.List;

public interface TiersRepository {

    void add(Tiers aTiers);
    Tiers ofId(long id);
    List<Tiers> findAll();

}
