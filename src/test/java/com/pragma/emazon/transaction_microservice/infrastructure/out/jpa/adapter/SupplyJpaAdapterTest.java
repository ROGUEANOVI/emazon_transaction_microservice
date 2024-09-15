package com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.adapter;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.entity.SupplyEntity;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.mapper.SupplyEntityMapper;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.repository.ISupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class SupplyJpaAdapterTest {

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private SupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyJpaAdapter supplyJpaAdapter;

    private Supply supply;
    private SupplyEntity supplyEntity;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        supply = new Supply(null, 1L, 150, "COMPLETED", 2L, LocalDateTime.now()); // Supply con ID 1 y cantidad 10
        supplyEntity = new SupplyEntity(1L, 1L, 150, "COMPLETED", 2L, LocalDateTime.now()); // Entidad mapeada
    }

    @Test
    void addSupply_ShouldCallRepositorySave() {

        when(supplyEntityMapper.toEntity(supply)).thenReturn(supplyEntity);

        supplyJpaAdapter.addSupply(supply);

        verify(supplyRepository, times(1)).save(supplyEntity);
    }
}
