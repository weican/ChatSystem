package com.wales.chat.service;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessgaeServiceImpl implements MessgaeService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Optional<List<Message>> getMessageByUserId(Integer id) {
        List<Message> messages=  messageMapper.getMessageByUserId(id);

        return Optional.ofNullable(messages);
    }

    @Override
    public Optional<List<Message>> getMessageByRoomId(Integer id) {
       List<Message> messages=  messageMapper.getMessageByRoomId(id);

       return Optional.ofNullable(messages);
    }

}
