package com.goldenconsultingci.erp.identityaccess.presentation;

import com.goldenconsultingci.erp.common.ObjectSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalStateException.class, IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<?> handlerIllegalStateException(Exception ex) {
        return ResponseEntity.status(400).body(errorRepresentation(ex.getMessage()));
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<?> handlerIllegalArgumentException(Exception ex) {
//        return ResponseEntity.status(400).body(errorRepresentation(ex.getMessage()));
//    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handlerNullPointerException(Exception ex) {
        return ResponseEntity.status(400).body(errorRepresentation("Une erreur de traitement est survenue."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex) {
        return ResponseEntity.status(500).body(errorRepresentation("Une erreur de traitement est survenue."));
    }

    private String errorRepresentation(String e) {
        Map<String, String> message = Map.of("message", e);
        return ObjectSerializer.instance().serialize(message);
    }
}
