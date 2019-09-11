package com.wales.chat.dao;

import com.wales.chat.model.ChatRoom;
import com.wales.chat.service.dto.RoomWithUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {

    ChatRoom findById(@Param("id")Integer id);

    List<ChatRoom> list(@Param("start")Integer start, @Param("end") Integer end);

    Integer insertRoom(ChatRoom chatRoom);

    List<RoomWithUser> getUsersById(@Param("id") Integer id);

}
