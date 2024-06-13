package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Direction extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Set<Department> departments;
    private Manager manager;

    protected Direction() {
        super();
        this.setDepartments(Collections.emptySet());
    }

    public Direction(String aName) {
       this();
       this.setName(aName);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le nom de la direction est réquise.");
        this.assertArgumentLength(aName, 1, 100,
                "Le nom de la direction doit comporter 100 caractères ou moins.");
        this.name = aName;
    }

    private void setDepartments(Set<Department> aDepartments) {
        this.departments = aDepartments;
    }
    public void addDepartment(Department aDepartment) {
        this.assertArgumentNotNull(aDepartment, "Le département ne doit pas être nul.");
        this.departments().add(aDepartment);
    }

    public void changeManager(Manager aManager) {
        this.setManager(aManager);
    }

    private void setManager(Manager aManager) {
        this.assertArgumentNotNull(aManager, "Le manager ne doit pas être nul.");
        this.manager = aManager;
    }

    public Manager manager() {
        return manager;
    }

    public String name() {
        return name;
    }



    public Set<Department> departments() {
        return departments;
    }
}
