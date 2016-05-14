package com.higgsup.fswd.classroommanager.repository;

import com.higgsup.fswd.classroommanager.model.Group;
import com.higgsup.fswd.classroommanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MyPC on 09/05/2016.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findByID(Long group_id);

    List<Group> findByUser(User user);
}
