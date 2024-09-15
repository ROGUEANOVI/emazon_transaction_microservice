package com.pragma.emazon.transaction_microservice.domain.port.api;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;

public interface ISupplyServicePort {

    public void addSupply(Supply supply);
}
