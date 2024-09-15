package com.pragma.emazon.transaction_microservice.infrastructure.in.rest;

import com.pragma.emazon.transaction_microservice.application.dto.request.AddSupplyRequest;
import com.pragma.emazon.transaction_microservice.application.handler.ISupplyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SupplyRestControllerTest {

    @Mock
    private ISupplyHandler supplyHandler;

    @InjectMocks
    private SupplyRestController supplyRestController;

    private AddSupplyRequest addSupplyRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        addSupplyRequest = AddSupplyRequest.builder()
                .articleId(1L)
                .quantity(10)
                .build();
    }

    @Test
    @WithMockUser(roles = "WAREHOUSE_ASSISTANT")
    void addSupplyShouldReturn201WhenRequestIsValid() {

        // Act
        ResponseEntity<Void> response = supplyRestController.addSupply(addSupplyRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(supplyHandler, times(1)).addSupply(addSupplyRequest);
    }

    @Test
    @WithMockUser(roles = "WAREHOUSE_ASSISTANT")
    void addSupplyShouldCallSupplyHandler() {

        // Act
        supplyRestController.addSupply(addSupplyRequest);

        // Assert
        verify(supplyHandler, times(1)).addSupply(addSupplyRequest);
    }
}
