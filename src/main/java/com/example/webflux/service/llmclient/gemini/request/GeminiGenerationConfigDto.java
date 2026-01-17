package com.example.webflux.service.llmclient.gemini.request;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
