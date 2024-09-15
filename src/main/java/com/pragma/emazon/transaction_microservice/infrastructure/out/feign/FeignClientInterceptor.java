package com.pragma.emazon.transaction_microservice.infrastructure.out.feign;

import com.pragma.emazon.transaction_microservice.infrastructure.constant.SecurityMessages;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getDetails() instanceof String token) {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, SecurityMessages.BEARER.concat(token));
        }
    }
}
