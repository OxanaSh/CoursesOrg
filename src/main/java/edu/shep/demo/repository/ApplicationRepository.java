package edu.shep.demo.repository;

import edu.shep.demo.model.Application;
import edu.shep.demo.model.Occupation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findAllByWhomWantToBe(Occupation whomWantToBe);
}
