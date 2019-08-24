package com.wales.chat.service;

import com.wales.chat.dao.User_roomMapper;
import com.wales.chat.dao.RoomMapper;
import com.wales.chat.model.ChatRoom;
import com.wales.chat.service.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    User_roomMapper user_roomMapper;

    @Value("${pageAmount}")
    private Integer pageAmount;


    @Override
    public Optional<ChatRoom> getRoom(Integer id) {
        final ChatRoom chatRoom = roomMapper.findById(id);
        return Optional.ofNullable(chatRoom);
    }

    @Override
    public Optional<List<ChatRoom>> getRooms(Integer page) {
        final List<ChatRoom> chatRooms = roomMapper.list(page * pageAmount,page * pageAmount + pageAmount);
        return Optional.ofNullable(chatRooms);
    }

    @Override
    public Integer postRoom(RoomDTO roomDTO) {

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(roomDTO.getName());
        roomMapper.insertRoom(chatRoom);
        roomDTO.getUserIdList()
                .parallelStream()
                .forEach( userId -> user_roomMapper.insertUserRoom(userId, chatRoom.getId()));
        return chatRoom.getId();
    }
}
