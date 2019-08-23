package com.wales.chat.dao;

import com.wales.chat.model.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MessageMapper {

    List<Message> getMessageByRoomId(Integer id);

    List<Message> getMessageByUserId(Integer id);
}
