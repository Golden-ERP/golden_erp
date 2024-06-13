package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public class UserRegistrationService {
    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(
            String anUsername,
            String aPassword,
            FullName aName,
            EmailAddress anEmailAddress,
            Telephone aTelephone,
            Gender aGender,
            String anOccupation) {
        Actor actor = new Actor(
                aName,
                aGender,
                new ContactInformation(aTelephone, null, anEmailAddress),
                anOccupation);
        User user = new User(anUsername, aPassword, actor);

        actor.internalOnlySetUser(user);
        user.activate();
        userRepository.add(user);
        return user;
    }
}
