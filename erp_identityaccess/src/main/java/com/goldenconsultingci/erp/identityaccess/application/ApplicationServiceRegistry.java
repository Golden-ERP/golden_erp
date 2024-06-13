package com.goldenconsultingci.erp.identityaccess.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationServiceRegistry implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static IdentityApplicationService identityApplicationService() {
        return (IdentityApplicationService)
                ApplicationServiceRegistry
                        .applicationContext
                        .getBean("identityApplicationService");
    }
    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationServiceRegistry.applicationContext == null) {
            ApplicationServiceRegistry.applicationContext = applicationContext;
        }
    }
}
