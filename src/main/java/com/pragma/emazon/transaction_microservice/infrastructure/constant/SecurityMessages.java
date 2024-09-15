package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityMessages {

    public static final String AUTHORITIES = "authorities";

    public static final String BEARER = "Bearer ";

    public static final String INVALID_TOKEN = "Invalid token, not authorized";

    public static final String TOKEN_EXPIRED = "Invalid token, token expired";

    public static final String USER_ID = "userId";
}
