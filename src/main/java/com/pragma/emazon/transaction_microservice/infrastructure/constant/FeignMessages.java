package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FeignMessages {

    public static final String PATH_VARIABLE_ID = "id";

    public static final String ROUTE_UPDATE_ARTICLE_QUANTITY = "/{id}/quantity";

    public static final String BASE_PACKAGE_FEIGN = "com.pragma.emazon.transaction_microservice.infrastructure.out.feign";
}
