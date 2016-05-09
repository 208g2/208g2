package com.higgsup.fswd.classroommanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
@Entity
public class Group extends HypermediaLinks{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long class_id;
    private String group_name;
    private Long leader_id;
    @ManyToMany
    List<User> students = new ArrayList<User>();
    @OneToMany
    List<Posts> posts = new ArrayList<Posts>();


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

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }


}
