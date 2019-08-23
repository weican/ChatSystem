package com.wales.chat.service;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByToken(String token);

    String login(String username, String password);
}
