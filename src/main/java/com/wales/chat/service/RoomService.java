package com.wales.chat.service;

import com.wales.chat.model.ChatRoom;
import com.wales.chat.service.dto.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService  {

    Optional<ChatRoom> getRoom(Integer id);
    Optional<List<ChatRoom>> getRooms(Integer page);
    Integer postRoom(RoomDTO roomDTO);

}
