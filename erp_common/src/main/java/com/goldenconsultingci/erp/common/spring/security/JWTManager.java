package com.goldenconsultingci.erp.common.spring.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class JWTManager {

    private static final long TOKEN_EXPIRE_TIME = 24 * 60 * 60 * 1000; // 1H
    @Autowired
    private RSAPrivateKey privateKey;
    @Autowired
    private RSAPublicKey publicKey;

    public String create(String anUsername, List<String> roles, String resonsibility, String siteId) {
        final long now = System.currentTimeMillis();
        String token = JWT.create()
                .withAudience(anUsername)
                .withClaim("username", anUsername)
                .withClaim("siteId", siteId)
                .withClaim("responsibility", resonsibility)
                .withClaim("roles", roles)
                .withIssuedAt(new Date(now))
                .withExpiresAt(new Date(now + TOKEN_EXPIRE_TIME))
                .sign(Algorithm.RSA256(publicKey, privateKey));
        return token;
    }


}
