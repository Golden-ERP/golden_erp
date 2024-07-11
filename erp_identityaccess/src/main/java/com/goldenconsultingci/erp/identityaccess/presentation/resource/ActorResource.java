package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.common.ObjectSerializer;
import com.goldenconsultingci.erp.identityaccess.application.command.RegisterUserCommand;
import com.goldenconsultingci.erp.identityaccess.application.representation.AccessTokenRepresentation;
import com.goldenconsultingci.erp.identityaccess.application.representation.UserInSiteRepresentation;
import com.goldenconsultingci.erp.identityaccess.application.representation.UserRepresentation;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import com.goldenconsultingci.erp.identityaccess.presentation.RegisterUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/iam/actors")
public class ActorResource extends AbstractResource {

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserDto body) {
        User user = this.identityApplicationService()
                .registerUser(new RegisterUserCommand(
                        body.getFirstName(),
                        body.getLastName(),
                        body.getEmailAddress(),
                        body.getTelephone(),
                        body.getUsername(),
                        body.getPassword(),
                        body.getGender(),
                        body.getOccupation()));
        UserRepresentation representation = new UserRepresentation(user);
        return ResponseEntity
                .status(201)
                .body(ObjectSerializer.instance().serialize(representation));
    }
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllUsers() {
        List<UserRepresentation> representations =
                this.identityApplicationService().listAllUsers()
                        .stream()
                        .map(UserRepresentation::new)
                        .collect(Collectors.toList());
        return ResponseEntity.status(200)
                .body(ObjectSerializer.instance().serialize(representations));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(
            @RequestParam(name = "username") String anUsername,
            @RequestParam(name = "password") String aPassword) {
        String token = this.identityApplicationService()
                .authenticate(anUsername, aPassword);
        if (token == null) {
            return this.badCredentialResponse();
        }
        return ResponseEntity
                .status(201)
                .body(new AccessTokenRepresentation(token, "Bearer"));
    }

    @PostMapping(path = "/{username}/sites/{siteId}")
    public ResponseEntity<Void> affectActorInSite(
            @PathVariable(name = "username") String username,
            @PathVariable(name = "siteId") String siteId) {
        this.identityApplicationService()
                .affectActorInSite(username, siteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{username}/inSite/{siteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInSiteRepresentation> getUserInRole(
            @PathVariable(name = "username") String anUsername,
            @PathVariable(name = "siteId") String sitesId) {
        User user = this.identityApplicationService()
                .userInSite(anUsername, sitesId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return  ResponseEntity.status(200).body(new UserInSiteRepresentation(user, sitesId));
    }
    private ResponseEntity<Map<String, String>> badCredentialResponse() {
        return ResponseEntity.status(404)
                .body(Map.of("message", "Nom d'utilisateur ou mot de passe incorrecte."));
    }


}
