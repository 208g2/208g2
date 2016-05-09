package com.higgsup.fswd.classroommanager.model;

import javax.persistence.Entity;

/**
 * Created by MyPC on 09/05/2016.
 */
@Entity
public class Posts extends HypermediaLinks{
    private Long id;
    private Long user_id;
    private Long class_id;
    private Long group_id;
    private String content;
}
