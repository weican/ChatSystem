package com.wales.chat.service;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;

public interface SubscribeService {

    void sendMessageToUser(PrivateMessage privateMessage);
    void sendMessageToRoom(ChatMessage chatMessage);
}
