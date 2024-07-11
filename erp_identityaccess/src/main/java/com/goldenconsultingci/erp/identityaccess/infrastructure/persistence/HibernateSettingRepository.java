package com.goldenconsultingci.erp.identityaccess.infrastructure.persistence;

import com.goldenconsultingci.erp.common.persistence.hibernate.AbstractHibernateSession;
import com.goldenconsultingci.erp.identityaccess.domain.model.setting.Setting;
import com.goldenconsultingci.erp.identityaccess.domain.model.setting.SettingRepository;

import java.util.List;

public class HibernateSettingRepository
        extends AbstractHibernateSession implements SettingRepository {
    @Override
    public void add(Setting aSetting) {
        this.session().saveOrUpdate(aSetting);
    }

    @Override
    public Setting named(String aName) {
        return this.session().createQuery("from Setting _obj_ where _obj_.name = :name", Setting.class)
                .setParameter("name", aName)
                .uniqueResult();
    }

    @Override
    public List<Setting> findAll() {
        return this.session().createQuery("from Setting", Setting.class).getResultList();
    }

    @Override
    public void delete(Setting aSetting) {
        this.session().remove(aSetting);
    }
}
