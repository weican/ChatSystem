package com.wales.chat.service;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.dao.PrivateMessageMapper;
import com.wales.chat.dao.User_roomMapper;
import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.PrivateMessage;
import com.wales.chat.model.User_room;
import com.wales.chat.service.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessgaeServiceImpl implements MessgaeService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    User_roomMapper user_roomMapper;

    @Autowired
    PrivateMessageMapper privateMessageMapper;

    @Autowired
    SubscribeService subscribeService;


    @Override
    public Optional<List<PrivateMessage>> getMessageByUserId(Integer id) {
        List<PrivateMessage> privateMessage =  privateMessageMapper.getMessageByUserId(id);

        return Optional.ofNullable(privateMessage);
    }

    @Override
    public Optional<List<ChatMessage>> getMessageByRoomId(Integer id) {
       List<ChatMessage> chatMessages =  messageMapper.getMessageByRoomId(id);

       return Optional.ofNullable(chatMessages);
    }

    @Override
    public String postChatMessage(Integer roomId, ChatMessageDTO chatMessageDTO) {

        List<User_room> user_rooms = user_roomMapper.getUserRoom(roomId);

        if(user_rooms.size() == 0)
            return "Room does not exist";

        user_rooms.parallelStream().forEach( user_room -> {

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setFrom_user(chatMessageDTO.getFromUserId());
            chatMessage.setRoom_id(user_room.getRoom_id());
            chatMessage.setMessage(chatMessageDTO.getMessage());
            chatMessage.setTo_user(user_room.getUser_id());
            messageMapper.insertMessage(chatMessage);
        });
        return  "Message posted";
    }

    @Override
    public String postPrivateMessageToUser(Integer formUser, ChatMessageDTO chatMessageDTO) {

        // TODO DataIntegrityViolationException  fromUser or toUser are not exist
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setFrom_user(formUser);
        privateMessage.setMessage(chatMessageDTO.getMessage());
        privateMessage.setTo_user(chatMessageDTO.getToUserId());
        int tmp = privateMessageMapper.insertMessage(privateMessage);
        subscribeService.sendMessageToUser(privateMessage);
        return tmp == 1? "Message posted" : "The user id does not exist";

    }

}
