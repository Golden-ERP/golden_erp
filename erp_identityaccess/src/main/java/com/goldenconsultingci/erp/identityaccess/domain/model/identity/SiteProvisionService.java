package com.goldenconsultingci.erp.identityaccess.domain.model.identity;

public class SiteProvisionService {

    private SocietyRepository societyRepository;
    private SiteRepository siteRepository;

    public SiteProvisionService(
            SocietyRepository societyRepository,
            SiteRepository siteRepository) {
        this.societyRepository = societyRepository;
        this.siteRepository = siteRepository;
    }

    public Site provisionSite(
            String aSiteName,
            SiteType aType,
            GeographicalAddress aGeographicalAddress,
            FullName aManagerName,
            Telephone aManagerTelephone,
            EmailAddress aManagerEmail) {
       this.assertSocietyCanCreateSite();
        Site site =
                new Site(
                        this.siteRepository.nextIdentity(),
                        aSiteName, aType,
                        aGeographicalAddress,
                        new Manager(
                                aManagerName,
                                aManagerTelephone,
                                aManagerEmail));
        this.siteRepository.add(site);
        return site;
    }

    private void assertSocietyCanCreateSite() {
        long numberOfSites = this.siteRepository.count();
        Society society = this.societyRepository.findSociety();
        if (!society.canCreateSite(numberOfSites)) {
            throw new IllegalStateException("Nombre maximal de sites atteint.");
        }
    }
}
