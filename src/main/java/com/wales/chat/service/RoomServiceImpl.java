package com.wales.chat.service;

import com.wales.chat.dao.RoomMapper;
import com.wales.chat.model.Room;
import com.wales.chat.service.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomMapper roomMapper;

    @Override
    public Optional<Room> getRoom(Integer id) {
        Room room = roomMapper.findById(id);
        return Optional.ofNullable(room);
    }

    @Override
    public Optional<List<Room>> getRooms() {
        List<Room> rooms = roomMapper.list();
        return Optional.ofNullable(rooms);
    }

    @Override
    public Integer postRoom(RoomDTO roomDTO) {

        Room room = new Room();
        room.setName(roomDTO.getName());
       return roomMapper.insertRoom(room);
    }
}
