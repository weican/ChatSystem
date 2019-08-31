package com.wales.chat.service.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RoomDTO {

    @Id
    Integer id;

    @NotNull(message = "Name is mandatory")
    String name;

    @NotNull(message = "User list is mandatory")
    List<Integer> userIdList;

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
    }

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
