package com.wales.chat.service;


import com.wales.chat.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String name, String password);
}
