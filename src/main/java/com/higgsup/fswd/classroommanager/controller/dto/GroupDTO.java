package com.higgsup.fswd.classroommanager.controller.dto;

import com.higgsup.fswd.classroommanager.model.Post;
import com.higgsup.fswd.classroommanager.model.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */


public class GroupDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long class_id;
    private String group_name;
    private Long leader_id;
    private List<User> students = new ArrayList<User>();
    private List<Post> posts = new ArrayList<Post>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Long getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(Long leader_id) {
        this.leader_id = leader_id;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
    public List<Post> getPosts() { return posts;}

    public void setPosts(List<Post> posts) { this.posts = posts;}

    public String getGroupName() {
        return group_name;
    }

    public void setGroupName(String group_name) {
        this.group_name = group_name;
    }
}
