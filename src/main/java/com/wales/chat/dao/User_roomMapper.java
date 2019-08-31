package com.wales.chat.dao;

import com.wales.chat.model.User_room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User_roomMapper {

    List<User_room> getUserRoom(Integer roomId);

    Integer insertUserRoom(Integer userId, Integer roomId);
}
