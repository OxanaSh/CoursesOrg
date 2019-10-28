package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

//@Entity
@Document
public class Student {
    @Id
    private String id;
    private Person person;
    private User user;
    private boolean active;
    //private String roles;

    public Student() {
    }

    public Student(Person person, User user, boolean active) {
        this.person = person;
        this.user = user;
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
                ", active=" + active +
                '}';
    }
}
