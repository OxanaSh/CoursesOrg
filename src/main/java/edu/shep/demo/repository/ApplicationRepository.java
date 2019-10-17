package edu.shep.demo.repository;

import edu.shep.demo.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String> {

}
