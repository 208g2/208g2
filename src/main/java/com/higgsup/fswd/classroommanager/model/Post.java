package com.higgsup.fswd.classroommanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Administrator on 14/05/2016.
 */
@Entity
public class Post extends HypermediaLinks{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long user_id;
    List<String> comments;
    private Long group_id;
    private Long class_id;
    private String content;
}
