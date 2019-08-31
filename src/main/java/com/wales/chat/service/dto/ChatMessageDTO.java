package com.wales.chat.service.dto;

import javax.validation.constraints.NotNull;

public class ChatMessageDTO {
    @NotNull(message = "posterId is mandatory")
    Integer posterId ;

    Integer toUserId;

    @NotNull(message = "Message is mandatory")
    String message;

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
