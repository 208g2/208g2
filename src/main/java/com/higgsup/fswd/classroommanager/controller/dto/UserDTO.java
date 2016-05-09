package com.higgsup.fswd.classroommanager.controller.dto;

import com.higgsup.fswd.classroommanager.model.ClassRoom;
import com.higgsup.fswd.classroommanager.model.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO = Data Transfer Object > luôn luôn là 1 object POJO = Plain Old Java Object
 * Chỉ có các fields và getter/setter
 * Created by lent on 4/20/2016.
 */

public class UserDTO {
    private String username;
    private String password;
    private Role role;
    private List<ClassRoom> classRoomses = new ArrayList<ClassRoom>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<ClassRoom> getClassRoomses(){
        return classRoomses;
    }

    public void setClassRoomses(List<ClassRoom> classRoomses){
        this.classRoomses = classRoomses;
    }
}
