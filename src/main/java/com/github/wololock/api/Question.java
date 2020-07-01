package com.github.wololock.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
final public class Question {
    public String title;
    public String link;
    public int score;
    @JsonProperty("answer_count")
    public int answers;
    @JsonProperty("is_answered")
    public boolean accepted;

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", score=" + score +
                ", answers=" + answers +
                ", accepted=" + accepted +
                '}';
    }
}
