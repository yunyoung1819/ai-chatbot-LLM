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
public class GptMessageResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3969869277538758660L;

    private String content;
}
