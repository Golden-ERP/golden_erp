package com.goldenconsultingci.erp.courier.domain;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.util.Set;

public class Task extends Entity {

    private TaskId taskId;
    private CourrierId courrierId;
    private String instruction;
    private String remark;
    private ShareHolder shareHolder;

    private Task() {
        super();
    }

    public Task(
            TaskId aTaskId,
            CourrierId aCourrierId,
            String instruction,
            String remark,
            ShareHolder aShareHolder) {
        this();
        this.setTaskId(aTaskId);
        this.setCourrierId(aCourrierId);
        this.setShareHolder(aShareHolder);
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

    private void setShareHolder(ShareHolder aShareHolder) {
        this.assertArgumentNotNull(aShareHolder, "Le destinataire est réquis.");
        this.shareHolder =  aShareHolder;
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

    public ShareHolder shareHolder() {
        return shareHolder;
    }

    public TaskId taskId() {
        return taskId;
    }

    public CourrierId courrierId() {
        return courrierId;
    }
}
