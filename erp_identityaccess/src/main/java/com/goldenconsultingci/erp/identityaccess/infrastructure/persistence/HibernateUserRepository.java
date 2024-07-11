package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.UserRepository;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

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
}
