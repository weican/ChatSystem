package com.wales.chat.controller;

import com.wales.chat.controller.error.UserException;
import com.wales.chat.model.User;
import com.wales.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam String name, @RequestParam String password) {

        Optional<User> user = userService.getUser(name,password);

//        if(user.isPresent()) {
//            throw new UserException("The user is not found.");
//        }

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

}
