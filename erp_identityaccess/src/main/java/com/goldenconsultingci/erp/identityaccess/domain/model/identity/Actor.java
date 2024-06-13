package com.goldenconsultingci.erp.identityaccess.domain.model.identity;


import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;

public class Actor extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;
    private FullName name;
    private ContactInformation contactInformation;
    private User user;
    private Gender gender;
    private Direction direction;
    private String occupation;

    protected Actor() {
        super();
    }

    public Actor(
            FullName aName,
            Gender aGender,
            ContactInformation aContactInformation,
            String anOccupation) {
        this();
        this.setName(aName);
        this.setGender(aGender);
        this.setOccupation(anOccupation);
        this.setContactInformation(aContactInformation);
    }

    private void setDirection(Direction aDirection) {
        this.assertArgumentNotNull(aDirection, "La direction de rattachement est réquise.");
        this.direction = aDirection;
    }

    private void setOccupation(String anOccupation) {
        this.assertArgumentNotEmpty(anOccupation, "La fonction est réquise.");
        this.occupation =  anOccupation;
    }

    private void setGender(Gender aGender) {
        this.assertArgumentNotNull(aGender, "Le Sexe est réquis.");
        this.gender = aGender;
    }

    private void setContactInformation(ContactInformation aContactInformation) {
        this.assertArgumentNotNull(aContactInformation, "Les informations de contact est réquis.");
        this.contactInformation = aContactInformation;
    }

    private void setName(FullName aName) {
        this.assertArgumentNotNull(aName, "Le nom est réquis.");
        this.name = aName;
    }

    protected void setUser(User anUser) {
        this.assertArgumentNotNull(anUser, "L'utilisateur est réquis.");
        this.user = anUser;
    }

    public FullName name() {
        return name;
    }

    public ContactInformation contactInformation() {
        return contactInformation;
    }

    public Gender gender() {
        return gender;
    }

    public Direction direction() {
        return direction;
    }

    public String occupation() {
        return occupation;
    }

    public void changeDirection(Direction aDirection) {
        this.setDirection(aDirection);
    }
    public void changeOccupation(String anOccupation) {
        this.setOccupation(anOccupation);
    }

    public void internalOnlySetUser(User anUser) {
        this.setUser(anUser);
    }
}
