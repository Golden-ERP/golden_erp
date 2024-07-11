package com.goldenconsultingci.erp.juridique.domain.model;

import java.time.LocalDate;

public class Activity {
    private DossierId dossierId;
    private String stepId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private Status status;
}
