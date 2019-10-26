package edu.shep.demo.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication implements Authentication {
    private User user;
    private boolean authenticated;





    public UserAuthentication() {
    }

    public UserAuthentication(User user){
        this.user = user;
        authenticated = true;
    }

    public UserAuthentication(User user, boolean authenticated) {
        this.user = user;
        this.authenticated = authenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = isAuthenticated();
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
