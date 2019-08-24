package com.wales.chat.service;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;
import com.wales.chat.service.dto.ChatMessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessgaeService {
    Optional<List<PrivateMessage>> getMessageByUserId(Integer id, Integer page);

    Optional<List<ChatMessage>> getMessageByRoomId(Integer id, Integer page);

    String postChatMessage(Integer roomId, ChatMessageDTO chatMessageDTO);

    String postPrivateMessageToUser(Integer toUser, ChatMessageDTO chatMessageDTO);
}
