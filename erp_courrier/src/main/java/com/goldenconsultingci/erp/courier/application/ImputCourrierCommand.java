package com.goldenconsultingci.erp.courier.application;

public class ImputCourrierCommand {
    private String courrierId;
    private String[] identities;
    private String[] instructions;
    private String remark;
    private String siteId;

    public ImputCourrierCommand(String courrierId, String[] identities, String[] instructions, String remark) {
        this.courrierId = courrierId;
        this.identities = identities;
        this.instructions = instructions;
        this.remark = remark;
    }

    public String courrierId() {
        return courrierId;
    }

    public String[] identities() {
        return identities;
    }

    public String[] instructions() {
        return instructions;
    }

    public String remark() {
        return remark;
    }

    public String siteId() {
        return siteId;
    }
}
