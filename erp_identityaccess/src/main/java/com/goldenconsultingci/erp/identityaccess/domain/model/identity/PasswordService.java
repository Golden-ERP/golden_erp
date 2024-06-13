package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

public class PasswordService {

    public boolean isWeak(String aPlainTextPassword) {
        return true;
    }

    public  boolean isTrong(String aPlainTextPassword) {
        return true;
    }


    public String generateStrongPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
