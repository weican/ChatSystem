package com.wales.chat.service;

import com.wales.chat.dao.RoomMapper;
import com.wales.chat.model.ChatRoom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceImplTest {

    @InjectMocks
    RoomService roomService = new RoomServiceImpl();

    @Mock
    RoomMapper roomMapper;

    @Test
    public void getRooms() {

        ChatRoom mockChatRoom = new ChatRoom();
        mockChatRoom.setId(1);
        mockChatRoom.setName("room 1");
        when(roomMapper.findById(1)).thenReturn(mockChatRoom);

        Optional<ChatRoom> chatRoom = roomService.getRoom(1);

        ChatRoom testChatRoom = new ChatRoom();
        testChatRoom.setName("room 1");
        testChatRoom.setId(1);
        assertEquals(testChatRoom.getName(), chatRoom.get().getName());
        assertEquals(testChatRoom.getId(), chatRoom.get().getId());
        verify(roomMapper).findById(1);
    }
}