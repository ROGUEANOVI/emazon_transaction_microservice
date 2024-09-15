package com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.adapter;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.domain.port.spi.ISupplyPersistencePort;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.mapper.SupplyEntityMapper;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;

    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    @Transactional
    public void addSupply(Supply supply) {

        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }
}
