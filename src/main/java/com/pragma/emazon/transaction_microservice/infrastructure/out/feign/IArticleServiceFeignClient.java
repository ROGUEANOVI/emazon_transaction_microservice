package com.pragma.emazon.transaction_microservice.infrastructure.out.feign;

import com.pragma.emazon.transaction_microservice.application.dto.request.UpdateQuantityRequest;
import com.pragma.emazon.transaction_microservice.infrastructure.configuration.FeignConfiguration;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.FeignMessages;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "${feign.client.article-service.name}",
    url = "${feign.client.article-service.url}",
    configuration = FeignConfiguration.class
)
public interface IArticleServiceFeignClient {

    @PutMapping(FeignMessages.ROUTE_UPDATE_ARTICLE_QUANTITY)
    void updateArticleQuantity(@PathVariable(FeignMessages.PATH_VARIABLE_ID) Long articleId,
                               @RequestBody UpdateQuantityRequest updateQuantityRequest);
}
