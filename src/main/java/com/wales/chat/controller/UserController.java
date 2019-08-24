package com.wales.chat.controller;

import com.wales.chat.model.ChatUser;
import com.wales.chat.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> getUser(@RequestBody ChatUser chatUser) {

        ChatUser chatUserData = userService.login(chatUser.getName(), chatUser.getPassword());

        if(chatUserData == null){
            return new ResponseEntity<>("User is not found", HttpStatus.BAD_REQUEST); // TODO Exception
        }

        return new ResponseEntity<>(chatUserData, HttpStatus.OK);
    }

}
