package com.wales.chat.dao;

import com.wales.chat.model.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    Room findById(Integer id);

    List<Room> list();  //limited by page
}
