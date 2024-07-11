package com.goldenconsultingci.erp.courier.domain;

import java.util.UUID;

public class TaskId {
    private String id;

    protected TaskId() {
        super();
    }

    public TaskId(String anId) {
        this.id = anId;
    }
    public static TaskId generate() {
        return new TaskId(UUID.randomUUID().toString());
    }

    public String id() {
        return id;
    }
}
