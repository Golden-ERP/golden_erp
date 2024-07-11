package com.goldenconsultingci.erp.common.domain;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime occurredOn();
}
