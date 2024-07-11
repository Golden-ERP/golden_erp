package com.goldenconsultingci.erp.courier.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DomainRegistry implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (DomainRegistry.applicationContext == null) {
            DomainRegistry.applicationContext = applicationContext;
        }
    }
}
