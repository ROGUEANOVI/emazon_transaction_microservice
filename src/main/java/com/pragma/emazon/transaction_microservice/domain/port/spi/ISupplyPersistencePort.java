package com.pragma.emazon.transaction_microservice.domain.port.spi;

import com.pragma.emazon.transaction_microservice.domain.model.Supply;

public interface ISupplyPersistencePort {

    public void addSupply(Supply supply);
}
