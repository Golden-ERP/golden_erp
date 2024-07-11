package com.goldenconsultingci.erp.courier.presentation;

import com.goldenconsultingci.erp.common.DateConverter;
import com.goldenconsultingci.erp.common.ObjectSerializer;
import com.goldenconsultingci.erp.common.spring.security.SecurityService;
import com.goldenconsultingci.erp.courier.application.*;
import com.goldenconsultingci.erp.courier.domain.Courrier;
import com.goldenconsultingci.erp.courier.domain.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "courriers")
@Tag(name = "Courrier Managment", description = "Gestion des courriers")
@SecurityRequirement(name = "Authorization")
public class CourrierResource {

    @Operation(operationId = "Register Courrier", description = "Enregistrement d'un courrier.")
    @PostMapping(path = "/register")
    public ResponseEntity<CourrierRepresentation> registerCourrier(@RequestBody RegisterCourrierDto body) {
        Courrier courrier = ApplicationServiceRegistry
                .courrierApplicationService()
                .registerNewCourrier(new RegisterNewCourrierCommand(
                        body.getType(),
                        body.getReference(),
                        body.getObject(),
                        body.getSiteId(),
                        DateConverter.toDate(body.getCourrierDate()),
                        body.getRegistrationNumber(),
                        DateConverter.toDate(body.getArrivalDate())));

        return ResponseEntity.status(201)
                .body(new CourrierRepresentation(courrier));
    }

    @PostMapping(path = "/{courrierId}/imput")
    public ResponseEntity<Void> imputCourrier(
            @PathVariable(name = "courrierId") String courrierId,
            @RequestBody ImputuCourrierDto body) {
        ApplicationServiceRegistry
                .courrierApplicationService()
                .imputCourrierToShareholder(new ImputCourrierCommand(
                        courrierId,
                        body.getIdentities(),
                        body.getInstructions(),
                        body.getRemark()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CourrierRepresentation>> allCourriers() {
        List<CourrierRepresentation> representations = ApplicationServiceRegistry
                .courrierApplicationService()
                .allCourriers(SecurityService.currentSite())
                .stream()
                .map(CourrierRepresentation::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(200).body(representations);
    }

    @GetMapping(path = "/{courrierId}/tasks")
    public ResponseEntity<Set<CourrierTaskRepresentation>> tasksOfCourrier(@PathVariable(name = "courrierId") String aCourrierId) {
        Set<CourrierTaskRepresentation> representations = ApplicationServiceRegistry
                .courrierApplicationService()
                .tasksOfCourrier(aCourrierId);
        return ResponseEntity.status(200).body(representations);
    }

    @PostMapping(path = "/{courrierId}/acknowledge")
    public ResponseEntity<Void> acknowledgeCourrier(@PathVariable(name = "courrierId") String courrierId) {
        ApplicationServiceRegistry
                .courrierApplicationService()
                .acknowledgeCourrier(courrierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{courrierId}")
    public ResponseEntity<Void> removeCourrier(@PathVariable(name = "courrierId") String courrierId) {
        ApplicationServiceRegistry
                .courrierApplicationService()
                .removeCourrier(courrierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        Map<String, String> errMes = Map.of("message", ex.getMessage());
        return ResponseEntity.status(400)
                .body(ObjectSerializer.instance().serialize(errMes));
    }
}
