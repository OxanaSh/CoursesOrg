package edu.shep.demo.forms;

import edu.shep.demo.model.Role;

import java.util.List;

public class UserForm {
    private String id;
    private String username;
    private List<Role> authorities;
    private String password;


    public UserForm() {
    }

    public UserForm(String username, List<Role> authorities, String password) {
        this.username = username;
        this.authorities = authorities;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
