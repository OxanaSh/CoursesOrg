package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Application {
    @Id
    private String id;
    private Person person;
    private String email;
    private Speciality speciality;
    private LessonForm formOfStudying;
    private boolean approval;
    private LocalDate dateOfFilling;
    private boolean enabled;
    private Occupation whomWantToBe;
    private Degree degree;


    public Application() {
    }


    public Application(String id, Person person,String email, Speciality speciality, LessonForm formOfStudying, Degree degree, boolean approval, LocalDate dateOfFilling, Occupation whomWantToBe, boolean enabled) {
        this.id = id;
        this.person = person;
        this.speciality = speciality;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = enabled;
        this.whomWantToBe = whomWantToBe;
        this.email = email;
        this.degree = degree;
    }

    public Application(Person person, String email, Speciality speciality, LessonForm formOfStudying,Degree degree, boolean approval, LocalDate dateOfFilling, Occupation whomWantToBe) {
        this.person = person;
        this.speciality = speciality;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = true;
        this.whomWantToBe = whomWantToBe;
        this.email = email;
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Occupation getWhomWantToBe() {
        return whomWantToBe;
    }

    public void setWhomWantToBe(Occupation whomWantToBe) {
        this.whomWantToBe = whomWantToBe;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public LessonForm getFormOfStudying() {
        return formOfStudying;
    }

    public void setFormOfStudying(LessonForm formOfStudying) {
        this.formOfStudying = formOfStudying;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public LocalDate getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(LocalDate dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", speciality=" + speciality +
                ", formOfStudying=" + formOfStudying +
                ", approval=" + approval +
                ", dateOfFilling=" + dateOfFilling +
                ", enabled=" + enabled +
                ", whomWantToBe=" + whomWantToBe +
                '}';
    }
}
