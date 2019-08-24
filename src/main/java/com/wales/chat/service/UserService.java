package com.wales.chat.service;

import com.wales.chat.model.ChatUser;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {

    ChatUser login(String username, String password);
}
