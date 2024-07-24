package com.goldenconsultingci.erp.courier.application;


import com.goldenconsultingci.erp.common.spring.security.SecurityService;
import com.goldenconsultingci.erp.courier.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CourrierTx
public class CourrierApplicationService{
    @Autowired
    private CourrierRepository courrierRepository;
    @Autowired
    private EmployeeService employeeService;

    @CourrierTx
    public Courrier registerNewCourrier(RegisterNewCourrierCommand aCommand) {
        Courrier courrier = new Courrier(
                courrierRepository.nextIdentity(),
                CourrierType.valueOf(aCommand.type()),
                SecurityService.currentSite(),
                aCommand.courrierDate(),
                aCommand.registrationNumber(),
                aCommand.reference(),
                aCommand.arrivalDate(),
                aCommand.object(),
                CourrierState.SUBMITTED);
        this.courrierRepository.save(courrier);
        return courrier;
    }

    @CourrierTx
    public void imputCourrierToShareholder(ImputCourrierCommand aCommand) {
        String siteId = SecurityService.currentSite();
        Courrier courrier = this.nonNullCourrier(aCommand.courrierId());
        ShareHolder shareHolder = employeeService.employeeFromResponsibility(aCommand.role(), siteId);
//        Set<ShareHolder> shareHolders = Arrays.asList(aCommand.identities())
//                .stream()
//                .map(id -> employeeService.shareHolderFrom(id, siteId))
//                .collect(Collectors.toSet());
        courrier.imputeTo(
                shareHolder,
                String.join(";", aCommand.instructions()),
                aCommand.remark());
    }

    @Transactional
    public void attachFileToCourrier(String aCourrierId, String aFileName, byte[] aBytes) {

    }

//    @CourrierTx(readOnly = true)
    public List<Courrier> allCourriers(String aSiteId) {
        return this.courrierRepository.ofSite(aSiteId);
    }

    public List<Courrier> myCourriers() {
        return this.courrierRepository
                .courriersOfShareHolder(SecurityService.currentUsername());
    }

    @CourrierTx
    public Set<CourrierTaskRepresentation> tasksOfCourrier(String aCourrierId) {
        return this.nonNullCourrier(aCourrierId).allTasks()
                .stream()
                .map(CourrierTaskRepresentation::new)
                .collect(Collectors.toSet());

    }

    public Courrier findCourrier(String aCourrierId) {
        return this.courrierRepository.ofId(new CourrierId(aCourrierId));
    }

    @CourrierTx
    public void acknowledgeCourrier(String aCorrierId) {
        this.nonNullCourrier(aCorrierId)
                .acknowledge(SecurityService.currentUsername());
    }

    @CourrierTx
    public void removeCourrier(String aCourrierId) {
        Courrier courrier = this.findCourrier(aCourrierId);
        if (courrier != null) {
            if (!courrier.isSubmitted()) {
                throw new IllegalStateException("Courrier non supprimer.");
            }
            this.courrierRepository.delete(courrier);
        }
    }

    public List<Courrier> courriersAssignedToEmployee(String anUsername) {
        return this.courrierRepository.courriersOfShareHolder(anUsername);
    }

    private Courrier nonNullCourrier(String aCourrierId) {
        Courrier courrier = this.findCourrier(aCourrierId);
        if (courrier == null) {
            throw new IllegalArgumentException("Courrier introuvable.");
        }
        return courrier;
    }


}
