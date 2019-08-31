package com.wales.chat.dao;

import com.wales.chat.model.ChatUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    ChatUser findByUserName(String name);

    ChatUser findById(Integer userId);

    Optional<ChatUser> findByToken(String token);

    void updateUser(ChatUser chatUser);
}
