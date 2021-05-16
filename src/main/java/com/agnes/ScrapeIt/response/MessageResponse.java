package com.agnes.ScrapeIt.response;

import lombok.*;

@Getter
@Setter
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
