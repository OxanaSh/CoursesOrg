package edu.shep.demo.services.config;

import edu.shep.demo.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User get(String id);
    User create(User user);
    User update(User user);
    User delete(String id);
}
