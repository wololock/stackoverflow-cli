package com.github.wololock.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.Collections;
import java.util.List;

@Introspected
final public class ApiResponse<T> {

    public List<T> items = Collections.emptyList();

    @JsonProperty("has_more")
    public boolean hasMore;

    @JsonProperty("quota_max")
    public int quotaMax;

    @JsonProperty("quota_remaining")
    public int quotaRemaining;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "items=" + items +
                ", hasMore=" + hasMore +
                ", quotaMax=" + quotaMax +
                ", quotaRemaining=" + quotaRemaining +
                '}';
    }
}
