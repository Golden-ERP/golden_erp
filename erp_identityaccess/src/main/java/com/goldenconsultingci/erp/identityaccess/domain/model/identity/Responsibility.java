package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Responsibility extends ConcurrencySafeEntity {
    private String name;
    private String description;
    private Set<Role> roles;

    protected Responsibility() {
        super();
        this.setRoles(new HashSet<>(0));
    }

    public Responsibility(String aName, String aDescription) {
       this();
        this.setName(aName);
        this.seDescription(aDescription);
    }

    private void setName(String aName) {
        this.assertArgumentNotEmpty(aName, "Le nom de la responsabilité est réquise.");
        this.name =  aName;
    }

    private void seDescription(String aDescription) {
        this.description =  aDescription;
    }

    private void setRoles(Set<Role> aRoles) {
        this.roles = roles;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Set<Role> roles() {
        return roles;
    }

    public void addRole(Role aRole) {
        this.roles().add(aRole);
        System.out.println(this.roles().size());
    }

    public void removeRole(String aRoleName) {
        Iterator<Role> it = this.roles().iterator();
        while(it.hasNext()) {
            if (it.next().name().equals(aRoleName)) {
                it.remove();
                break;
            }
        }
    }
}
