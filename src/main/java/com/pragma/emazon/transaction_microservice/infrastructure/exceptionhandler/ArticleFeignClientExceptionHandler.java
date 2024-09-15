package com.pragma.emazon.transaction_microservice.infrastructure.exceptionhandler;

import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleBadRequestException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleInternalServerErrorException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleNotFoundException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ArticleFeignClientExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, String>> handleFeignClientException(FeignException ex) {

        return ResponseEntity.status(ex.status()).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(ArticleBadRequestException.class)
    public ResponseEntity<Map<String, String>> handleArticleBadRequestException(ArticleBadRequestException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleArticleNotFoundException(ArticleNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(ArticleInternalServerErrorException.class)
    public ResponseEntity<Map<String, String>> handleArticleInternalServerErrorException(ArticleInternalServerErrorException ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(GlobalMessages.MESSAGE, ex.getMessage()));
    }
}
