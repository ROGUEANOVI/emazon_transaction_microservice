package com.pragma.emazon.transaction_microservice.application.dto.request;

import com.pragma.emazon.transaction_microservice.domain.constant.ValidationMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateQuantityRequest {

    @Min(value = ValidationMessages.MINIMUM_SUPPLY_QUANTITY_VALUE, message = ValidationMessages.INVALID_SUPPLY_QUANTITY)
    @NotNull(message = ValidationMessages.INVALID_SUPPLY_QUANTITY)
    private Integer quantity;
}
