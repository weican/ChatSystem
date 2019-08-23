package com.wales.chat.model;

import java.util.Date;

public class PrivateMessage {

    Integer from_user;
    Integer to_user;
    String  message;
    Date postedOn;


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

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
}
