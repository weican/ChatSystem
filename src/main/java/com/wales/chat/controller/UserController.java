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


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> getUser(@RequestBody ChatUser chatUser) {
        String password = new String(Base64.getDecoder()
                .decode(chatUser.getPassword().replace("Basic ", "")), StandardCharsets.UTF_8);
        String token= userService.login(chatUser.getName(),password);
        if(StringUtils.isEmpty(token)){
            return new ResponseEntity<>("no token found", HttpStatus.BAD_REQUEST); // TODO Exception
        }

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
