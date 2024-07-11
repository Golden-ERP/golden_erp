package com.goldenconsultingci.erp.identityaccess.application;

import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.RoleRepository;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.UserDescriptor;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class AccessApplicationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public void assignUserToRole(String username, String aRoleName) {
        User user = this.userRepository.userWithUsername(username);
        if (user != null) {
            Role role = this.roleRepository.roleNamed(aRoleName);
            if (role != null) {
                user.assignToRole(role);
            }
        }
    }

    @Transactional(readOnly = true)
    private User userInRole(String anUsername, String aRoleName) {
        User userInRole =  null;
        User user = userRepository.userWithUsername(anUsername);
        if (user != null) {
            Role role = roleRepository.roleNamed(aRoleName);
            if (role != null) {
                if (user.hasRole(role)) {
                    userInRole = user;
                }
            }

        }
        return user;
    }

    @Transactional
    public List<User> usersInRole(String aRoleName, String aSiteId) {
        Role role = roleRepository.roleNamed(aRoleName);
        List<User> userInRole = new ArrayList<>();
        if (role != null) {
            userInRole = this.userRepository.withRole(aRoleName);
        }

        return userInRole;
    }

    @Transactional(readOnly = true)
    public List<Role> allRoles() {
        return this.roleRepository.findAll();
    }

    public Role addRole(String aRoleName, String aDescription) {
        Role role = new Role(aRoleName, aDescription);
        this.roleRepository.add(role);
        return role;
    }
}
