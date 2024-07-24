package com.goldenconsultingci.erp.courier.application;

import com.goldenconsultingci.erp.courier.domain.CourrierId;
import com.goldenconsultingci.erp.courier.domain.ShareHolder;
import com.goldenconsultingci.erp.courier.domain.Task;
import com.goldenconsultingci.erp.courier.domain.TaskId;

import java.util.Set;
import java.util.stream.Collectors;

public class CourrierTaskRepresentation {
    private String taskId;
    private String courrierId;
    private String instruction;
    private String remark;
    private ShareHolderRepresentation shareHolder;

    public CourrierTaskRepresentation(Task aTask) {
        this.initialize(aTask);
    }

    private void initialize(Task aTask) {
        this.taskId = aTask.taskId().id();
        this.courrierId = aTask.courrierId().id();
        this.instruction = aTask.instruction();
        this.remark = aTask.remark();
        this.shareHolder = new ShareHolderRepresentation(aTask.shareHolder());
    }

    public String getTaskId() {
        return taskId;
    }

    public String getCourrierId() {
        return courrierId;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getRemark() {
        return remark;
    }

    public ShareHolderRepresentation getShareHolders() {
        return shareHolder;
    }

    public static class ShareHolderRepresentation {
        private String role;
        private String name;
        ShareHolderRepresentation(ShareHolder s) {
            this.role = s.role();
            this.name = s.name();
        }

        public String getRole() {
            return role;
        }

        public String getName() {
            return name;
        }
    }
}
