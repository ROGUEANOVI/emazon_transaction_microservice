package com.pragma.emazon.transaction_microservice.domain.usecase;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IArticleFeignClientPort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.ISupplyPersistencePort;
import com.pragma.emazon.transaction_microservice.domain.port.spi.IUserContextPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @Mock
    private IArticleFeignClientPort articleFeignClientPort;

    @Mock
    private IUserContextPort userContextPort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    private Supply supply;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        supply = new Supply();
        supply.setArticleId(1L);
        supply.setQuantity(10);
        supply.setSupplyDate(LocalDateTime.now());
    }

    @Test
    void addSupplyShouldCompleteSuccessfully() {

        when(userContextPort.getAuthenticatedUserId()).thenReturn(1L);

        supplyUseCase.addSupply(supply);

        verify(articleFeignClientPort, times(1)).updateArticleQuantity(supply.getArticleId(), supply.getQuantity());

        verify(supplyPersistencePort, times(1)).addSupply(argThat(s -> s.getStatus().equals("COMPLETED")));
    }
}