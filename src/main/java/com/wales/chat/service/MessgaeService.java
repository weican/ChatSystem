package com.wales.chat.service;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.service.dto.ChatMessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessgaeService {
    Optional<List<ChatMessage>> getMessageByUserId(Integer id);

    Optional<List<ChatMessage>> getMessageByRoomId(Integer id);

    String postMessage(Integer id, ChatMessageDTO chatMessageDTO);

    String postMessageToUser(ChatMessageDTO chatMessageDTO);
}
