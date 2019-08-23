package com.wales.chat.service;

import com.wales.chat.dao.UserMapper;
import com.wales.chat.model.ChatUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements  UserService{


    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<User> findByToken(String token) {
        final Optional<ChatUser> chatUser = userMapper.findByToken(token);
        if(chatUser.isPresent()) {
            ChatUser chatUser1 = chatUser.get();
            User user= new User(chatUser1.getName(), chatUser1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public String login(String name, String password) {
        ChatUser chatUser = userMapper.findByUserName(name);
        if(chatUser != null && chatUser.getPassword().equals(password)){
            String token = UUID.randomUUID().toString();
            chatUser.setToken(token);
            userMapper.updateUser(chatUser);
            return token;
        }

        return StringUtils.EMPTY;
    }
}
