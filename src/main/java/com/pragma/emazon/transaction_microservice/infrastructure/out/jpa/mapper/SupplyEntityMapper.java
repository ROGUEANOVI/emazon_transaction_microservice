package com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.mapper;

import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import com.pragma.emazon.transaction_microservice.domain.model.Supply;
import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = GlobalMessages.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SupplyEntityMapper {

    SupplyEntity toEntity(Supply supply);
}
