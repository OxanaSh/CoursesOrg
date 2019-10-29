package edu.shep.demo.repository;

import edu.shep.demo.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository  extends MongoRepository<Teacher, String> {
     boolean existsByEnabledIsTrueAndPersonId(String personId);
}

