package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import java.util.Collection;

public interface UserRepository {

    void add(User anUser);

    User userWithUsername(String anUsername);

    Collection<User> allUsers();
}
