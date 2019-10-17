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
    private Speciality speciality;
    private LessonForm formOfStudying;
    private boolean approval;
    private LocalDate dateOfFilling;

    public Application() {
    }

    public Application(Person person, Speciality speciality, LessonForm formOfStudying, boolean approval, LocalDate dateOfFilling) {
        this.person = person;
        this.speciality = speciality;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return approval == that.approval &&
                Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(speciality, that.speciality) &&
                formOfStudying == that.formOfStudying &&
                Objects.equals(dateOfFilling, that.dateOfFilling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, speciality, formOfStudying, approval, dateOfFilling);
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
                '}';
    }
}
