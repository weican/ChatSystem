package com.wales.chat.model;

import java.util.Date;

public class PrivateMessage {

    Integer from_user;
    Integer to_user;
    String  message;
    Date posted_on;


    public Integer getFrom_user() {
        return from_user;
    }

    public void setFrom_user(Integer from_user) {
        this.from_user = from_user;
    }

    public Integer getTo_user() {
        return to_user;
    }

    public void setTo_user(Integer to_user) {
        this.to_user = to_user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(Date posted_on) {
        this.posted_on = posted_on;
    }
}
