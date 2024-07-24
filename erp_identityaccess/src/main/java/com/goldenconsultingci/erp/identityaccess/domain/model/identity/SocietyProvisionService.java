package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.RoleRepository;

public class SocietyProvisionService {
    private SocietyRepository societyRepository;
    private RoleRepository roleRepository;

    public SocietyProvisionService(
            SocietyRepository societyRepository,
            RoleRepository roleRepository) {
        this.societyRepository = societyRepository;
        this.roleRepository = roleRepository;
    }

    public Society provisionTenant(
            String aTenantName,
            String aSigle,
            String aRccm,
            Telephone primaryTelephone,
            Telephone secondaryTelephone,
            EmailAddress emailAddress,
            int aNumberOfRepresentations,
            String anActivityArea,
            TaxSystem aTaxSystem) {

        Society society = new Society(
                aTenantName,
                aSigle, aRccm,
                new ContactInformation(
                        primaryTelephone,
                        secondaryTelephone,
                        emailAddress),
                aNumberOfRepresentations,
                anActivityArea,
                aTaxSystem);
        this.societyRepository.save(society);
        Role adminRole = this.provisionAdminRole(society); // Utile pour la création de l'utilisateur admin
        return society;
    }

    private Role provisionAdminRole(Society aTenanr) {
        Role adminRole = new Role("Administrator", "Default " + aTenanr.name() + "administrator.");
        this.roleRepository.add(adminRole);
        return adminRole;
    }
}
