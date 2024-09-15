package com.pragma.emazon.transaction_microservice.domain.port.spi;


public interface IArticleFeignClientPort {

    void updateArticleQuantity(Long id, Integer quantity);
}
