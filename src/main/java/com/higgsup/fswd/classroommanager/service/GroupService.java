package com.higgsup.fswd.classroommanager.service;

import com.higgsup.fswd.classroommanager.controller.dto.ClassRoomDTO;
import com.higgsup.fswd.classroommanager.controller.dto.GroupDTO;
import com.higgsup.fswd.classroommanager.model.ClassRoom;
import com.higgsup.fswd.classroommanager.model.Group;
import com.higgsup.fswd.classroommanager.model.User;
import com.higgsup.fswd.classroommanager.repository.ClassRoomRepository;
import com.higgsup.fswd.classroommanager.repository.GroupRepository;
import com.higgsup.fswd.classroommanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    public List<GroupDTO> findAllGroups(String token) {
        User user = userRepository.findByToken(token);
        List<Group> groups =  groupRepository.findByUser(user);
        List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
        for (Group group : groups){
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setGroupName(group.getGroup_name());
            groupDTOs.add(groupDTO);
        }
        return groupDTOs;
    }

    public GroupDTO findByID(Long group_id) {
        Group group = groupRepository.findByID(group_id);
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setGroupName(group.getGroup_name());
        groupDTO.setStudents(group.getStudents());
        groupDTO.setPosts(group.getPosts());
        return groupDTO;
    }

    public String createGroup(GroupDTO groupDTO, String token) {
        User user = userRepository.findByToken(token);
        Group group = new Group();

        group.setLeader_id(user.getId());
        group.setGroup_name(groupDTO.getGroup_name());
        user.getGroups().add(group);

        group = groupRepository.save(group);
        return group.getGroup_name();
    }


    public Group editGroup(Long group_id, GroupDTO groupDTO,String token) {
        User user = userRepository.findByToken(token);
        Group group = groupRepository.findByID(group_id);

        group.setGroup_name(groupDTO.getGroup_name());
        group.setStudents(groupDTO.getStudents());
        user.getGroups().add(group);

        group = groupRepository.save(group);
        return group;
    }

    public void deleteGroup(Long user_id, Long class_id, Long group_id) {
        User user = userRepository.findById(user_id);
        ClassRoom  classRoom = classRoomRepository.findByID(class_id);
        //co can ktra user_id, class_id ?
        Group group = groupRepository.findByID(group_id);
        groupRepository.delete(group);
    }
}
