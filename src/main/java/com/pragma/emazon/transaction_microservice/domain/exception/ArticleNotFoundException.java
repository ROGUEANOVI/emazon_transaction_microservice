package com.pragma.emazon.transaction_microservice.domain.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(String message, Long articleId) {

        super(String.format(message, articleId));
    }
}
