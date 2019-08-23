package com.wales.chat.service;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessgaeServiceImpl implements MessgaeService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Optional<List<ChatMessage>> getMessageByUserId(Integer id) {
        List<ChatMessage> chatMessages =  messageMapper.getMessageByUserId(id);

        return Optional.ofNullable(chatMessages);
    }

    @Override
    public Optional<List<ChatMessage>> getMessageByRoomId(Integer id) {
       List<ChatMessage> chatMessages =  messageMapper.getMessageByRoomId(id);

       return Optional.ofNullable(chatMessages);
    }

}
