package com.wales.chat.dao;

import com.wales.chat.model.ChatMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<ChatMessage> getMessageByRoomId(Integer id);

    List<ChatMessage> getMessageByUserId(Integer id);
}
