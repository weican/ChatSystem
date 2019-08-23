package com.wales.chat.dao;

import com.wales.chat.model.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    ChatRoom findById(Integer id);

    List<ChatRoom> list(Integer start, Integer end);  //limited by page

    Integer insertRoom(ChatRoom chatRoom);
}
