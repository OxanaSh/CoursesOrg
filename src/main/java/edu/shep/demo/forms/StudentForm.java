package edu.shep.demo.forms;

import edu.shep.demo.model.Person;

public class StudentForm {
    private String id;
    private String person;
    private String password;
    private String email;

    public StudentForm() {
    }

    public StudentForm(String person, String password, String email) {
        this.person = person;
        this.password = password;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
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
        return "StudentFrom{" +
                "id='" + id + '\'' +
                ", person='" + person + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
