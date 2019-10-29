package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
public class Teacher {
    @Id
    private String id;
    private Person person;
    private Degree degree;
    private LocalDate experience;
    private User user;
    private List <Subject> subjects;
    private boolean enabled;


    public Teacher() {
    }


    public Teacher(Person person, User user, Degree degree, LocalDate experience, List<Subject> subjects) {
        this.person = person;
        this.degree = degree;
        this.experience = experience;
        this.user = user;
        this.subjects = subjects;
        this.enabled = true;
    }

    public Teacher(Person person, Degree degree, LocalDate experience, User user, List<Subject> subjects, boolean enabled) {
        this.person = person;
        this.degree = degree;
        this.experience = experience;
        this.user = user;
        this.subjects = subjects;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public LocalDate getExperience() {
        return experience;
    }

    public void setExperience(LocalDate experience) {
        this.experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", degree=" + degree +
                ", experience=" + experience +
                ", user=" + user +
                ", subject=" + subjects +
                ", enabled=" + enabled +
                '}';
    }
}
