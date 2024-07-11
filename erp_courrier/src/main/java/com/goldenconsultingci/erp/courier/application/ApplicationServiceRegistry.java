package com.goldenconsultingci.erp.courier.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationServiceRegistry implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    protected ApplicationServiceRegistry() {
        super();
    }

    public static CourrierApplicationService courrierApplicationService() {
        return (CourrierApplicationService) ApplicationServiceRegistry.applicationContext
                .getBean("courrierApplicationService");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationServiceRegistry.applicationContext == null) {
            ApplicationServiceRegistry.applicationContext = applicationContext;
        }
    }
}
