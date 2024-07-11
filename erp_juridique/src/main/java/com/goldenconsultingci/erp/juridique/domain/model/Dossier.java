package com.goldenconsultingci.erp.juridique.domain.model;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dossier extends Entity {

    private DossierId dossierId;
    private String siteId;
    private String reference;
    private TypeDossier type;
    private Tiers tiers;
    private EmergencyLevel emergencyLevel;
    private RiskLevel riskLevel;
    private String direction;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    // Attached file à demander si les fichiers ont des descriptions
    private List<StepDossier> steps;

    private Dossier() {
        super();
        this.setSteps(new ArrayList<>(0));
    }

    public void assignManager() {}

    public Dossier(
            DossierId anId,
            String siteId,
            TypeDossier aType,
            Tiers aTiers,
            EmergencyLevel anEmergrncyLevel,
            RiskLevel aRiskLEvel,
            String aDirection,
            LocalDate startDate,
            LocalDate endDate,
            Status aStatus) {
        this();
        this.setDossierId(anId);
        this.setSiteId(siteId);
        this.setType(aType);
        this.setTiers(aTiers);
        this.setEmergencyLevel(anEmergrncyLevel);
        this.setRiskLevel(aRiskLEvel);
        this.setDirection(aDirection);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setStatus(aStatus);
    }

    private void setSiteId(String siteId) {
        this.siteId =  siteId;
    }

    public void setDossierId(DossierId dossierId) {

        this.dossierId = dossierId;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setType(TypeDossier type) {
        this.type = type;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
    }

    public void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSteps(List<StepDossier> steps) {
        this.steps = steps;
    }


    public DossierId dossierId() {
        return dossierId;
    }

    public String reference() {
        return reference;
    }

    public TypeDossier type() {
        return type;
    }

    public Tiers tiers() {
        return tiers;
    }

    public EmergencyLevel emergencyLevel() {
        return emergencyLevel;
    }

    public RiskLevel riskLevel() {
        return riskLevel;
    }

    public String direction() {
        return direction;
    }

    public LocalDate startDate() {
        return startDate;
    }

    public LocalDate endDate() {
        return endDate;
    }

    public Status status() {
        return status;
    }

    public List<StepDossier> steps() {
        return steps;
    }

    public String siteId() {
        return siteId;
    }

    public void addStep(String stepId, String stepName, LocalDate aStart, LocalDate anEnd) {
        StepDossier stepDossier = new StepDossier(
                stepId,
                this.dossierId(),
                this.siteId(),
                stepName,
                startDate,
                endDate,
                Status.EN_COURS);
        this.steps().add(stepDossier);
    }

}
