package com.wales.chat.dao;

import com.wales.chat.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUserName(String name);
}
