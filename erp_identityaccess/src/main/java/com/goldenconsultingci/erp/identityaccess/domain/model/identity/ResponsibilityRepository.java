package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import java.util.Set;

public interface ResponsibilityRepository {
    void add(Responsibility aResponsibility);
    Set<Responsibility> findAll();
    void remove(Responsibility aResponsibility);
    Responsibility named(String aName);
}
