package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Teacher {
    @Id
    private String id;
    private Person person;
    private Degree degree;
    private LocalDate experience;
    private String password;
    private String email;

    public Teacher() {
    }

    public Teacher(Person person, Degree degree, LocalDate experience, String password, String email) {
        this.person = person;
        this.degree = degree;
        this.experience = experience;
        this.password = password;
        this.email = email;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", degree=" + degree +
                ", experience=" + experience +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(person, teacher.person) &&
                degree == teacher.degree &&
                Objects.equals(experience, teacher.experience) &&
                Objects.equals(password, teacher.password) &&
                Objects.equals(email, teacher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, degree, experience, password, email);
    }
}
