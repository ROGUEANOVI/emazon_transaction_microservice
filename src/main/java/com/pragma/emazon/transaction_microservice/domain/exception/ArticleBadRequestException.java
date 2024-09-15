package com.pragma.emazon.transaction_microservice.domain.exception;

public class ArticleBadRequestException extends RuntimeException {

    public ArticleBadRequestException(String message) {
        super(message);
    }
}
