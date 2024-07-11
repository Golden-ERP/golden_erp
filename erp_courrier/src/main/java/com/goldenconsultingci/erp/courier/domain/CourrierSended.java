package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.domain.DomainEvent;

import java.time.LocalDateTime;

public class CourrierSended implements DomainEvent {
    private CourrierId courrierId;
    private LocalDateTime occurredOn;

    @Override
    public LocalDateTime occurredOn() {
        return null;
    }
}
