package com.pragma.emazon.transaction_microservice.infrastructure.out.feign.adapter;

import com.pragma.emazon.transaction_microservice.domain.port.spi.IArticleFeignClientPort;
import com.pragma.emazon.transaction_microservice.infrastructure.mapper.ArticleFeignClientMapper;
import com.pragma.emazon.transaction_microservice.infrastructure.out.feign.IArticleServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleFeignClientAdapter implements IArticleFeignClientPort {

    private final IArticleServiceFeignClient articleServiceFeignClient;

    private final ArticleFeignClientMapper articleFeignClientMapper;

    @Override
    public void updateArticleQuantity(Long id, Integer quantity) {

        articleServiceFeignClient.updateArticleQuantity(id, articleFeignClientMapper.toUpdateQuantityRequest(id, quantity));
    }
}
