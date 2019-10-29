package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Student {
    @Id
    private String id;
    private Person person;
    private User user;
    private boolean enabled;
    //private String roles;

    public Student() {
    }

    public Student(String id, Person person, User user, boolean enabled) {
        this.id = id;
        this.person = person;
        this.user = user;
        this.enabled = enabled;
    }

    public Student(Person person, User user, boolean enabled) {
        this.person = person;
        this.user = user;
        this.enabled = enabled;
    }

    public Student(Person person, User user) {
        this.person = person;
        this.user = user;
        this.enabled = true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", user=" + user +
                ", active=" + enabled +
                '}';
    }
}
