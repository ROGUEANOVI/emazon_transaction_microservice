package com.pragma.emazon.transaction_microservice.domain.constant;

public class ValidationMessages {

    public static final int MINIMUM_ARTICLE_ID_VALUE = 1;

    public static final int MINIMUM_SUPPLY_QUANTITY_VALUE = 1;

    public static final String INVALID_ARTICLE_ID = "Article id cannot be null or less than 1";

    public static final String INVALID_SUPPLY_QUANTITY = "Article quantity cannot be null or less than 1";

    private ValidationMessages() {}
}
