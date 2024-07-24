package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.common.ObjectSerializer;
import com.goldenconsultingci.erp.identityaccess.application.command.CreateSiteCommand;
import com.goldenconsultingci.erp.identityaccess.application.command.ProvisionTenantCommand;
import com.goldenconsultingci.erp.identityaccess.application.representation.ResponsibilityRepresentation;
import com.goldenconsultingci.erp.identityaccess.application.representation.SiteRepresentation;
import com.goldenconsultingci.erp.identityaccess.application.representation.SocietyRepresentation;
import com.goldenconsultingci.erp.identityaccess.domain.model.access.Role;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.*;
import com.goldenconsultingci.erp.identityaccess.presentation.CreateSiteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "iam/api/v1")
public class SocietyResource extends AbstractResource{

    @PostMapping(path = "/society/provision", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> provisionTenant(@RequestBody ProvisionTenantCommand body) {
        Society society = this.identityApplicationService()
                .provisionSociety(body);
        return ResponseEntity
                .status(201)
                .body(ObjectSerializer.instance().serialize(this.toTenantRepresentation(society)));
    }


    @RequestMapping(path = "/society/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> societyInfo() {
        Society society = this.identityApplicationService().societyInfo();
        if (society == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SocietyRepresentation representation = this.toTenantRepresentation(society);
        return ResponseEntity.status(200).body(
                ObjectSerializer.instance().serialize(representation));
    }

    @RequestMapping(path = "/sites", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSite(@RequestBody CreateSiteDto body ) {
        Site site = this.identityApplicationService()
                .createSite(new CreateSiteCommand(
                        body.getName(),
                        body.getType(),
                        body.getAddressStreet(),
                        body.getAddressCity(),
                        body.getAddressCountry(),
                        body.getManagerFirstName(),
                        body.getManagerLastName(),
                        body.getManagerEmail(),
                        body.getManagerTelephone()));
        SiteRepresentation representation = new SiteRepresentation(site);
        return ResponseEntity.status(201).body(this.serialize(representation));
    }

    @RequestMapping(path = "/sites", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listSite() {
        List<SiteRepresentation> representations =
                this.identityApplicationService()
                        .listSites(SiteRepresentation::new);
        return ResponseEntity.status(200)
                .body(ObjectSerializer.instance()
                        .serialize(representations));
    }

    @PostMapping(path = "/sites/{siteId}/directions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createDirection(
            @PathVariable(name = "siteId") String siteId,
            @RequestParam(name = "name") String aDirectionName) {
        Direction direction = this.identityApplicationService()
                .addDirection(aDirectionName, siteId);
        return ResponseEntity.status(201)
                .body(ObjectSerializer.instance().serialize(Map.of("name", direction.name())));
    }

    @GetMapping(path = "/sites/{siteId}/directions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listDirections(@PathVariable String siteId) {
        List<String> directions = this.identityApplicationService()
                .listDirectionsOfSite(siteId).stream()
                .map(Direction::name)
                .collect(Collectors.toList());
        return ResponseEntity.status(200).body(ObjectSerializer.instance().serialize(directions));
    }

    @PostMapping(path = "/directions/{direction}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createDepartment(
            @PathVariable(name = "direction") String aDirectionName,
            @RequestParam(name = "department") String aDepartmentName) {
        Department department = this.identityApplicationService()
                .createDepartment(aDepartmentName, aDirectionName);
        return ResponseEntity.status(201)
                .body(ObjectSerializer.instance().serialize(department));
    }

    @GetMapping(path = "/directions/{direction}/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> departmentsOfDirection(@PathVariable(name = "direction") String aDirectionName) {
        Set<Department> departments = this.identityApplicationService()
                .departmentsOfDirection(aDirectionName);
        return ResponseEntity.status(201)
                .body(ObjectSerializer.instance().serialize(departments));
    }

    @PostMapping(path = "/responsibilities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsibilityRepresentation> createResponsibility(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description) {
        Responsibility responsibility = this.identityApplicationService()
                .createResponsibility(name, description);
        return ResponseEntity.status(200)
                .body(new ResponsibilityRepresentation(responsibility));
    }

    @PostMapping(path = "/responsibilities/{responsibility}/addRole/{role}")
    public ResponseEntity<Void> addRoleToResponsibility(
            @PathVariable(name = "responsibility") String aResponsibilityName,
            @PathVariable(name = "role") String aRoleName) {
        this.identityApplicationService()
                .addRoleToResponsibility(aResponsibilityName, aRoleName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/responsibilities")
    public ResponseEntity<Set<ResponsibilityRepresentation>> listResponseEntity() {
        Set<ResponsibilityRepresentation> representations =
                this.identityApplicationService()
                .findResponsibilities()
                .stream()
                .map(ResponsibilityRepresentation::new)
                .collect(Collectors.toSet());
        return ResponseEntity.status(200).body(representations);
    }

    @PostMapping(path = "/roles")
    public ResponseEntity<Role> createRole(
            @RequestParam(name = "name") String aRoleName,
            @RequestParam(name = "description") String aDescription) {
        Role role = this.identityApplicationService()
                .createRole(aRoleName, aDescription);
        return ResponseEntity.status(200).body(role);
    }

    @GetMapping(path = "/roles")
    public ResponseEntity<List<Role>> listRoles() {
        List<Role> roles = this.identityApplicationService()
                .listRoles();
        return ResponseEntity.status(200).body(roles);
    }

    private SocietyRepresentation toTenantRepresentation(Society aSociety) {
        return new SocietyRepresentation(aSociety);
    }
}
