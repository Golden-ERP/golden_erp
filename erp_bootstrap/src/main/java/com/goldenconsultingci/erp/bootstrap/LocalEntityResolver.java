package com.goldenconsultingci.erp.bootstrap;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class LocalEntityResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId.contains("spring-beans.xsd")) {
            InputStream is = getClass().getResourceAsStream("/schema/spring-beans.xsd");
            return new InputSource(is);
        } else if (systemId.contains("spring-tx.xsd")) {
            InputStream is = getClass().getResourceAsStream("/schema/spring-tx.xsd");
            return new InputSource(is);
        }
        else if (systemId.contains("spring-context.xsd")) {
            InputStream is = getClass().getResourceAsStream("/schema/spring-context.xsd");
            return new InputSource(is);
        }
        else if (systemId.contains("spring-aop.xsd")) {
            InputStream is = getClass().getResourceAsStream("/schema/spring-aop.xsd");
            return new InputSource(is);
        }
        return null;
    }


}
