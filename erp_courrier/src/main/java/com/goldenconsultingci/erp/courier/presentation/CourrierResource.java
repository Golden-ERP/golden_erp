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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "courriers")
@CrossOrigin("*")
@Tag(name = "Courrier Managment", description = "Gestion des courriers")
@SecurityRequirement(name = "Authorization")
public class CourrierResource {

    @Operation(operationId = "Register Courrier", description = "Enregistrement d'un courrier.")
    @PostMapping(path = "/register")
    public ResponseEntity<CourrierRepresentation> registerCourrier(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "reference") String reference,
            @RequestParam(name = "object") String object,
            @RequestParam(name = "courrierDate") String courrierDate,
            @RequestParam(name = "registrationNumber") String registrationNumber,
            @RequestParam(name = "sender") String sender,
            @RequestParam(name = "arrivalDate") String arrivalDate,
            @RequestParam(name = "file") MultipartFile file) {
        Courrier courrier = ApplicationServiceRegistry
                .courrierApplicationService()
                .registerNewCourrier(new RegisterNewCourrierCommand(
                        type,
                        reference,
                        object,
                        DateConverter.toDate(courrierDate),
                        registrationNumber,
                        DateConverter.toDate(arrivalDate)));

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
                        body.getIdentity(),
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

    @GetMapping(path = "/myCourriers")
    public ResponseEntity<List<CourrierRepresentation>> myCourriers() {
        List<CourrierRepresentation> representations = ApplicationServiceRegistry
                .courrierApplicationService()
                .myCourriers()
                .stream()
                .map(CourrierRepresentation::new)
                .toList();
        return ResponseEntity.status(200).body(representations);
    }
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        Map<String, String> errMes = Map.of("message", ex.getMessage());
        return ResponseEntity.status(400)
                .body(ObjectSerializer.instance().serialize(errMes));
    }
}
