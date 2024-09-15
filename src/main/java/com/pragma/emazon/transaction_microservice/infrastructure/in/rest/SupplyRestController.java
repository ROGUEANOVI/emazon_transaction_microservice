package com.pragma.emazon.transaction_microservice.infrastructure.in.rest;

import com.pragma.emazon.transaction_microservice.application.dto.request.AddSupplyRequest;
import com.pragma.emazon.transaction_microservice.application.handler.ISupplyHandler;
import com.pragma.emazon.transaction_microservice.application.handler.SupplyHandler;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.AuthorizeMessages;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.OpenApiMessages;
import com.pragma.emazon.transaction_microservice.infrastructure.constant.SupplyApiMessages;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pragma.emazon.transaction_microservice.infrastructure.constant.SupplyApiMessages.*;

@RestController
@RequestMapping(SupplyApiMessages.ROUTE_SUPPLIES)
@Tag(name = SupplyApiMessages.TAG_NAME, description = SupplyApiMessages.TAG_DESCRIPTION)
@RequiredArgsConstructor
@PreAuthorize(AuthorizeMessages.DENY_ALL)
public class SupplyRestController {

    private final ISupplyHandler supplyHandler;

    @Operation(summary = SUMMARY_ADD_SUPPLY, description = DESCRIPTION_ADD_SUPPLY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = OpenApiMessages.CODE_201, description = DESCRIPTION_201, content = @Content),
            @ApiResponse(responseCode = OpenApiMessages.CODE_400, description = DESCRIPTION_400, content = @Content),
            @ApiResponse(responseCode = OpenApiMessages.CODE_409, description = DESCRIPTION_409, content = @Content)
    })
    @PreAuthorize(AuthorizeMessages.HAS_ROLE_ROLE_WAREHOUSE_ASSISTANT)
    @PostMapping
    public ResponseEntity<Void> addSupply(@RequestBody AddSupplyRequest addSupplyRequest) {

        supplyHandler.addSupply(addSupplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
