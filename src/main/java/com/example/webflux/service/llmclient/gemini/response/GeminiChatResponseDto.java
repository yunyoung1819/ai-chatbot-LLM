package com.example.webflux.service.llmclient.gemini.response;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeminiChatResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6016428052839964174L;

    private List candidates;
}
