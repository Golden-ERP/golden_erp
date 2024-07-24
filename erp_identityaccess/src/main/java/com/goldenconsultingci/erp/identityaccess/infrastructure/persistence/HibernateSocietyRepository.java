package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Society;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.SocietyRepository;
import jakarta.persistence.NoResultException;

public class HibernateSocietyRepository
    extends AbstractHibernateSession implements SocietyRepository {
    @Override
    public void save(Society aSociety) {
        this.session().saveOrUpdate(aSociety);
    }

    @Override
    public Society findSociety() {
        try {
            return this.session().createQuery("select t from Society t", Society.class)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }

    @Override
    public long count() {
        return this.session()
                .createQuery("select count(s) from Society s", Long.class)
                .getSingleResult();
    }
}
