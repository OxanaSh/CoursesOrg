package edu.shep.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER_STUDENT, USER_TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
