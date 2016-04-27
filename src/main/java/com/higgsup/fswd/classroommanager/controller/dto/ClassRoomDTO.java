package com.higgsup.fswd.classroommanager.controller.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunghip on 4/27/2016.
 */
public class ClassRoomDTO {
    private String className;
    private List<UserDTO> userDTOs = new ArrayList<UserDTO>();

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public String getClassName(){
        return className;
    }

    public void setClassName(String className){
        this.className = className;
    }


}
