package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Actor;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.Site;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.UserRepository;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateUserRepository
    extends AbstractHibernateSession implements UserRepository {
    @Override
    public void add(User anUser) {
        this.session().saveOrUpdate(anUser);
    }

    @Override
    public User userWithUsername(String anUsername) {
        Query query = this.session().createQuery(
                "from User _obj_ where _obj_.username = ?1");
        query.setParameter(1, anUsername);
        return (User) query.uniqueResult();
    }

    @Override
    public Collection<User> allUsers() {
        Query query = this.session().createQuery("from User");
        return query.list();
    }

    @Override
    public List<User> withRole(String aRoleName) {
        return null;
    }

    @Override
    public List<User> userInSite(String aSiteId) {
        return this.session().createQuery("from User u JOIN u.actor.site s WHERE s.siteId = ?1", User.class)
                .setParameter(1, aSiteId)
                .getResultList();

    }

    @Override
    public List<User> userInResponsibility(String aResponsibilityName) {
        return this.session().createQuery("from Actor a join a.responsibility r where r.name =?1", Actor.class)
                .setParameter(1, aResponsibilityName)
                .getResultStream()
                .map(Actor::user)
                .collect(Collectors.toList());
    }
}
