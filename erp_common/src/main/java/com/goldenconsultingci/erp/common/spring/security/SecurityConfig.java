package com.goldenconsultingci.erp.common.spring.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class SecurityConfig {

    private static final String keyStorePath= "jwt-keystore.jks";
    private static final String keyStorePassword = "golden";
    private static final String keyAlias = "jwt-sign-key";
    private static final String privateKeyPassPhrase = "golden";
    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .sessionManagement(sess-> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/**").permitAll())
                .oauth2ResourceServer(server ->
                    server.jwt(jwt ->
                            jwt.jwtAuthenticationConverter(getJwtAuthenticationConverter())));

        return http.build();
    }



    @Bean
    public KeyStore keyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(keyStorePath);
            keyStore.load(inputStream, keyStorePassword.toCharArray());
            return keyStore;
        } catch (KeyStoreException | CertificateException |IOException | NoSuchAlgorithmException e) {

        }

        throw new IllegalArgumentException("Unable to load keystore.");
    }

    @Bean
    public RSAPrivateKey rsaPrivateKey(KeyStore aKeyStore) {
        try {
            Key key = aKeyStore.getKey(this.keyAlias, this.privateKeyPassPhrase.toCharArray());
            if (key instanceof  RSAPrivateKey)  {
                return (RSAPrivateKey) key;
            }
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            //throw new IllegalArgumentException("unable to load rsa private key from keystore.");
        }

        throw new IllegalArgumentException("unable to load rsa private key");
    }

    @Bean
    public RSAPublicKey rsaPublicKey(KeyStore aKeyStore) {
        try {
            Certificate certificate = aKeyStore.getCertificate(keyAlias);
            PublicKey publicKey = certificate.getPublicKey();
            if (publicKey instanceof RSAPublicKey) {
                return (RSAPublicKey) publicKey;
            }
        } catch (KeyStoreException e) {
//            throw new RuntimeException(e);
        }

        throw new IllegalArgumentException("unable to load rsa public key");
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAPublicKey rsaPublicKey) {
        return NimbusJwtDecoder.withPublicKey(rsaPublicKey).build();
    }

    private JwtAuthenticationConverter getJwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter authorityConverter = new JwtGrantedAuthoritiesConverter();
        authorityConverter.setAuthorityPrefix("");
        authorityConverter.setAuthoritiesClaimName("role");
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(authorityConverter);
        return converter;
    }
}
