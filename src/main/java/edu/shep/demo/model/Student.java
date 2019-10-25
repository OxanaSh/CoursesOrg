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
    private String email;
    private String password;
    private boolean active;
    //private String roles;

    public Student() {
    }

    public Student(Person person, String password, String email) {
        this.person = person;
        this.password = password;
        this.email = email;
        this.active = true;
    }

    public Student(Person person, String password, String email, boolean enabled) {
        this.person = person;
        this.password = password;
        this.email = email;
        this.active = enabled;
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
        return "Student{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(person, student.person) &&
                Objects.equals(password, student.password) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, password, email);
    }
}
