package com.higgsup.fswd.classroommanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Tu on 4/23/2016.
 */
@Entity
public class User extends HypermediaLinks{
    // Base user info
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // After login
    private String token;
    private Date tokenExpiry;

    @ManyToMany
    private List<ClassRoom> classRooms;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token =  token;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getTokenExpiry(){
        return tokenExpiry;
    }

    public void setTokenExpiry(Date tokenExpiry){
        this.tokenExpiry = tokenExpiry;
    }

    public List<ClassRoom> getClassRooms(){
        return classRooms;
    }

    public void setClassRooms(List<ClassRoom> classRooms){
        this.classRooms = classRooms;
    }
}
