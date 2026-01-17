package com.example.webflux.service.llmclient.gemini.request;

import com.example.webflux.model.llmclient.LlmChatRequestDto;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeminiChatRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5071637274914424204L;

    private List<GeminiCompletionRequestDto> contents;
    private GeminiCompletionRequestDto systemInstruction;
    private GeminiGenerationConfigDto generationConfigDto;

    public GeminiChatRequestDto(LlmChatRequestDto llmChatRequestDto) {
        if (llmChatRequestDto.isUseJson()) {
            this.generationConfigDto = new GeminiGenerationConfigDto();
        }
        this.contents = List.of(new GeminiCompletionRequestDto(GeminiMessageRole.USER, llmChatRequestDto.getUserRequest()));
        this.systemInstruction = new GeminiCompletionRequestDto(llmChatRequestDto.getSystemPrompt());
    }
}
