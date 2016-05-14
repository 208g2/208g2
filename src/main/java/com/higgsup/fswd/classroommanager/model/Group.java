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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groups_has_users",
            joinColumns = {
                    @JoinColumn(name = "class_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id",referencedColumnName = "id")
            }
    )
    private List<User> students = new ArrayList<User>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groups_has_posts",
            joinColumns = {
                    @JoinColumn(name = "group_id",referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "post_id",referencedColumnName = "id")
            }
    )
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


}
