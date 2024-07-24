package com.goldenconsultingci.erp.courier.presentation;

import lombok.Data;

@Data
public class ImputuCourrierDto {
    private String identity;
    private String[] instructions;
    private String remark;
}
