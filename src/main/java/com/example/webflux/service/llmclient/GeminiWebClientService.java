package com.example.webflux.service.llmclient;


import com.example.webflux.model.llmclient.LlmChatRequestDto;
import com.example.webflux.model.llmclient.LlmChatResponseDto;
import com.example.webflux.model.llmclient.LlmType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GeminiWebClientService implements LlmWebClientService {
    @Override
    public Mono<LlmChatResponseDto> getChatCompletion(LlmChatRequestDto requestDto) {
        return null;
    }

    @Override
    public LlmType getLlmType() {
        return LlmType.GEMINI;
    }
}
