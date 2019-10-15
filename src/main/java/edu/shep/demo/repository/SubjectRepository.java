package edu.shep.demo.repository;

import edu.shep.demo.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends MongoRepository<Subject, String> {
}
