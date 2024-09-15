package com.pragma.emazon.transaction_microservice.domain.exception;

public class SupplyProcessingException extends RuntimeException {

    public SupplyProcessingException(String message, Throwable cause) {

        super(message, cause);
    }
}
