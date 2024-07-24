package com.goldenconsultingci.erp.bootstrap;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//@Configuration
public class XmlConfig {
    @Bean
    public XmlBeanDefinitionReader xmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.setResourceLoader(new PathMatchingResourcePatternResolver());
        reader.setEntityResolver(new LocalEntityResolver());
        return reader;
    }
}
