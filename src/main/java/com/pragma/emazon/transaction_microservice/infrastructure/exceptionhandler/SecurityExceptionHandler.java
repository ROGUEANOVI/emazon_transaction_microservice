package com.pragma.emazon.transaction_microservice.infrastructure.exceptionhandler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class SecurityExceptionHandler {

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<Map<String, String>> handleJWTVerificationException(JWTVerificationException e) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(GlobalMessages.MESSAGE, e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handleAccessDeniedException(AccessDeniedException ex) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }
}
