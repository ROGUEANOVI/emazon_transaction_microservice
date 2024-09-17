package com.pragma.emazon.transaction_microservice.infrastructure.out.feign;

import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleBadRequestException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleInternalServerErrorException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleNotFoundException;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.SecurityMessages;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class ArticleFeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        log.info(GlobalMessages.LOG_ERROR, methodKey, response);
        String responseBody = getResponseBody(response);
        if (response.status() >= 400 && response.status() <= 499) {
            return switch (response.status()) {
                case 400 -> new ArticleBadRequestException(responseBody);
                case 403 -> new AccessDeniedException(SecurityMessages.ACCESS_DENIED);
                case 404 -> new ArticleNotFoundException(responseBody);
                default -> new ErrorDecoder.Default().decode(methodKey, response);
            };
        } else if (response.status() >= 500 && response.status() <= 599) {
            return new ArticleInternalServerErrorException(responseBody);
        }

        return new ErrorDecoder.Default().decode(methodKey, response);
    }

    private String getResponseBody(Response response) {

        if (response.body() != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining(GlobalMessages.DELIMITER));
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        return GlobalMessages.NO_RESPONSE_BODY;
    }
}
