package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.RoleRepository;

import java.util.List;

public class HibernateRoleRepository
    extends AbstractHibernateSession implements RoleRepository {
    @Override
    public void add(Role aRole) {
        this.session().saveOrUpdate(aRole);
    }

    @Override
    public Role ofId(long id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return this.session().createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public void remove(Role aRole) {
    }

    @Override
    public Role roleNamed(String aRoleName) {
        return this.session().createQuery("from  Role r where r.name = :name", Role.class)
                .setParameter("name", aRoleName)
                .uniqueResult();

    }
}
