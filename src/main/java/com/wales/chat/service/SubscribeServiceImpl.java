package com.wales.chat.service;

import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class SubscribeServiceImpl implements SubscribeService{

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Override
    public void sendMessageToUser(PrivateMessage privateMessage) {
        messagingTemplate.convertAndSend("/topic/privateMessage", privateMessage);
    }

    @Override
    public void sendMessageToRoom(ChatMessage chatMessage)  {
        messagingTemplate.convertAndSend("/room/"+chatMessage.getRoom_id()+"/subscribe", chatMessage);

    }
}
