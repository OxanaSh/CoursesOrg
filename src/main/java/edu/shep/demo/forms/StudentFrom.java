package edu.shep.demo.forms;

import edu.shep.demo.model.Person;

public class StudentFrom {
    private String id;
    //????
    private Person person;
    private String password;
    private String email;
    private String group;

    public StudentFrom() {
    }

    public StudentFrom(Person person, String password, String email, String group) {
        this.person = person;
        this.password = password;
        this.email = email;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
