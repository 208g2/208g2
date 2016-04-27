//package com.higgsup.fswd.classroommanager.controller.dto;
//
//import com.higgsup.fswd.classroommanager.model.User;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Tu on 4/24/2016.
// */
//@Component
//public class DtoTransformer {
//    public User getUser(UserDTO userDTO){
//        User user = new User();
//        BeanUtils.copyProperties(userDTO,user);
//        return user;
//    }
//
//    public UserDTO getUserDto(User user) {
//
//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(user, userDTO);
//        return userDTO;
//    }
//}
