package com.wales.chat.dao;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivateMessageMapper {

    List<ChatMessage> getMessageByUserId(Integer id);

    Integer insertMessage(PrivateMessage privateMessage);
}
