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
    private List<User> users = new ArrayList<User>();

    public String getClassName() {
        return className;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
