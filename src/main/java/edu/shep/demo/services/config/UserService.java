package edu.shep.demo.services.config;

import com.mongodb.lang.NonNull;
import edu.shep.demo.model.Role;
import edu.shep.demo.model.User;
import edu.shep.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService, IUserService{
    @Autowired
    private UserRepository repository;


    @PostConstruct
    public void init() {
       /*User user = new User();
       user.setUsername("admin");
       user.setAuthorities(new ArrayList<>(Arrays.asList(Role.values())));
       user.setAccountNonExpired(true);
       user.setAccountNonLocked(true);
       user.setCredentialsNonExpired(true);
       user.setEnabled(true);
       user.setPassword(new BCryptPasswordEncoder().encode("admin"));
         // userDao.findByUsername("user").ifPresent(user -> {
        //  user.setPassword(new BCryptPasswordEncoder().encode("p"));
        //    userDao.save(user);
       //});
        repository.save(user);
        */

    }
        @Override
        public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
            return findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException("user " + username + " was not found!"));
        }


    public Optional<User> findByUsername(@NonNull String username){
        // return Optional.ofNullable(mongoTemplate.findOne(query(where("username").is(username)), User.class));
        return  Optional.ofNullable(repository.findByUsername(username));
    }


    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(String id) {
        User user = this.get(id);
        repository.deleteById(id);
        return user;
    }
}
