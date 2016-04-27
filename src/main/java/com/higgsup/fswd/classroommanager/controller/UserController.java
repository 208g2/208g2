package com.higgsup.fswd.classroommanager.controller;

import com.higgsup.fswd.classroommanager.controller.dto.ClassRoomDTO;
import com.higgsup.fswd.classroommanager.controller.dto.UserDTO;
import com.higgsup.fswd.classroommanager.controller.stereotype.NoAuthentication;
import com.higgsup.fswd.classroommanager.controller.stereotype.RequiredRoles;
import com.higgsup.fswd.classroommanager.model.ClassRoom;
import com.higgsup.fswd.classroommanager.model.Role;
import com.higgsup.fswd.classroommanager.model.User;
import com.higgsup.fswd.classroommanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tu on 4/24/2016.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @NoAuthentication
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }
//    @RequestMapping(value = "/signup", method = RequestMethod.GET)
//    public List<User> Users(){
//        return userService.getUsers();
//    }

    @NoAuthentication
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public User checkLogin(@RequestBody UserDTO user){
        return userService.doLogin(user);
    }

    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/{id}/classes",method = RequestMethod.GET)
    public List<ClassRoom> getClasses(@PathVariable("id") Long id){
        User user = (User) userService.findUser(id);
        return user.getClassRooms();
    }

    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/{id}/classes",method = RequestMethod.POST)
    public ClassRoom setClassRoom(@PathVariable("id") Long id,@RequestBody ClassRoomDTO classRoom){
        return userService.createClassRoom(id,classRoom);
    }

    @RequiredRoles({Role.STUDENT,Role.TEACHER})
    @RequestMapping(value = "/classes",method = RequestMethod.GET)
    public List<ClassRoom> getClasses(){
        return userService.findClassRooms();
    }
}
