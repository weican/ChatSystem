package com.wales.chat.controller;

import com.wales.chat.model.Room;
import com.wales.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms() {

        Optional<List<Room>> room = roomService.getRooms();
//        if(user.isPresent()) {
//            throw new UserException("The user is not found.");
//        }

        return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomsById(@PathVariable Integer id) {

        Optional<Room> room = roomService.getRoom(id);
//        if(user.isPresent()) {
//            throw new UserException("The user is not found.");
//        }

        return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }
}
