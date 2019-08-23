package com.wales.chat.controller;

import com.wales.chat.model.ChatRoom;
import com.wales.chat.service.RoomService;
import com.wales.chat.service.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms(@RequestParam(defaultValue = "0", required = false) Integer page) {
        final Optional<List<ChatRoom>> room = roomService.getRooms(page);
        return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }

    @PostMapping(path ="/rooms")
    public ResponseEntity<?> postRooms(@RequestBody RoomDTO roomDTO) {
        final Integer roomId = roomService.postRoom(roomDTO);
        return new ResponseEntity<>(roomId, HttpStatus.OK);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomsById(@PathVariable Integer id) {

        final Optional<ChatRoom> room = roomService.getRoom(id);
//        if(user.isPresent()) {
//            throw new UserException("The user is not found.");
//        }

        return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }
}
