package com.goldenconsultingci.erp.juridique.application;

import com.goldenconsultingci.erp.common.spring.security.SecurityService;
import com.goldenconsultingci.erp.juridique.application.command.CreateDossierCommand;
import com.goldenconsultingci.erp.juridique.domain.model.*;

public class DossierApplicationService {
    private TypeCoutRepository typeCoutRepository;
    private TypeDossierRepository typeDossierRepository;
    private TiersRepository tiersRepository;
    private DossierRepository dossierRepository;

    public Dossier createDossier(CreateDossierCommand aCommand) {
        Dossier dossier = new Dossier(
                DossierId.generate(),
                SecurityService.currentSite(),
                typeDossierRepository.referenced(aCommand.typeDossierRef()),
                this.tiersRepository.ofId(aCommand.tiersId()),
                EmergencyLevel.valueOf(aCommand.emergencyLevel()),
                RiskLevel.valueOf(aCommand.riskLevel()),
                aCommand.direction(),
                aCommand.startDate(),
                aCommand.endDate(),
                Status.EN_COURS);

        this.dossierRepository.save(dossier);
        return dossier;
    }

    public void assignResponsableToDossier(String aDossierId) {}

    public Dossier findDossier(String dossierId) {
        return this.dossierRepository.ofId(DossierId.from(dossierId));
    }

    private Dossier nonNullDossier(String aDossierId) {
        Dossier dossier = this.findDossier(aDossierId);
        if (dossier == null) {
            throw new IllegalArgumentException("Dossier introuvable.");
        }

        return dossier;
    }
}
