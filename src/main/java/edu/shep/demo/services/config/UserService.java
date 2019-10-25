package edu.shep.demo.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
       /*User user = new User();
       user.setUsername("u");
       user.setAuthorities(new ArrayList<>(Arrays.asList(Role.values())));
       user.setAccountNonExpired(true);
       user.setAccountNonLocked(true);
       user.setCredentialsNonExpired(true);
       user.setEnabled(true);
       user.setPassword(new BCryptPasswordEncoder().encode("p"));
         // userDao.findByUsername("user").ifPresent(user -> {
        //  user.setPassword(new BCryptPasswordEncoder().encode("p"));
        //    userDao.save(user);
       //});
        userDao.save(user);

        */
    }
        @Override
        public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
            return userDao.findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException("user " + username + " was not found!"));
        }

}
