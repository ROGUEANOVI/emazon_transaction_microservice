package com.pragma.emazon.transaction_microservice.application.dto.request;

import com.pragma.emazon.transaction_microservice.application.constant.AddSupplySchemaDescriptions;
import com.pragma.emazon.transaction_microservice.domain.constant.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = AddSupplySchemaDescriptions.ADD_SUPPLY_REQUEST_DESCRIPTION)
public class AddSupplyRequest {

    @Schema(description = AddSupplySchemaDescriptions.ARTICLE_ID_DESCRIPTION, example = AddSupplySchemaDescriptions.ARTICLE_ID_EXAMPLE)
    @Min(value = ValidationMessages.MINIMUM_ARTICLE_ID_VALUE, message = ValidationMessages.INVALID_ARTICLE_ID)
    @NotNull(message = ValidationMessages.INVALID_ARTICLE_ID)
    private Long articleId;

    @Schema(description = AddSupplySchemaDescriptions.QUANTITY_DESCRIPTION, example = AddSupplySchemaDescriptions.QUANTITY_EXAMPLE)
    @Min(value = ValidationMessages.MINIMUM_SUPPLY_QUANTITY_VALUE, message = ValidationMessages.INVALID_SUPPLY_QUANTITY)
    @NotNull(message = ValidationMessages.INVALID_SUPPLY_QUANTITY)
    private Integer quantity;
}
