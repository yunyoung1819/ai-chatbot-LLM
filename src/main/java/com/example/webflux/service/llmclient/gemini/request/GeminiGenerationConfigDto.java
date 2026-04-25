package com.example.webflux.service.llmclient.gemini.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class GeminiGenerationConfigDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -8210165334557408777L;

    private String responseMimeType;

    public GeminiGenerationConfigDto() {
        this.responseMimeType = "application/json";
    }
}
