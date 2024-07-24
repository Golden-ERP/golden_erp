package com.goldenconsultingci.erp.bootstrap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CustomEntityResolverConfig {
    @Bean
    public static BeanFactoryPostProcessor entityResolverConfigurer() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((org.springframework.beans.factory.support.BeanDefinitionRegistry) beanFactory);
                reader.setEntityResolver(new LocalEntityResolver());
            }
        };
    }
}
