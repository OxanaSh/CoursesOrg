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
    private List <Student> students;
    private Schedule schedule;
    private boolean enabled;


    public StudentGroup() {
    }

    public StudentGroup(String groupNumber, LessonForm formOfStudying, Speciality speciality, List<Student> students, Schedule schedule) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.students = students;
        this.schedule = schedule;
        this.enabled = true;
    }

    public StudentGroup(String groupNumber, LessonForm formOfStudying, Speciality speciality, List<Student> students, Schedule schedule, boolean enabled) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.students = students;
        this.schedule = schedule;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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
                ", students=" + students +
                ", schedule=" + schedule +
                '}';
    }
}
