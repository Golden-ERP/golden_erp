package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.common.ObjectSerializer;
import com.goldenconsultingci.erp.identityaccess.application.command.RegisterUserCommand;
import com.goldenconsultingci.erp.identityaccess.application.representation.UserRepresentation;
import com.goldenconsultingci.erp.identityaccess.domain.model.identity.User;
import com.goldenconsultingci.erp.identityaccess.presentation.RegisterUserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/iam/users")
public class UserResource extends AbstractResource {

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
}
