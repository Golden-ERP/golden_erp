package com.goldenconsultingci.erp.courier.application;

import com.goldenconsultingci.erp.common.DateConverter;
import com.goldenconsultingci.erp.courier.domain.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
public class CourrierRepresentation {
    private String courrierId;
    private String type;
    private String siteId;
    private String courrierDate;
    private String registrationNumber;
    private String reference;
    private String arrivalDate;
    private String object;
    private String state;
    private String createdDate;
    private Set<Acknowledgment> acknowledgments;
    private String attachedFilename;

    public CourrierRepresentation(Courrier aCourrier) {
        this.initialize(aCourrier);
    }

    private void initialize(Courrier aCourrier) {
        this.courrierId = aCourrier.courrierId().id();
        this.type = aCourrier.type().name();
        this.courrierDate = DateConverter.toString(aCourrier.courrierDate());
        this.arrivalDate = DateConverter.toString(aCourrier.arrivalDate());
        this.reference = aCourrier.reference();
        this.object = aCourrier.object();
        this.createdDate = DateConverter.toString(aCourrier.createdDate());
        this.state = aCourrier.state().name();
        this.registrationNumber =  aCourrier.registrationNumber();
        this.createdDate = DateConverter.toString(aCourrier.createdDate());
        this.siteId = aCourrier.siteId();
        this.acknowledgments =  aCourrier.acknowledgments();
    }
}