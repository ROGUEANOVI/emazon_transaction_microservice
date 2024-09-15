package com.pragma.emazon.transaction_microservice.domain.port.spi;

public interface IUserContextPort {

    Long getAuthenticatedUserId();
}
