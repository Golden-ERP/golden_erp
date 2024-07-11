package com.goldenconsultingci.erp.juridique.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StepDossier {
    private DossierId dossierId;
    private String siteId;
    private String stepId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private Status status;
    private List<Activity> activities;

    protected StepDossier() {
        super();
        this.setActivities(new ArrayList<>(0));
    }

    private void setActivities(ArrayList<Activity> activities) {
        this.activities =  activities;
    }

    public StepDossier(
            String aStepId,
            DossierId aDossierId,
            String siteId,
            String aName,
            LocalDate startDate,
            LocalDate endDate,
            Status aStatus) {

    }
}
