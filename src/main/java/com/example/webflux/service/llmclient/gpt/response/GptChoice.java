package com.example.webflux.service.llmclient.gpt.response;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GptChoice implements Serializable {

    @Serial
    private static final long serialVersionUID = 2155012891943030260L;

    private String finishReason;
    private GptMessageResponseDto message;
}
