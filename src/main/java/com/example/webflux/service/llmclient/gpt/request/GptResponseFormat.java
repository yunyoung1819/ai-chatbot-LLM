package com.example.webflux.service.llmclient.gpt.request;

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
public class GptResponseFormat implements Serializable {

    @Serial
    private static final long serialVersionUID = 5584828603485823118L;

    private String type;
}
