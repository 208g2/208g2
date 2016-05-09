package com.higgsup.fswd.classroommanager.controller;

import com.higgsup.fswd.classroommanager.controller.dto.GroupDTO;
import com.higgsup.fswd.classroommanager.controller.stereotype.RequiredRoles;
import com.higgsup.fswd.classroommanager.model.Group;
import com.higgsup.fswd.classroommanager.model.Role;
import com.higgsup.fswd.classroommanager.service.GroupManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
@RestController
public class GroupController {

    @Autowired
    private GroupManagerService groupManagerService;



    @RequiredRoles({Role.TEACHER, Role.STUDENT})
    @RequestMapping(value = "/{user_id}/classes/{class_id}/groups" ,method = RequestMethod.GET)
    public List<Group> getGroups(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id){
        return groupManagerService.findAllGroups();
    }

    @RequiredRoles({Role.TEACHER, Role.STUDENT})
    @RequestMapping(value = "/{user_id}/classes/{class_id}/groups/{group_id}", method = RequestMethod.GET)
    public Group showGroup(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id, @PathVariable("group_id") Long group_id){
        return groupManagerService.findByID(group_id);
    }

    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/{user_id}/classes/{class_id}/groups", method = RequestMethod.POST)
    public Group createGrouup(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id, @RequestBody GroupDTO groupDTO){
        return groupManagerService.createGroup(user_id,groupDTO);
    }

    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/{user_id}/classes/{class_id}/groups/{group_id}", method = RequestMethod.GET)
    public  Group editGroup(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id,@PathVariable("group_id") Long group_id ,@RequestBody GroupDTO groupDTO){
        return groupManagerService.editGroup(user_id,group_id,groupDTO);
    }

    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/{user_id}/classes/{class_id}/groups/{group_id}", method = RequestMethod.GET)
    public  void deleteGroup(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id,@PathVariable("group_id") Long group_id){
        groupManagerService.deleteGroup(user_id,class_id,group_id);
    }

}
