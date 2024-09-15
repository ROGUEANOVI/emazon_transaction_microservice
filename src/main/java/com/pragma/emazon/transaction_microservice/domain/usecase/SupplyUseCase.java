package com.pragma.emazon.transaction_microservice.domain.usecase;

import com.pragma.emazon.transaction_microservice.domain.constant.ArticleExceptionMessages;
import com.pragma.emazon.transaction_microservice.domain.constant.SupplyStatus;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleBadRequestException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleInternalServerErrorException;
import com.pragma.emazon.transaction_microservice.domain.exception.ArticleNotFoundException;
import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.domain.port.api.ISupplyServicePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IArticleFeignClientPort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.ISupplyPersistencePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IUserContextPort;
import feign.FeignException;

import java.time.LocalDateTime;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;

    private final IArticleFeignClientPort articleFeignClientPort;

    private final IUserContextPort userContextPort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort,
                         IArticleFeignClientPort articleFeignClientPort,
                         IUserContextPort userContextPort) {

        this.supplyPersistencePort = supplyPersistencePort;
        this.articleFeignClientPort = articleFeignClientPort;
        this.userContextPort = userContextPort;
    }

    @Override
    public void addSupply(Supply supply) {
        try {
            articleFeignClientPort.updateArticleQuantity(supply.getArticleId(), supply.getQuantity());
            addSupply(supply, SupplyStatus.COMPLETED);
        }
        catch (FeignException ex) {
            addSupply(supply, SupplyStatus.FAILED);
            throwFeignClientException(ex, supply);
        }
    }

    private void addSupply(Supply supply, String status) {

        supply.setSupplyDate(LocalDateTime.now());
        supply.setCreatedByUserId(userContextPort.getAuthenticatedUserId());
        supply.setStatus(status);
        supplyPersistencePort.addSupply(supply);
    }

    private void throwFeignClientException(FeignException ex, Supply supply) {

        switch (ex.status()) {
            case 400:
                throw new ArticleBadRequestException(ArticleExceptionMessages.ARTICLE_BAD_REQUEST);
            case 404:
                throw new ArticleNotFoundException(ArticleExceptionMessages.ARTICLE_NOT_FOUND, supply.getArticleId());
            default:
                throw new ArticleInternalServerErrorException(ex.getMessage());
        }
    }
}
