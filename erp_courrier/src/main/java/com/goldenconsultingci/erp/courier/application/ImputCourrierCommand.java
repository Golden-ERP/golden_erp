package com.goldenconsultingci.erp.courier.application;

public class ImputCourrierCommand {
    private String courrierId;
//    private String[] identities;
    private String role;
    private String[] instructions;
    private String remark;
    private String siteId;

    public ImputCourrierCommand(String courrierId, String role, String[] instructions, String remark) {
        this.courrierId = courrierId;
        this.role = role;
        this.instructions = instructions;
        this.remark = remark;
    }

    public String courrierId() {
        return courrierId;
    }

    public String role() {
        return role;
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
