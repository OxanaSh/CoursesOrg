package edu.shep.demo.forms;

import edu.shep.demo.model.Degree;
import edu.shep.demo.model.Person;

public class TeacherForm {
    private String id;
    private Person person;
    private Degree degree;
    private String experience;
    private String password;
    private String email;


    public TeacherForm() {
    }

    public TeacherForm(Person person, Degree degree, String experience, String password, String email) {
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
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
        return "TeacherForm{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", degree=" + degree +
                ", experience='" + experience + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
