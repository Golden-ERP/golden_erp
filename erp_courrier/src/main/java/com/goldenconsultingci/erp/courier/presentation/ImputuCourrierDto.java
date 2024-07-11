package com.goldenconsultingci.erp.courier.presentation;

import lombok.Data;

@Data
public class ImputuCourrierDto {
    private String[] identities;
    private String[] instructions;
    private String remark;
}
