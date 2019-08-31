package com.wales.chat.security;

import com.wales.chat.dao.UserMapper;
import com.wales.chat.model.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSrvice  implements UserDetailsService {

    @Autowired
    private UserMapper userName;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ChatUser chatUser = userName.findByUserName(username);
        if(chatUser == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        else {
            System.out.println(chatUser.getName());
            return new User(chatUser);
        }
    }
}
