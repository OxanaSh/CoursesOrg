package edu.shep.demo.repository;

import edu.shep.demo.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository  extends MongoRepository<Subject, String> {
    List<Subject> findAllByEnabledIsTrue();
    List<Subject> findDistinctByNameAndEnabled();
    Subject findByNameAndAndHours(String name, double hours);
    boolean existsByNameAndHours(String name, double hours);

}
