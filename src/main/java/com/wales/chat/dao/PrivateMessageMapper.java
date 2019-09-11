package com.wales.chat.dao;

import com.wales.chat.model.PrivateMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivateMessageMapper {

    List<PrivateMessage> getMessageByUserId(@Param("id")Integer id, @Param("start")Integer start, @Param("end")Integer end);

    Integer insertMessage(PrivateMessage privateMessage);

}
