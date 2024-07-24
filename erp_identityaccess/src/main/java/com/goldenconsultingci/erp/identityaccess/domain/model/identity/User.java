package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.common.domain.ConcurrencySafeEntity;
import com.goldenconsultingci.erp.identityaccess.domain.DomainRegistry;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class User extends ConcurrencySafeEntity {

    private String username;
    private String password;
    private Actor actor;
    private boolean active;
    private Set<Role> roles;
    protected User() {
        super();
    }

    public User(String anUsername, String aPassword, Actor anActor) {
        this();
        this.setUsername(anUsername);
        this.protectPassword("", aPassword);
        this.setActor(anActor);
    }

    private void setActor(Actor anActor) {
        this.assertArgumentNotNull(anActor, "L'acteur ne doit pas être nul.");
        this.actor = anActor;
    }

    private void protectPassword(String aCurrentPassword, String aChangedPassword) {
        this.assertPasswordNotSame(aCurrentPassword, aChangedPassword);
        this.assertPasswordNotWeak(aChangedPassword);
        this.assertUsernamePasswordNotSame(aChangedPassword);
        this.setPassword(DomainRegistry.passwordEncoder().encode(aChangedPassword));
    }

    private void assertPasswordNotWeak(String aChangedPassword) {
        this.assertArgumentTrue(
                DomainRegistry.passwordService()
                        .isWeak(aChangedPassword),
                "Le mot doit être fort.");
    }

    private void assertUsernamePasswordNotSame(String aChangedPassword) {
        this.assertArgumentNotEquals(
                this.username(),
                aChangedPassword,
                "Le nom d'utilisateur et le mot de passe ne doivent pas être même.");
    }

    private void assertPasswordNotSame(String aCurrentPassword, String aChangedPassword) {
        this.assertArgumentNotEquals(
                aCurrentPassword,
                aChangedPassword,
                "Le mot de passe n'est pas changé.");
    }

    private void setUsername(String anUsername) {
        this.assertArgumentNotEmpty(anUsername, "Le nom d'utilisateur est réquis.");
        this.assertArgumentLength(anUsername, 1, 20, "Le nom d'utilisateur doit comporter 20 caractères ou moins.");
        this.username = anUsername;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setActive(boolean anActive) {
        this.active = anActive;
    }

    public void changePassword(String aCurrentPassword, String aChangedPassword) {
        this.assertArgumentNotEmpty(aCurrentPassword, "L'ancien et le nouveau mot de passe doivent pas être vide.");
        this.assertPasswordConfirmed(aCurrentPassword);
        this.protectPassword(aCurrentPassword, aChangedPassword);
    }

    private void assertPasswordConfirmed(String aCurrentPassword) {
        this.assertArgumentTrue(
                DomainRegistry.passwordEncoder()
                        .matches(aCurrentPassword, this.password()),
                "Le mot de passe est incorrecte.");
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }


    public boolean isActive() {
        return this.active;
    }

    public void activate() {
        if (!this.isActive()) {
            this.active =  true;
        }
    }

    public Actor actor() {
        return actor;
    }

    public Telephone telephone() {
        return this.actor().contactInformation().primaryTelephone();
    }

    public EmailAddress emailAddress() {
        return this.actor().contactInformation().emailAddress();
    }

    public FullName name() {
        return this.actor().name();
    }

    public void deactivate() {
        if (this.isActive()) {
            this.active = false;
        }
    }

    public UserDescriptor descriptor() {
        return new UserDescriptor(
                this.username(),
                this.name().firstName(),
                this.name().lastName(),
                 this.emailAddress().address(),
                this.actor().site().siteId());
    }

    private void setRoles(Set<Role> aRoles) {
        this.roles =  aRoles;
    }

    public Set<Role> allRoles() {
        this.roles().addAll(actor().responsibility().roles());
        return Collections.unmodifiableSet(this.roles());
    }

    private Set<Role> roles() {
        return roles;
    }

    public boolean hasRole(Role role) {;
        return true;
    }

    public void assignToRole(Role role) {
        this.roles().add(role);
    }

    public Site site() {
        return this.actor().site();
    }

    public boolean isInSite(String aSiteId) {
        if (this.site() != null) {
            return this.site().siteId().equals(aSiteId);
        }
        return false;
    }

    public void changeResponsibility(Responsibility responsibility) {
        this.actor().changeResponsibility(responsibility);
    }
}
