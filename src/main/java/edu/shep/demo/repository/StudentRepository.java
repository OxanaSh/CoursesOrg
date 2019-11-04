package edu.shep.demo.repository;

import edu.shep.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends MongoRepository<Student, String> {
    //List<Student> getAllByGroup_IdOrderByPersonAsc();
    //Optional<Student> findByEmail(String email);
    boolean existsByEnabledIsTrueAndPersonId(String personId);
    boolean existsByEnabledIsTrueAndUserId(String userId);
    Student findByPersonId(String id);
    List<Student> getAllByEnabledIsTrue();
}
