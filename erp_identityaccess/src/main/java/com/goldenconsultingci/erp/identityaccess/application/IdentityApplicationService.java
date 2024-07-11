package com.goldenconsultingci.erp.identityaccess.application;

import com.goldenconsultingci.erp.common.domain.TaxSystem;
import com.goldenconsultingci.erp.identityaccess.application.command.CreateSiteCommand;
import com.goldenconsultingci.erp.identityaccess.application.command.ProvisionTenantCommand;
import com.goldenconsultingci.erp.identityaccess.application.command.RegisterUserCommand;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.RoleRepository;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;

@Transactional("transactionManager")
public class IdentityApplicationService {

    @Autowired
    private SocietyProvisionService societyProvisionService;
    @Autowired
    private SiteProvisionService siteProvisionService;
    @Autowired
    private SocietyRepository societyRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;

    /**
     * provisionSociety - Provision les information d'une société
     * @param aCommand
     * @return {@link Society}
     */
    @IamTx
    public Society provisionSociety(ProvisionTenantCommand aCommand) {
        Society society = this.societyProvisionService.provisionTenant(
                aCommand.name(),
                aCommand.sigle(),
                aCommand.rccm(),
                new Telephone(aCommand.primaryTelephone()),
                aCommand.secondaryTelephone() == null ? null : new Telephone(aCommand.secondaryTelephone()),
                new EmailAddress(aCommand.emailAddress()),
                aCommand.numberOfRepresentations(),
                aCommand.activityArea(),
                TaxSystem.valueOf(aCommand.taxSystem()));

        return society;
    }

    /**
     * societyInfo - Retourne les infos de la socièté
     * @return {@link Society}
     */
    public Society societyInfo() {
        return this.societyRepository.findSociety();
    }

    /**
     * createSite - Crée un nouveau site
     * @param aCommand
     * @return {@link Site}
     */
    @IamTx
    public Site createSite(CreateSiteCommand aCommand) {
        return this.siteProvisionService
                .provisionSite(
                        aCommand.name(),
                        SiteType.valueOf(aCommand.type()),
                        new GeographicalAddress(
                                aCommand.addressStreet(),
                                aCommand.addressCity(),
                                aCommand.addressCountry()),
                        new FullName(aCommand.managerFirstName(), aCommand.managerLastName()),
                        new Telephone(aCommand.managerTelephone()),
                        new EmailAddress(aCommand.managerEmail()));

    }

    /**
     * listSites - retourne la liste des sites
     * @param assembler
     * @return liste {@link Site}
     * @param <T>
     */
    @Transactional(readOnly = true)
    public <T> List<T> listSites(Function<Site, T> assembler) {
        return this.siteRepository.findAll()
                .stream()
                .map(assembler)
                .toList();

    }

    public Site findSite(String anIdentity) {
        return this.siteRepository.ofId(anIdentity);
    }

    @Transactional(value ="iam" ,readOnly = true)
    public List<Site> listSites() {
        return this.siteRepository.findAll();
    }


    /**
     * registerUser - Enregistre un nouvel utilisateur
     * @param aCommand
     * @return {@link User}
     */

    @IamTx
    public User registerUser(RegisterUserCommand aCommand) {
        User user = UserFactory.registerUser(
                aCommand.username(),
                aCommand.password(),
                new FullName(aCommand.firstName(), aCommand.lastName()),
                new EmailAddress(aCommand.emailAddress()),
                new Telephone(aCommand.telephone()),
                Gender.valueOf(aCommand.gender()),
                aCommand.occupation());

        userRepository.add(user);
        return user;
    }

    @Transactional(value = "iam", readOnly = true)
    public Collection<User> listAllUsers() {
        return this.userRepository.allUsers();
    }

    /**
     * addDirection - Ajoute une nouvelle direction
     * @param aDirectionName
     * @param aSiteId
     * @return {@link Direction}
     */
    @IamTx
    public Direction addDirection(String aDirectionName, String aSiteId) {
        Site site = this.existingSite(aSiteId);
        Direction direction = new Direction(aDirectionName);
        site.addDirection(direction);
        return direction;
    }

    /**
     * listAllDirections - retourne la liste des directions.
     * @return liste {@link Direction}
     */
    @Transactional(value = "iam", readOnly = true)
    public Set<Direction> listDirectionsOfSite(String aSiteId) {
        Site site = this.siteRepository.ofId(aSiteId);
        if (site != null) {
            return site.directions();
        }
        return Collections.emptySet();
    }

    /**
     * findDirection - retourne les informations d'une direction
     * @param aDirectionName
     * @return {@link Direction}
     */
    public Direction findDirection(String aDirectionName) {
        return this.directionRepository.DirectionNamed(aDirectionName);
    }


    @IamTx
    public Department createDepartment(String aDepartmentName, String aDirectionName) {
        Direction direction =this.findDirection(aDirectionName);
        Department department = new Department(aDepartmentName);
        direction.addDepartment(department);
        return department;
    }

    @Transactional(value = "iam",readOnly = true)
    public Set<Department> departmentsOfDirection(String aDirectionName) {
        Direction direction = this.findDirection(aDirectionName);
        if (direction != null) {
           return direction.departments();
        }
        return Collections.emptySet();
    }


    public void changeManagerOfDirection(long aDirectionId, String anUserId) {

    }

    private Direction nonNulDirection(String aDirectionName) {
        Direction direction = this.findDirection(aDirectionName);
        if (direction == null) {
            throw new IllegalArgumentException("Cette direction n'existe pas.");
        }
        return direction;
    }

    private Site existingSite(String aSiteName) {
        Site site = this.findSite(aSiteName);
        if (site == null) {
            throw new IllegalArgumentException("Ce site n'existe pas.");
        }
        return site;
    }

    public String authenticate(String anUsername, String aPassword) {
        return this.authenticationService.authenticate(anUsername, aPassword);
    }

    @IamTx
    public void affectActorInSite(String anUsername, String aSiteId) {
        Site site = this.existingSite(aSiteId);
        this.nonNulUser(anUsername).actor().changeSite(site);
    }

    public User findUser(String anUsername) {
        return this.userRepository.userWithUsername(anUsername);
    }

    public User userInSite(String anUsername, String aSiteId) {
        User userInSite = null;
        User user = this.findUser(anUsername);
        if (user != null) {
            if (user.isInSite(aSiteId)) {
                userInSite = user;
            }
        }

        return userInSite;
    }

    private User nonNulUser(String anUsername) {
        User user = this.findUser(anUsername);
        if (user == null) {
            throw new IllegalArgumentException("Utiliteur " + anUsername + " n'existe pas");
        }

        return user;
    }

}
