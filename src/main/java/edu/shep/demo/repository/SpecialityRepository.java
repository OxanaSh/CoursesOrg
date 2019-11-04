package edu.shep.demo.repository;

import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Subject;
import edu.shep.demo.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality, String> {
    List<Speciality> findAllBySubjectsContains(Subject subject);
    List<Speciality> findAllByEnabledIsTrue();
   // List<Speciality> findAllByEnabledIsTrueAndOrderByName();
    Speciality findByName(String name);
}
