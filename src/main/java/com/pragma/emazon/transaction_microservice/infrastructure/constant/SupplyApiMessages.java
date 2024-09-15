package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SupplyApiMessages {

    public static final String ROUTE_SUPPLIES = "/api/v1/supplies";

    public static final String TAG_NAME = "Supplies";

    public static final String TAG_DESCRIPTION = "Rest controller for supplies";

    public static final String DESCRIPTION_201 = "Supply created";

    public static final String DESCRIPTION_400 = "Supply bad request";

    public static final String DESCRIPTION_409 = "Article already exists";

    public static final String SUMMARY_ADD_SUPPLY = "Create new article";

    public static final String DESCRIPTION_ADD_SUPPLY = "Rest method for creating supply";
}
