package com.higgsup.fswd.classroommanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClassRoom extends HypermediaLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String className;


    @ManyToMany(mappedBy = "classRooms")
    private List<User> userses = new ArrayList<User>();

    public String getClassName() {
        return className;
    }

    public List<User> getUsers() {
        return userses;
    }

    public void setUsers(List<User> userses) {
        this.userses = userses;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
