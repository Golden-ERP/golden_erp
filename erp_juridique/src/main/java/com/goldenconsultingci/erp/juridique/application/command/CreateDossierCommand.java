package com.goldenconsultingci.erp.juridique.application.command;

import com.goldenconsultingci.erp.juridique.domain.model.EmergencyLevel;
import com.goldenconsultingci.erp.juridique.domain.model.RiskLevel;
import com.goldenconsultingci.erp.juridique.domain.model.Tiers;
import com.goldenconsultingci.erp.juridique.domain.model.TypeDossier;

import java.time.LocalDate;

public class CreateDossierCommand {
    private String reference;
    private String typeDossierRef;
    private long tiersId;
    private String emergencyLevel;
    private String riskLevel;
    private String direction;
    private LocalDate startDate;
    private LocalDate endDate;

    public CreateDossierCommand(String reference, String typeDossierRef, long tiersId, String emergencyLevel, String riskLevel, String direction, LocalDate startDate, LocalDate endDate) {
        this.reference = reference;
        this.typeDossierRef = typeDossierRef;
        this.tiersId = tiersId;
        this.emergencyLevel = emergencyLevel;
        this.riskLevel = riskLevel;
        this.direction = direction;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String reference() {
        return reference;
    }

    public String typeDossierRef() {
        return typeDossierRef;
    }

    public long tiersId() {
        return tiersId;
    }

    public String emergencyLevel() {
        return emergencyLevel;
    }

    public String riskLevel() {
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
}
