package com.higgsup.fswd.classroommanager.repository;

import com.higgsup.fswd.classroommanager.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MyPC on 09/05/2016.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, String> {
}
