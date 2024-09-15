package com.pragma.emazon.transaction_microservice.application.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AddSupplySchemaDescriptions {

    public static final String ADD_SUPPLY_REQUEST_DESCRIPTION = "Request body for adding a new supply";

    public static final String ARTICLE_ID_DESCRIPTION = "Unique identifier for the article to be supplied";

    public static final String ARTICLE_ID_EXAMPLE = "1";

    public static final String QUANTITY_DESCRIPTION = "Quantity of the supply to be added";

    public static final String QUANTITY_EXAMPLE = "150";
}
