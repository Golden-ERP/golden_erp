package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.DateConverter;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Acknowledgment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String actor;
    private LocalDateTime date;

    protected Acknowledgment() {super();}

    public Acknowledgment(String anActor) {
        this();
        this.setActor(anActor);
        this.setDate(DateConverter.currentDatetime());
    }

    private void setDate(LocalDateTime aDate) {
        this.date = aDate;
    }

    private void setActor(String anActor) {
        this.actor = anActor;
    }

    public String getActor() {
        return actor;
    }

    public LocalDateTime getDate() {
        return date;
    }


    @Override
    public int hashCode() {
        int hashCodeValiue =
                + (89754 * 23)
                + this.getActor().hashCode();
        return hashCodeValiue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        return this.getActor().equals(((Acknowledgment) obj).getActor());
    }

    @Override
    public String toString() {
        return "Acknowledgment{" +
                "actor='" + actor + '\'' +
                ", date=" + date +
                '}';
    }
}
