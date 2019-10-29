package edu.shep.demo.repository;

import edu.shep.demo.model.Role;
import edu.shep.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends MongoRepository<User, String> {
// List<User> findByUsername(String username);
 User findByUsername(String username);

}
