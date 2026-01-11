package com.example.webflux.service.llmclient.gpt.response;

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
public class GptChatResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1523146764646833141L;

    private List<GptChoice> choices;

    public GptChoice getSinleChoice() {
        return choices.stream().findFirst().orElseThrow();
    }
}
