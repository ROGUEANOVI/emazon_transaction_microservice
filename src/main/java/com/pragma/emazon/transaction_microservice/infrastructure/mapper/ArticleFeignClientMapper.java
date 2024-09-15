package com.pragma.emazon.transaction_microservice.infrastructure.mapper;

import com.pragma.emazon.transaction_microservice.application.dto.request.UpdateQuantityRequest;
import com.pragma.emazon.transaction_microservice.domain.constant.GlobalMessages;
import org.mapstruct.Mapper;

@Mapper(componentModel = GlobalMessages.SPRING)
public interface ArticleFeignClientMapper {

    UpdateQuantityRequest toUpdateQuantityRequest(Long id, Integer quantity);
}
