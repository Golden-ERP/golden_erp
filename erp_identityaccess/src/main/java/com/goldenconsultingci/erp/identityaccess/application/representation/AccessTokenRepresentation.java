package com.goldenconsultingci.erp.identityaccess.application.representation;

import lombok.Data;

import java.util.Objects;

@Data
public class AccessTokenRepresentation {

    private String accessToken;
    private String type;

    protected AccessTokenRepresentation() {
        super();
    }

    public AccessTokenRepresentation(String aToken, String aType) {
        super();
        Objects.requireNonNull(aToken);
        this.accessToken = aToken;
        this.type = aType;
    }
}
