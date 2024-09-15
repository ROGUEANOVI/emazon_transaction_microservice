package com.pragma.emazon.transaction_microservice.infrastructure.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OpenApiMessages {

    public static final  String SECURITY_SCHEME_KEY = "bearerAuth";

    public static final  String SECURITY_SCHEME = "bearer";

    public static final String BEARER_FORMAT = "JWT";

    public static final String TITLE = "Emazon Transaction Management API";

    public static final String VERSION = "1.0.0";

    public static final String DESCRIPTION = "This is the Transaction Management Microservice for the Emazon application.";

    public static final String CONTACT_NAME = "Ovidio Romero";

    public static final String CONTACT_EMAIL = "ovidioromero66@gmail.com";

    public static final String CONTACT_URL = "https://www.linkedin.com/in/ovidio-romero/";

    public static final String REPOSITORY_URL = "https://github.com/ROGUEANOVI/emazon_transaction_microservice";

    public static final String EXTERNAL_DOCUMENT_DESCRIPTION = "Emazon Transaction Management API GitHub Repository";

    public static final String CODE_200 = "200";

    public static final String CODE_201 = "201";

    public static final String CODE_400 = "400";

    public static final String CODE_401 = "401";

    public static final String CODE_403 = "403";

    public static final String CODE_404 = "404";

    public static final String CODE_409 = "409";
}
