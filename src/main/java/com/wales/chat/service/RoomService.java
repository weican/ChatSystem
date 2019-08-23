package com.wales.chat.service;

import com.wales.chat.model.Room;
import com.wales.chat.service.dto.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService  {

    Optional<Room> getRoom(Integer id);
    Optional<List<Room>> getRooms();
    Integer postRoom(RoomDTO roomDTO);

}
