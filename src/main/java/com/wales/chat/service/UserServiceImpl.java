package com.wales.chat.service;

import com.wales.chat.dao.UserMapper;
import com.wales.chat.model.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{


    @Autowired
    UserMapper userMapper;

    @Override
    public ChatUser login(String name, String password) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ChatUser chatUser = userMapper.findByUserName(name);

        if(chatUser != null && bCryptPasswordEncoder.matches(password, chatUser.getPassword())){
            chatUser.setPassword("");
            return chatUser;
        }

        return null;
    }
}
