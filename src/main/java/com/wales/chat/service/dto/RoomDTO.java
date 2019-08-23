package com.wales.chat.service.dto;

import java.util.List;

public class RoomDTO {

    Integer id;
    String name;

    public List<Integer> getAddedId() {
        return addedId;
    }

    public void setAddedId(List<Integer> addedId) {
        this.addedId = addedId;
    }

    List<Integer> addedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
