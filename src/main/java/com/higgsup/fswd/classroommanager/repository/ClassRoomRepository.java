package com.higgsup.fswd.classroommanager.repository;

import com.higgsup.fswd.classroommanager.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hunghip on 4/27/2016.
 */
@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom,Long> {
}
