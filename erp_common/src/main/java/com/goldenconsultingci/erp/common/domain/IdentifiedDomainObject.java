package com.goldenconsultingci.erp.common.domain;


import com.goldenconsultingci.erp.common.AssertionConcern;

import java.io.Serializable;


public class IdentifiedDomainObject extends AssertionConcern implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    protected IdentifiedDomainObject() {
        super();
        this.setId(-1);
    }

    private void setId(long anId) {
        this.id = anId;
    }

    protected long id() {
        return this.id;
    }
}
