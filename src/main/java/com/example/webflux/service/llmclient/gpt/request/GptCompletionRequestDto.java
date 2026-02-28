package com.example.webflux.service.llmclient.gpt.request;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GptCompletionRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3867368537247877877L;

    private GptMessageRole role; // 시스템 프로픔트, 유저 입력, AI 응답
    private String content;      // 채팅 내용
}
