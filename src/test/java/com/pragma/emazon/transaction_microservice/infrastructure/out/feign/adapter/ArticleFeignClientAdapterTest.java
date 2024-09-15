package com.pragma.emazon.transaction_microservice.infrastructure.out.feign.adapter;

import com.pragma.emazon.transaction_microservice.application.dto.request.UpdateQuantityRequest;
import com.pragma.emazon.transaction_microservice.infrastructure.mapper.ArticleFeignClientMapper;
import com.pragma.emazon.transaction_microservice.infrastructure.out.feign.IArticleServiceFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ArticleFeignClientAdapterTest {

    @Mock
    private IArticleServiceFeignClient articleServiceFeignClient;

    @Mock
    private ArticleFeignClientMapper articleFeignClientMapper;

    @InjectMocks
    private ArticleFeignClientAdapter articleFeignClientAdapter;

    private Long articleId;
    private Integer quantity;
    private UpdateQuantityRequest updateQuantityRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        articleId = 1L;
        quantity = 10;
        updateQuantityRequest = new UpdateQuantityRequest(quantity);
    }

    @Test
    void updateArticleQuantityShouldCallFeignClient() {
        when(articleFeignClientMapper.toUpdateQuantityRequest(articleId, quantity)).thenReturn(updateQuantityRequest);

        articleFeignClientAdapter.updateArticleQuantity(articleId, quantity);

        verify(articleServiceFeignClient, times(1)).updateArticleQuantity(articleId, updateQuantityRequest);
    }
}
