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
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
public class GroupManagerService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    public List<Group> findAllGroups() {
        List<Group> groups = (List<Group>) groupRepository.findAll();
        return groups;
    }

    public Group findByID(Long group_id) {
        return groupRepository.findByID(group_id);
    }

    public Group createGroup(Long user_id, GroupDTO groupDTO) {
        User user = userRepository.findById(user_id);
        Group group = new Group();
        group.setGroup_name(groupDTO.getGroupName());
        user.getGroups().add(group);
        group = groupRepository.save(group);
        return group;
    }


    public Group editGroup(Long user_id, Long group_id, GroupDTO groupDTO) {
        User user = userRepository.findById(user_id);
        Group group = groupRepository.findByID(group_id);
        group.setGroup_name(groupDTO.getGroupName());
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
