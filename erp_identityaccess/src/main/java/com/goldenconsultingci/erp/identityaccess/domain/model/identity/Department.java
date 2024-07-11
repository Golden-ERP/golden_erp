package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.io.Serializable;

public class
Department extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    protected Department() {
        super();
    }

    public Department(String aName) {
        this();
        this.setName(aName);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le nom est réquis.");
        this.assertArgumentLength(aName, 1, 100, "Le nom doit comporter 100 caratère ou moins.");
        this.name = aName;
    }


    public String name() {
        return name;
    }

}
