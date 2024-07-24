package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Responsibility;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.ResponsibilityRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class HibernateResponsibilityRepository
    extends AbstractHibernateSession implements ResponsibilityRepository {
    @Override
    public void add(Responsibility aResponsibility) {
        this.session().save(aResponsibility);
    }

    @Override
    public Set<Responsibility> findAll() {
        return this.session().createQuery("from Responsibility", Responsibility.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public void remove(Responsibility aResponsibility) {
        this.session().remove(aResponsibility);
    }

    @Override
    public Responsibility named(String aName) {
        return this.session().createQuery(
                "from Responsibility __obj__ where __obj__.name =:name",
                        Responsibility.class)
                .setParameter("name", aName)
                .uniqueResult();
    }
}
