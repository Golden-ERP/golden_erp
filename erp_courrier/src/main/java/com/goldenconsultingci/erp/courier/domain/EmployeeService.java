package com.goldenconsultingci.erp.courier.domain;

public interface EmployeeService {
    ShareHolder shareHolderFrom(String identity, String aSiteId);
    ShareHolder employeeFromResponsibility(String aRoleName, String aSiteId);
}
