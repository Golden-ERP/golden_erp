package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Site;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.SiteRepository;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

@Slf4j
public class HibernateSiteRepository
    extends AbstractHibernateSession implements SiteRepository {


    @Override
    public void add(Site aSite) {
        try {
            this.session().saveOrUpdate(aSite);
            System.out.println(aSite.siteId());
        } catch (ConstraintViolationException ex) {
            log.info("[INFO] Site nom enrégistré");
        }
    }

    @Override
    public List<Site> findAll() {
        return this.session().createQuery("select s from Site s", Site.class)
                .getResultList();
    }

    @Override
    public Site ofId(String id) {
        try {
            return this.session().createQuery("select s from Site s where s.siteId = :id", Site.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return  null;
        }
    }

    @Override
    public void remove(Site aSite) {

    }

    @Override
    public long count() {
        return this.session()
                .createQuery("select count(s) from Site s", Long.class)
                .getSingleResult();
    }

    @Override
    public Site named(String aSiteName) {
        return null;
    }
}
