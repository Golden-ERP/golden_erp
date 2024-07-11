package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.domain.DomainEvent;

import java.time.LocalDateTime;

public class CourrierImptuedEvent  implements DomainEvent {
    private CourrierId courrierId;
    private String shareHolder;
    private LocalDateTime occurredOn;

    public CourrierImptuedEvent(CourrierId anId, String shareHolder, LocalDateTime anOccuredOn) {
        this.courrierId = anId;
        this.shareHolder = shareHolder;
        this.occurredOn = anOccuredOn;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }
}
