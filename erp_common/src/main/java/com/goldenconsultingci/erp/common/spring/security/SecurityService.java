package com.goldenconsultingci.erp.common.spring.security;

import com.auth0.jwt.interfaces.Claim;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldenconsultingci.erp.common.ObjectSerializer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Iterator;
import java.util.Map;

public class SecurityService {
    private SecurityService() {

    }
    public static String currentUsername() {
        return stringValue("username");
    }

    public static String currentSite() {
        return stringValue("siteId");
    }

    private static String stringValue(String aKey) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            Map<String, Object> claims = jwt.getClaims();
            if (claims.containsKey(aKey)) {
                return String.valueOf(claims.get(aKey));
            }
        }

        throw new  IllegalStateException(aKey + "not found in the token.");
    }
}
