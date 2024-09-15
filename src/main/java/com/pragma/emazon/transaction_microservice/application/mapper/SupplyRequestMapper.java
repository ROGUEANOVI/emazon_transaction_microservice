package com.pragma.emazon.transaction_microservice.application.mapper;

import com.pragma.emazon.transaction_microservice.application.dto.request.AddSupplyRequest;
import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = GlobalMessages.SPRING)
public interface SupplyRequestMapper {

    Supply toSupply(AddSupplyRequest addSupplyRequest);
}
