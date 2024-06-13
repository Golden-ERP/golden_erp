package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Department;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Direction;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.DirectionRepository;
import jakarta.persistence.NoResultException;

import java.util.List;

public class HibernateDirectionRepository
        extends AbstractHibernateSession implements DirectionRepository {
    @Override
    public void add(Direction aDirection) {
        this.session().saveOrUpdate(aDirection);
    }

    @Override
    public List<Direction> findAll() {
        return this.session()
                .createQuery("select d from Direction d", Direction.class)
                .getResultList();
    }

    @Override
    public Direction ofId(long anIdentity) {
        return null;
    }

    @Override
    public Direction DirectionNamed(String aDirectionName) {
        try {
            return this.session()
                    .createQuery("select d from Direction d where d.name = :name", Direction.class)
                    .setParameter("name", aDirectionName)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void delete(Direction aDirection) {
        this.session().remove(aDirection);
    }

    @Override
    public void saveDepartment(Department aDepartment) {
        this.session().saveOrUpdate(aDepartment);
    }

    @Override
    public Department DepartmentNamed(String aDepartmentName) {
        try {
            return this.session().createQuery("select d from Department d where d.name = :name", Department.class)
                    .setParameter("name", aDepartmentName)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
