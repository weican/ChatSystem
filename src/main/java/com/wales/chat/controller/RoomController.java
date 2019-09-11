package com.wales.chat.controller;

import com.wales.chat.model.ChatRoom;
import com.wales.chat.service.RoomService;
import com.wales.chat.service.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
        if(room.isPresent()) {
            return new ResponseEntity<>(room.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.OK);

    }

    @PostMapping(path ="/rooms")
    public ResponseEntity<?> postRooms(@Valid @RequestBody RoomDTO roomDTO) {
        final Integer roomId = roomService.postRoom(roomDTO);
        return new ResponseEntity<>(roomId, HttpStatus.CREATED);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomsById(@PathVariable Integer id) {

        final Optional<ChatRoom> room = roomService.getRoom(id);
        if(!room.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Room Not Found"
            );
        }
            return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }

    @GetMapping("/room/{id}/users")
    public ResponseEntity<?> getUsersById(@PathVariable Integer id) {

        return  new ResponseEntity<>(roomService.getUsersById(id), HttpStatus.OK);
    }
}
