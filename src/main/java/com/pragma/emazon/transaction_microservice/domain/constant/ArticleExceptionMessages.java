package com.pragma.emazon.transaction_microservice.domain.constant;

public class ArticleExceptionMessages {

    public static final String ARTICLE_BAD_REQUEST = "Article id or quantity can not be null or less than 1";

    public static final String ARTICLE_NOT_FOUND = "Article with id '%s' not found";

    private ArticleExceptionMessages() {}
}
