package com.github.wololock.auth;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.uri.UriBuilder;

import java.net.URI;

@Introspected
@ConfigurationProperties("stackoverflow.auth.client")
final class ClientConfiguration {
    private String url;
    private int clientId;
    private String scope;

    public URI generateAuthUri(String redirectUri) {
        return UriBuilder.of(url)
                .path("/oauth")
                .queryParam("client_id", clientId)
                .queryParam("scope", scope)
                .queryParam("redirect_uri", redirectUri)
                .build();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
