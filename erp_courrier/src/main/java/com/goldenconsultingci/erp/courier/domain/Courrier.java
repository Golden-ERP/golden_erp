package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Courrier extends Entity {

    private CourrierId courrierId;
    private CourrierType type;
    private String siteId;
    private LocalDate courrierDate;
    private String registrationNumber;
    private String reference;
    private LocalDate arrivalDate;
    private String object;
    private CourrierState state;
    private LocalDateTime createdDate;
    private String attachedFilename;
    private Set<Task> tasks;
    private Set<Acknowledgment> acknowledgments;

    private Courrier() {
        super();
        this.setTasks(new HashSet<>(0));
        this.setAcknowledgments(new HashSet<>(0));
    }

    public Courrier(
            CourrierId aCourrierId,
            CourrierType aType,
            String aSiteId,
            LocalDate aCourrierDate,
            String aRegistrationNumber,
            String aReference,
            LocalDate anArrivalDate,
            String anObject,
            CourrierState aState) {
        this();
        this.setCourrierId(aCourrierId);
        this.setType(aType);
        this.setCourrierDate(aCourrierDate);
        this.setRegistrationNumber(aRegistrationNumber);
        this.setArrivalDate(anArrivalDate);
        this.setReference(aReference);
        this.setObject(anObject);
        this.setState(aState);
        this.setSiteId(aSiteId);
        this.setCreatedDate(LocalDateTime.now());
    }

    private void setSiteId(String aSiteId) {
        this.assertArgumentNotEmpty(aSiteId, "ID su site est réquis.");
        this.siteId =  aSiteId;
    }

    public void setCourrierDate(LocalDate courrierDate) {
        this.assertArgumentNotNull(courrierDate, "La date su courrier doit être fourni.");
        this.courrierDate = courrierDate;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.assertArgumentNotEmpty(registrationNumber, "Le numéro d'enregistrement est réquis.");
        this.registrationNumber = registrationNumber;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.assertArgumentNotNull(arrivalDate, "La date d'arrivé doit être fourni.");
        this.arrivalDate = arrivalDate;
    }

    private void setCourrierId(CourrierId aCourrierId) {
        this.assertArgumentNotNull(aCourrierId, "CourrierId est réquis.");
        this.courrierId = aCourrierId;
    }

    private void setType(CourrierType aType) {
        this.assertArgumentNotNull(aType, "Le type doit être indiqué.");
        this.type = aType;
    }

    private void setReference(String aReference) {
        this.reference = aReference;
    }

    private void setObject(String anObject) {
        this.assertArgumentNotEmpty(anObject, "L'object du courrier est réquis.");
        this.object = anObject;
    }


    private void setState(CourrierState status) {
        this.state = status;
    }

    private void setCreatedDate(LocalDateTime aDate) {
        this.createdDate = aDate;
    }


    private void setAttachedFilename(String attachedFilename) {
        this.attachedFilename = attachedFilename;
    }


    public CourrierId courrierId() {
        return courrierId;
    }

    public CourrierType type() {
        return type;
    }

    public String reference() {
        return reference;
    }

    public String object() {
        return object;
    }

    public CourrierState state() {
        return state;
    }

    public LocalDateTime createdDate() {
        return createdDate;
    }

    public String attachedFilename() {
        return attachedFilename;
    }

    public LocalDate courrierDate() {
        return courrierDate;
    }

    public String registrationNumber() {
        return registrationNumber;
    }

    public LocalDate arrivalDate() {
        return arrivalDate;
    }

    public String siteId() {
        return siteId;
    }

    public void submit() {
        this.setState(CourrierState.SUBMITTED);
    }

    public void imputeTo(
            Set<ShareHolder>  aSHareHolders,
            String instructionsList,
            String aRemark) {
//        this.assertArgumentNotNull(shareHolder, "Le porteur d'action ne doit pas être null.");
//        this.assertArgumentEquals(this.siteId(), aSHareHolder.siteId(), "Mauvais porteur d'action selectionné.");
        Task task = new Task(
                TaskId.generate(),
                this.courrierId(),
                instructionsList,
                aRemark,
                aSHareHolders);
        this.tasks().add(task);
        if (!this.state().isInImputed()) {
            this.setState(CourrierState.IMPUTED);
        }
    }
    private void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    private Set<Task> tasks() {
        return this.tasks;
    }

    public Set<Task> allTasks() {
        return Collections.unmodifiableSet(this.tasks());
    }

    private void setAcknowledgments(Set<Acknowledgment> acknowledgments) {
        this.acknowledgments = acknowledgments;
    }

    public Set<Acknowledgment> acknowledgments() {
        return acknowledgments;
    }

    public void acknowledge(String anIdentity) {
        Optional<ShareHolder> shareHolder = this.tasks().stream()
                .flatMap(task -> task.shareHolders().stream())
                .filter(s -> s.identity().equals(anIdentity))
                .findFirst();

        if (shareHolder.isPresent()) {
            ShareHolder s = shareHolder.get();
            this.acknowledgments()
                    .add(new Acknowledgment(s.name()));
        }
    }

    public boolean isSubmitted() {
        return this.state().isInSubmitted();
    }
}
