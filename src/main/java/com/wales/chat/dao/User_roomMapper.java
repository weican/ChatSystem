package com.wales.chat.dao;

import com.wales.chat.model.User_room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface User_roomMapper {

    List<User_room> getUserRoom(@Param("roomId")Integer roomId);

    Integer insertUserRoom(@Param("userId")Integer userId, @Param("roomId")Integer roomId);
}
