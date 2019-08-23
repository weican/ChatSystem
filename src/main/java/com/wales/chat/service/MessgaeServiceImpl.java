package com.wales.chat.service;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.dao.User_roomMapper;
import com.wales.chat.model.ChatMessage;
import com.wales.chat.model.User_room;
import com.wales.chat.service.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessgaeServiceImpl implements MessgaeService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    User_roomMapper user_roomMapper;

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

    @Override
    public String postMessage(Integer roomId, ChatMessageDTO chatMessageDTO) {

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

}
