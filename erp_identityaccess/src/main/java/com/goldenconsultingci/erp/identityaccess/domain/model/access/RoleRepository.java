package com.goldenconsultingci.erp.identityaccess.domain.model.access;

import java.util.List;

public interface RoleRepository {

    void add(Role aRole);
    Role ofId(long id);
    List<Role> findAll();
    void remove(Role aRole);
}
