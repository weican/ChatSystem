package com.wales.chat.dao;

import com.wales.chat.model.Group_room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Group_roomMapper {

    List<Group_room> getGroup();

    Integer insertGroup(Integer userId, Integer roomId);
}
