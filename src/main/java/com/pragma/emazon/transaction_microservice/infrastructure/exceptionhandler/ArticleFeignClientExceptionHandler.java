package com.pragma.emazon.transaction_microservice.infrastructure.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleBadRequestException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleInternalServerErrorException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleNotFoundException;
import feign.RetryableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ArticleFeignClientExceptionHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(ArticleBadRequestException.class)
    public ResponseEntity<Object> handleArticleBadRequestException(ArticleBadRequestException ex) throws JsonProcessingException {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.readValue(ex.getMessage(), Map.class));
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<Object> handleArticleNotFoundException(ArticleNotFoundException ex) throws JsonProcessingException {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectMapper.readValue(ex.getMessage(), Map.class));
    }

    @ExceptionHandler(ArticleInternalServerErrorException.class)
    public ResponseEntity<Object> handleArticleInternalServerErrorException(ArticleInternalServerErrorException ex) throws JsonProcessingException {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(objectMapper.readValue(ex.getMessage(), Map.class));
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<Map<String, String>> handleRetryableException(RetryableException ex) {

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }
}
