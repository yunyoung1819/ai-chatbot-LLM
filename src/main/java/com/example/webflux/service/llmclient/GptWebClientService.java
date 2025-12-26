package com.example.webflux.service.llmclient;

import com.example.webflux.model.llmclient.LlmChatRequestDto;
import com.example.webflux.model.llmclient.LlmChatResponseDto;
import com.example.webflux.model.llmclient.LlmType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GptWebClientService implements LlmWebClientService {

    private final WebClient webClient;

    @Override
    public Mono<LlmChatResponseDto> getChatCopletion(LlmChatRequestDto requestDto) {
        return null;
    }

    @Override
    public LlmType getLlmType() {
        return null;
    }
}
