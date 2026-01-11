package com.example.webflux.service.llmclient.gpt.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GptMessageRole {
    SYSTEM,     // 시스템 프롬프트
    USER,       // 유저 입력
    ASSISTANT,  // ai 입력
    ;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
