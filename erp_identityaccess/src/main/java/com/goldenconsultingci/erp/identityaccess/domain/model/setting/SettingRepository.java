package com.goldenconsultingci.erp.identityaccess.domain.model.setting;

import java.util.List;

public interface SettingRepository {
    void add(Setting aSetting);
    Setting named(String aName);
    List<Setting> findAll();
    void delete(Setting aSetting);
}
