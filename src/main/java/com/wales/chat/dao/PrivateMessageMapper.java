package com.wales.chat.dao;

import com.wales.chat.model.PrivateMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivateMessageMapper {

    List<PrivateMessage> getMessageByUserId(Integer id, Integer start, Integer end);

    Integer insertMessage(PrivateMessage privateMessage);
}
