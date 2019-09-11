package com.wales.chat.service;

import com.wales.chat.dao.MessageMapper;
import com.wales.chat.dao.PrivateMessageMapper;
import com.wales.chat.dao.User_roomMapper;
import com.wales.chat.exception.NotFoundException;
import com.wales.chat.model.*;
import com.wales.chat.service.dto.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    RoomService roomService;

    @Autowired
    UserService userService;

    @Value("${pageAmount}")
    private Integer pageAmount;

    @Override
    public Optional<List<PrivateMessage>> getMessageByUserId(Integer id, Integer page) throws NotFoundException {
        Optional<ChatUser> chatUser = userService.getUser(id);
        if(!chatUser.isPresent()) {
            throw  new NotFoundException("User Not Found");
        }
        List<PrivateMessage> privateMessage =  privateMessageMapper.getMessageByUserId(id,
                page * pageAmount,page * pageAmount + pageAmount);

        return Optional.ofNullable(privateMessage);
    }

    @Override
    public Optional<List<ChatMessage>> getMessageByRoomId(Integer id, Integer page) throws NotFoundException {
       Optional<ChatRoom> chatRoom =  roomService.getRoom(id);
       if(!chatRoom.isPresent()) {
           throw new NotFoundException("Room Not Found");
       }
       List<ChatMessage> chatMessages =  messageMapper.getMessageByRoomId(id, page * pageAmount,page * pageAmount + pageAmount);

       return Optional.ofNullable(chatMessages);
    }

    @Override
    public String postChatMessage(Integer roomId, ChatMessageDTO chatMessageDTO) {

        List<User_room> user_rooms = user_roomMapper.getUserRoom(roomId);

        if(user_rooms.size() == 0)
            return "Room does not exist";

        user_rooms.parallelStream().forEach( user_room -> {

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setFrom_user(chatMessageDTO.getPosterId());
            chatMessage.setRoom_id(user_room.getRoom_id());
            chatMessage.setMessage(chatMessageDTO.getMessage());
            chatMessage.setTo_user(user_room.getUser_id());
            messageMapper.insertMessage(chatMessage);
            subscribeService.sendMessageToRoom(chatMessage);
        });
        return  "Message posted";
    }

    @Override
    public String postPrivateMessageToUser(Integer toUser, ChatMessageDTO chatMessageDTO) throws NotFoundException {
        Optional<ChatUser> chatUser = userService.getUser(toUser);
        if(!chatUser.isPresent()) {
            throw new NotFoundException("User Not Found");
        }
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setFrom_user(chatMessageDTO.getPosterId());
        privateMessage.setMessage(chatMessageDTO.getMessage());
        privateMessage.setTo_user(toUser);
        privateMessageMapper.insertMessage(privateMessage);
        subscribeService.sendMessageToUser(privateMessage);
        return  "Message posted";

    }

}
