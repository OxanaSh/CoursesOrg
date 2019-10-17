package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class StudentGroup {
    @Id
    private String id;
    private String groupNumber;
    private LessonForm formOfStudying;
    private Speciality speciality;

    public StudentGroup() {
    }

    public StudentGroup(String groupNumber, LessonForm formOfStudying, Speciality speciality) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public LessonForm getFormOfStudying() {
        return formOfStudying;
    }

    public void setFormOfStudying(LessonForm formOfStudying) {
        this.formOfStudying = formOfStudying;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


    @Override
    public String toString() {
        return "StudentGroup{" +
                "id='" + id + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", formOfStudying=" + formOfStudying +
                ", speciality=" + speciality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(groupNumber, that.groupNumber) &&
                formOfStudying == that.formOfStudying &&
                Objects.equals(speciality, that.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupNumber, formOfStudying, speciality);
    }
}
