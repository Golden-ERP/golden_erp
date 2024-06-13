package com.goldenconsultingci.erp.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@Import({com.goldenconsultingci.erp.common.spring.security.SecurityConfig.class})
@ComponentScan(basePackages = {"com.goldenconsultingci.erp.identityaccess.presentation"})
@ImportResource({"classpath:applicationContext-common.xml",
        "classpath:applicationContext-identityaccess.xml",
        "classpath:applicationContext-identityaccess-application.xml"
    })
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class BootstrapApplication {
    public static void main( String[] args ) {
        SpringApplication.run(BootstrapApplication.class, args);
    }
}
