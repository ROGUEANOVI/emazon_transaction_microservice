package com.pragma.emazon.transaction_microservice.domain.exception;

public class ArticleFeignClientConnectException extends RuntimeException {

    public ArticleFeignClientConnectException(String message) {

        super(message);
    }
}
