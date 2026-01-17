package com.example.webflux.service.llmclient.gemini.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GeminiMessageRole {
    USER,
    MODEL;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
