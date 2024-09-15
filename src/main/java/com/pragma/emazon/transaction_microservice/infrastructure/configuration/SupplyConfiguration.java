package com.pragma.emazon.transaction_microservice.infrastructure.configuration;

import com.pragma.emazon.transaction_microservice.domain.port.api.ISupplyServicePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IArticleFeignClientPort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.ISupplyPersistencePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IUserContextPort;
import com.pragma.emazon.transaction_microservice.domain.usecase.SupplyUseCase;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.adapter.SupplyJpaAdapter;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.mapper.SupplyEntityMapper;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SupplyConfiguration {

    private final ISupplyRepository supplyRepository;

    private final SupplyEntityMapper supplyEntityMapper;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {

        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort(IArticleFeignClientPort articleFeignClientPort,
                                                IUserContextPort userContextPort) {

        return new SupplyUseCase(supplyPersistencePort(), articleFeignClientPort, userContextPort);
    }
}
