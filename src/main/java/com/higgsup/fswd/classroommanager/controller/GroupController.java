package com.higgsup.fswd.classroommanager.controller;

import com.higgsup.fswd.classroommanager.controller.dto.GroupDTO;
import com.higgsup.fswd.classroommanager.controller.stereotype.RequiredRoles;
import com.higgsup.fswd.classroommanager.model.Group;
import com.higgsup.fswd.classroommanager.model.Role;
import com.higgsup.fswd.classroommanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;


    //All get all groups
    @RequiredRoles({Role.TEACHER, Role.STUDENT})
    @RequestMapping(value = "/class/{class_id}/group" ,method = RequestMethod.GET)
    public List<GroupDTO> getGroups(@PathVariable("class_id") Long class_id,HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return groupService.findAllGroups(token);
    }
    //All see a group details
    @RequiredRoles({Role.TEACHER, Role.STUDENT})
    @RequestMapping(value = "/class/{class_id}/group/{group_id}", method = RequestMethod.GET)
    public GroupDTO showGroup(@PathVariable("group_id") Long group_id){
        return groupService.findByID(group_id);
    }
    //Teacher create a group
    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/class/{class_id}/group", method = RequestMethod.POST)
    public String createGrouup(@PathVariable("class_id") Long class_id, @RequestBody GroupDTO groupDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return groupService.createGroup(groupDTO,token);
    }
    //Teacher edit a group
    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/class/{class_id}/group/{group_id}", method = RequestMethod.PUT)
    public  Group editGroup(@PathVariable("class_id") Long class_id,@PathVariable("group_id") Long group_id ,@RequestBody GroupDTO groupDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return groupService.editGroup(group_id,groupDTO,token);
    }
    //Teacher delete a group
    @RequiredRoles(Role.TEACHER)
    @RequestMapping(value = "/class/{class_id}/group/{group_id}", method = RequestMethod.GET)
    public  void deleteGroup(@PathVariable("user_id") Long user_id, @PathVariable("class_id") Long class_id,@PathVariable("group_id") Long group_id){
        groupService.deleteGroup(user_id,class_id,group_id);
    }

}
