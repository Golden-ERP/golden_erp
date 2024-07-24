package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Department;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Direction;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.DirectionRepository;

import java.util.List;

public class MongoDirectionRepository implements DirectionRepository {
    @Override
    public void add(Direction aDirection) {

    }

    @Override
    public List<Direction> findAll() {
        return null;
    }

    @Override
    public Direction ofId(long anIdentity) {
        return null;
    }

    @Override
    public Direction DirectionNamed(String aDirectionName) {
        return null;
    }

    @Override
    public void delete(Direction aDirection) {

    }

    @Override
    public void saveDepartment(Department aDepartment) {

    }

    @Override
    public Department DepartmentNamed(String aDepartmentName) {
        return null;
    }
}
