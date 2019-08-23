package com.wales.chat.controller.error;

public class UserException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;

    public UserException(String message) {
        this.message = message;
    }
}
