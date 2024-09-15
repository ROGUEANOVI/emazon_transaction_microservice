package com.pragma.emazon.transaction_microservice.application.handler;

import com.pragma.emazon.transaction_microservice.application.dto.request.AddSupplyRequest;
import jakarta.validation.Valid;

public interface ISupplyHandler {

    public void addSupply(@Valid AddSupplyRequest addSupplyRequest);
}
