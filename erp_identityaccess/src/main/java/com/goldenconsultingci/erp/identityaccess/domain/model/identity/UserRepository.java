package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import java.util.Collection;
import java.util.List;

public interface UserRepository {

    void add(User anUser);

    User userWithUsername(String anUsername);

    Collection<User> allUsers();

    List<User> withRole(String aRoleName);
}
