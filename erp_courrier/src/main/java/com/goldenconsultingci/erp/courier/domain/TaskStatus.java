package com.goldenconsultingci.erp.courier.domain;

public enum TaskStatus {

    PENDING("En cours") {
        @Override
        public boolean isPending() {
            return true;
        }
    },
    COMPLETED("Terminé") {
        @Override
        public boolean isCompleted() {
            return true;
        }
    };


    public boolean isPending() {
        return false;
    }

    public boolean isCompleted() {
        return false;
    }

    private final String name;
    private TaskStatus(String aName) {
        this.name = aName;
    }
}
