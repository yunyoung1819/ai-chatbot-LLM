package com.example.webflux.service.llmclient.gemini.request;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeminiCompletionRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8288823047886266320L;

    private GeminiMessageRole role; // Role
    private String content;         // 채팅 내용

    public GeminiCompletionRequestDto(String content) {
        this.content = content;
    }
}
