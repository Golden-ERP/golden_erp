package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.util.Set;

public class Task extends Entity {

    private TaskId taskId;
    private CourrierId courrierId;
    private String instruction;
    private String remark;
    private Set<ShareHolder> shareHolders;

    private Task() {
        super();
    }

    public Task(
            TaskId aTaskId,
            CourrierId aCourrierId,
            String instruction,
            String remark,
            Set<ShareHolder> aShareHolder) {
        this();
        this.setTaskId(aTaskId);
        this.setCourrierId(aCourrierId);
        this.setShareHolders(aShareHolder);
        this.setInstruction(instruction);
        this.setRemark(remark);
    }

    private void setRemark(String remark) {
        this.remark = remark;
    }

    private void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    private void setTaskId(TaskId aTaskId) {
        this.assertArgumentNotNull(aTaskId, "TaskId est réquis.");
        this.taskId =  aTaskId;
    }

    private void setCourrierId(CourrierId aCourrierId) {
        this.assertArgumentNotNull(aCourrierId, "CourrierId est réquis.");
        this.courrierId =  aCourrierId;
    }

    private void setShareHolders(Set<ShareHolder> aShareHolders) {
        this.assertArgumentNotNull(aShareHolders, "Le destinataire est réquis.");
        this.shareHolders =  aShareHolders;
    }

//    private void setName(String aTaskName) {
//        this.assertArgumentNotEmpty(aTaskName, "Le nom de ta^che est réquise.");
//        this.name =  aTaskName;
//    }

    public String instruction() {
        return instruction;
    }

    public String remark() {
        return remark;
    }

    public Set<ShareHolder> shareHolders() {
        return shareHolders;
    }

    public TaskId taskId() {
        return taskId;
    }

    public CourrierId courrierId() {
        return courrierId;
    }
}
