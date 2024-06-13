package com.goldenconsultingci.erp.identityaccess.domain;

import com.goldenconsultingci.erp.identityaccess.domain.model.identity.PasswordService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DomainRegistry implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static PasswordEncoder passwordEncoder() {
        return (PasswordEncoder) DomainRegistry.applicationContext.getBean("passwordEncoder");
    }

    public static PasswordService passwordService() {
        return (PasswordService) DomainRegistry.applicationContext.getBean("passwordService");
    }

    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (DomainRegistry.applicationContext == null) {
            DomainRegistry.applicationContext = applicationContext;
        }
    }
}
