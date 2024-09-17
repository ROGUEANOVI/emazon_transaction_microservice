package com.pragma.emazon.transaction_microservice.infrastructure.configuration;

import com.pragma.emazon.transaction_microservice.infrastructure.constant.FeignMessages;
import com.pragma.emazon.transaction_microservice.infrastructure.out.feign.ArticleFeignClientErrorDecoder;
import com.pragma.emazon.transaction_microservice.infrastructure.out.feign.FeignClientInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = FeignMessages.BASE_PACKAGE_FEIGN)
public class FeignConfiguration {

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {

        return new FeignClientInterceptor();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ArticleFeignClientErrorDecoder();
    }
}
