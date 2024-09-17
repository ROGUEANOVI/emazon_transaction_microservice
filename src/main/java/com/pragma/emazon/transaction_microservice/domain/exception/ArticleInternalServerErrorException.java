package com.pragma.emazon.transaction_microservice.domain.exception;

public class ArticleInternalServerErrorException extends RuntimeException {

    public ArticleInternalServerErrorException(String message) {

        super(message);
    }
}
