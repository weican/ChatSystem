package com.wales.chat.service;

import com.wales.chat.dao.Group_roomMapper;
import com.wales.chat.dao.RoomMapper;
import com.wales.chat.model.Group_room;
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

    @Autowired
    Group_roomMapper group_roomMapper;

    @Override
    public Optional<Room> getRoom(Integer id) {
        final Room room = roomMapper.findById(id);
        return Optional.ofNullable(room);
    }

    @Override
    public Optional<List<Room>> getRooms(Integer page) {
        final List<Room> rooms = roomMapper.list(page * 10,page * 10 + 10);
        return Optional.ofNullable(rooms);
    }

    @Override
    public Integer postRoom(RoomDTO roomDTO) {

        Room room = new Room();
        room.setName(roomDTO.getName());
        roomMapper.insertRoom(room);
        for(Integer userId : roomDTO.getUserIdList()) {
            group_roomMapper.insertGroup(userId, room.getId());
        }
        return room.getId();
    }
}
