package com.goldenconsultingci.erp.courier.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.courier.domain.Courrier;
import com.goldenconsultingci.erp.courier.domain.CourrierId;
import com.goldenconsultingci.erp.courier.domain.CourrierRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateCorurrierRepository implements CourrierRepository {

    private SessionFactory sessionFactory;

    public HibernateCorurrierRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Courrier aCourrier) {
        this.session().saveOrUpdate(aCourrier);
    }

    @Override
    public Courrier ofId(CourrierId anId) {
        Query query = this.session().createQuery("select c from Courrier c where c.courrierId = :courrierId");
        query.setParameter("courrierId", anId);
        return(Courrier) query.uniqueResult();
    }

    @Override
    public List<Courrier> ofSite(String aSiteId) {
        return this.session()
                .createQuery("from Courrier _obj_ where _obj_.siteId = ?1 order by _obj_.createdDate desc",
                        Courrier.class)
                .setParameter(1, aSiteId)
                .getResultList();
    }

    @Override
    public void delete(Courrier courrier) {
        this.session().remove(courrier);
    }


    private Session session() {
        return this.sessionFactory.getCurrentSession();
    }
}
