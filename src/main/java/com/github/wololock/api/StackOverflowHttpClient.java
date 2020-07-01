package com.github.wololock.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${stackoverflow.api.url}")
public interface StackOverflowHttpClient {

    @Get("/search?site=stackoverflow")
    ApiResponse<Question> search(
            @QueryValue("intitle") String query,
            @QueryValue("tagged") String tag,
            @QueryValue("pagesize") int limit,
            @QueryValue("sort") String sort
    );
}
