package com.example.webflux.model.user.chat;

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
public class UserChatResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -2479640483541743119L;

    private String response;
}
