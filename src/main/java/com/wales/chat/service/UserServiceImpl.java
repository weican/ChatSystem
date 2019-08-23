package com.wales.chat.service;

import com.wales.chat.dao.UserMapper;
import com.wales.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{


    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<User> getUser(String name, String password) {
        User user = userMapper.findByUserName(name);
        return Optional.ofNullable(user);
    }
}
