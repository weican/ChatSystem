package com.wales.chat.dao;

import com.wales.chat.model.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<ChatMessage> getMessageByRoomId(@Param("id")Integer id, @Param("start")Integer start, @Param("end")Integer end);

    List<ChatMessage> getMessageByUserId(@Param("id")Integer id);

    Integer insertMessage(ChatMessage chatMessage);
}
