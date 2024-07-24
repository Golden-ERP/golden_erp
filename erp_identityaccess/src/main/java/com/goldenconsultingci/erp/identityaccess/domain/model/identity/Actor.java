package com.goldenconsultingci.erp.identityaccess.domain.model.identity;


import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;

public class Actor extends ConcurrencySafeEntity {
    private static final long serialVersionUID = 1L;
    private FullName name;
    private ContactInformation contactInformation;
    private User user;
    private Gender gender;
    private Direction direction;
    private Site site;
    private Responsibility responsibility;

    protected Actor() {
        super();
    }

    public Actor(
            FullName aName,
            Gender aGender,
            ContactInformation aContactInformation,
            Responsibility aResponsibility) {
        this();
        this.setName(aName);
        this.setGender(aGender);
        this.setResponsibility(aResponsibility);
        this.setContactInformation(aContactInformation);
    }

    private void setSite(Site aSite) {
        this.assertArgumentNotNull(aSite, "Le site doit être fourni.");
        this.site = aSite;
    }
    private void setDirection(Direction aDirection) {
        this.assertArgumentNotNull(aDirection, "La direction de rattachement est réquise.");
        this.direction = aDirection;
    }

    private void setResponsibility(Responsibility aResponsibility) {
        this.assertArgumentNotNull(aResponsibility, "La fonction est réquise.");
        this.responsibility =  aResponsibility;
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


    public Site site() {
        return site;
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

    public Responsibility responsibility() {
        return responsibility;
    }

    public void changeDirection(Direction aDirection) {
        this.setDirection(aDirection);
    }

    public void changeResponsibility(Responsibility aResponsibility) {
        this.setResponsibility(aResponsibility);
    }

    public void internalOnlySetUser(User anUser) {
        this.setUser(anUser);
    }

    public void changeSite(Site aSite) {
        this.setSite(aSite);
    }

    public User user() {
        return user;
    }
}
