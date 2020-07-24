package com.github.wololock.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
final class AccessToken {
    @JsonProperty("access_token")
    public String token;
}
