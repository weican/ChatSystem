package com.wales.chat.controller;

import com.wales.chat.model.ChatUser;
import com.wales.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {

        Optional<ChatUser> chatUserData = userService.getUser(id);

        if(chatUserData.isPresent()){
            return new ResponseEntity<>(chatUserData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("User is not found", HttpStatus.BAD_REQUEST);
    }

}
