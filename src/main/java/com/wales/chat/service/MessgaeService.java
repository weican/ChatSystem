package com.wales.chat.service;

import com.wales.chat.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessgaeService {
    Optional<List<Message>> getMessageByUserId(Integer id);

    Optional<List<Message>> getMessageByRoomId(Integer id);
}
