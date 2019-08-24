package com.wales.chat.model;

import java.util.Date;
import java.util.List;

public class ChatUser {
    private Long id;
    private Integer role_id;
    private String name;
    private String password;
    private String token;
    private List<String> roles;
    private Date last_password_reset_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getLast_password_reset_date() {
        return last_password_reset_date;
    }

    public void setLast_password_reset_date(Date last_password_reset_date) {
        this.last_password_reset_date = last_password_reset_date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
