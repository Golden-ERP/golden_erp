package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public class UserFactory {

    private UserFactory() {}
    public static User registerUser(
            String anUsername,
            String aPassword,
            FullName aName,
            EmailAddress anEmailAddress,
            Telephone aTelephone,
            Gender aGender,
            Responsibility aResponsibility) {
        Actor actor = new Actor(
                aName,
                aGender,
                new ContactInformation(aTelephone, null, anEmailAddress),
                aResponsibility);
        User user = new User(anUsername, aPassword, actor);

        actor.internalOnlySetUser(user);
        user.activate();
        return user;
    }
}
