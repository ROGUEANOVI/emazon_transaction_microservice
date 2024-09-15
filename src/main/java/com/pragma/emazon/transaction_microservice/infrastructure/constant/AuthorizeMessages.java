package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
public class AuthorizeMessages {

    public static final String DENY_ALL = "denyAll()";

    public static final String PERMIT_ALL = "permitAll()";

    public static final String HAS_ROLE_ROLE_WAREHOUSE_ASSISTANT = "hasRole('ROLE_WAREHOUSE_ASSISTANT')";
}
