package com.higgsup.fswd.classroommanager.service;

import com.higgsup.fswd.classroommanager.controller.dto.ClassRoomDTO;
import com.higgsup.fswd.classroommanager.controller.dto.UserDTO;
import com.higgsup.fswd.classroommanager.model.ClassRoom;
import com.higgsup.fswd.classroommanager.model.User;
import com.higgsup.fswd.classroommanager.repository.ClassRoomRepository;
import com.higgsup.fswd.classroommanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tu on 4/24/2016.
 */
@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    public User findUserToken(String token){
        return userRepository.findByToken(token);
    }


    public User doLogin(UserDTO userDTO) {
        // 1. Generate token if not exist
        // 2. Set expired time for token
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user.getToken() == null) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiry(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));
        } else {
            user.setTokenExpiry(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)));
        }
        user = userRepository.save(user);
        user.getLinks().put("self","http://localhost:8080/" + user.getId());
        return user;
    }

    public UserDTO findUser(Long id) {
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        List<ClassRoom> classRoomses = user.getClassRoomses();
        for (ClassRoom classRoom: classRoomses) {
            classRoom.setUsers(null);
        }
        userDTO.setClassRoomses(classRoomses);
        return userDTO;
    }

    public ClassRoom createClassRoom(Long id, ClassRoomDTO classRoomDTO) {
        User user = userRepository.findById(id);
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName(classRoomDTO.getClassName());
      //  classRoom.getUserses().add(user);
        user.getClassRoomses().add(classRoom);
        classRoom = classRoomRepository.save(classRoom);
        return classRoom;
    }

    public List<ClassRoom> findClassRooms() {
        List<ClassRoom> classRoomses =(List<ClassRoom>) classRoomRepository.findAll();
        return classRoomses;
    }
}
