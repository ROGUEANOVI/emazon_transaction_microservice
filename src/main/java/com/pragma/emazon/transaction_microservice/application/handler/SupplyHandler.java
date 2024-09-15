package com.pragma.emazon.transaction_microservice.application.handler;

import com.pragma.emazon.transaction_microservice.application.dto.request.AddSupplyRequest;
import com.pragma.emazon.transaction_microservice.application.mapper.SupplyRequestMapper;
import com.pragma.emazon.transaction_microservice.domain.port.api.ISupplyServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class SupplyHandler implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;

    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void addSupply(@Valid AddSupplyRequest addSupplyRequest) {

        supplyServicePort.addSupply(supplyRequestMapper.toSupply(addSupplyRequest));
    }
}
