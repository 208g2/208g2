package com.higgsup.fswd.classroommanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
@Entity
public class Student extends HypermediaLinks {
    @Id
    private String studentName;
    private Integer age;

    @ManyToMany
    List<ClassRoom> classRoomList = new ArrayList<ClassRoom>();

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
