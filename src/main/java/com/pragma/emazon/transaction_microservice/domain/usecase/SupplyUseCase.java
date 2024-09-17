package com.pragma.emazon.transaction_microservice.domain.usecase;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.domain.port.api.ISupplyServicePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IArticleFeignClientPort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.ISupplyPersistencePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IUserContextPort;

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

        articleFeignClientPort.updateArticleQuantity(supply.getArticleId(), supply.getQuantity());

        supply.setSupplyDate(LocalDateTime.now());
        supply.setCreatedByUserId(userContextPort.getAuthenticatedUserId());
        supplyPersistencePort.addSupply(supply);
    }
}
