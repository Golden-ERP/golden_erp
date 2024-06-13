package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import java.util.List;

public interface DirectionRepository {
    void add(Direction aDirection);
    List<Direction> findAll();
    Direction ofId(long anIdentity);
    Direction DirectionNamed(String aDirectionName);
    void delete(Direction aDirection);
    void saveDepartment(Department aDepartment);
    Department DepartmentNamed(String aDepartmentName);
}
