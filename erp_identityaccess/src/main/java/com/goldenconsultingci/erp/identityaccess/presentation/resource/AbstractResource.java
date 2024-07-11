package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.common.ObjectSerializer;
import com.goldenconsultingci.erp.common.domain.Entity;
import com.goldenconsultingci.erp.identityaccess.application.ApplicationServiceRegistry;
import com.goldenconsultingci.erp.identityaccess.application.IdentityApplicationService;
import com.goldenconsultingci.erp.identityaccess.application.SettingApplicationService;

public class AbstractResource {
    protected IdentityApplicationService identityApplicationService() {
        return ApplicationServiceRegistry.identityApplicationService();
    }

    protected SettingApplicationService settingApplicationService() {
        return ApplicationServiceRegistry.settingApplicationService();
    }

    protected String serialize(Object anObject) {
        return ObjectSerializer.instance().serialize(anObject);
    }
}
