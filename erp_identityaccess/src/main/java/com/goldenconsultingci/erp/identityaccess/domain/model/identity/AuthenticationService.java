package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.AssertionConcern;
import com.goldenconsultingci.erp.common.spring.security.JWTManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService extends AssertionConcern {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private JWTManager jwtManager;


    public AuthenticationService(
            PasswordEncoder passwordEncoder,
            UserRepository userRepository,
            JWTManager jwtManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtManager = jwtManager;
    }

    public String authenticate(String anUsername, String aPassword) {
        this.assertArgumentNotEmpty(anUsername, "Le nom d'utilisateur est réquis.");
        this.assertArgumentNotEmpty(aPassword, "Le mot de passe est réquis.");
        String token = null;
        User user = this.userRepository.userWithUsername(anUsername);
        if (user != null) {
            if (this.passwordEncoder.matches(aPassword, user.password())) {
                if (user.isActive() && user.site() != null) {
                    //UserDescriptor descriptor = user.descriptor();
//                    Map<String, Object> claims = new HashMap<>();
//                    claims.put("username", user.username());
//                    claims.put("siteName", user.site().name());
//                    claims.put("siteId", user.site().siteId());
//                    claims.put("roles", Arrays.asList("Assitante"));
                    token = jwtManager.create(user.username(), "", user.site().name(), user.site().siteId());
//                    token = jwtManager.create(claims);
                }
            }
        }
        return token;
    }
}
