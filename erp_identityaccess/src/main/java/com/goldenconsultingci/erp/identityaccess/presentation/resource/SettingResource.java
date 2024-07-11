package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.identityaccess.domain.model.setting.Setting;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/settings")
@Tag(name = "Parametrage du Systeme")
public class SettingResource extends AbstractResource{

    @Operation(operationId = "Add setting", description = "Enregistrement dun nouveau paramètre")
    @PostMapping(path = "")
    public ResponseEntity<Void> addSetting(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "value") String values) {
        this.settingApplicationService()
                .addSetting(name, values);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(operationId = "Update setting", description = "Modification dun  paramètre")
    @PutMapping(path = "")
    public ResponseEntity<Void> updateSetting(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "value") String values) {
        this.settingApplicationService()
                .updateSetting(name, values);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(operationId = "Get all settings", description = "Lister tous les paramètres")
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Setting>> getAllSettings() {
        List<Setting> all = this.settingApplicationService()
                .getAll();
        return ResponseEntity.status(200).body(all);
    }

    @Operation(operationId = "Get setting by name", description = "Retrouver un paramètre par nom")
    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Setting> findSetting(@PathVariable(name = "name") String name) {
        Setting setting = this.settingApplicationService()
                .findSetting(name);
        return ResponseEntity.status(200).body(setting);
    }

    @Operation(operationId = "Remove setting", description = "Suppression d'un paramètre")
    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Void> deleteSetting(@PathVariable(name = "name") String name) {
        this.settingApplicationService()
                .remove(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
