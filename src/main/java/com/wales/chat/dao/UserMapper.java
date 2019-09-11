package com.wales.chat.dao;

import com.wales.chat.model.ChatUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {

    ChatUser findByUserName(@Param("name") String name);

    ChatUser findById(@Param("userId") Integer userId);

    Optional<ChatUser> findByToken(@Param("token") String token);

    void updateUser( ChatUser chatUser);
}
