package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SupplyTableFields {

    public static final String TABLE_NAME = "supply";

    public static final String FIELD_ARTICLE_ID = "article_id";

    public static final String FIELD_QUANTITY = "quantity";

    public static final String FIELD_CREATED_BY_USER_ID = "created_by_user_id";

    public static final String FIELD_SUPPLY_DATE = "supply_date";
}
