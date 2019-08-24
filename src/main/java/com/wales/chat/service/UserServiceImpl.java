package com.wales.chat.service;

import com.wales.chat.dao.UserMapper;
import com.wales.chat.model.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<ChatUser> getUser(Integer userId) {
        ChatUser chatUser = userMapper.findById(userId);
        if(chatUser == null) {
            return Optional.empty();
        }
        chatUser.setPassword("");
        chatUser.setRoles(new ArrayList<>());
        chatUser.setRole_id(0);
        chatUser.setToken("");
        return Optional.ofNullable(chatUser);
    }
}
