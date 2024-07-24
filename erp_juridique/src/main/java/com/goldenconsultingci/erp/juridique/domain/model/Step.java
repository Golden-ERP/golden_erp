package com.goldenconsultingci.erp.juridique.domain.model;

public interface Step {
    void addStep(Step aStep);
    void remove(Step aStep);
    Step child(int aPosition);
}
