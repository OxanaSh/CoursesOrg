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
    private String department;
    private List<Student> students;
    private LessonForm formOfStudying;

    public StudentGroup() {
    }

    public StudentGroup(String groupNumber, String department, List<Student> students, LessonForm formOfStudying) {
        this.groupNumber = groupNumber;
        this.department = department;
        this.students = students;
        this.formOfStudying = formOfStudying;
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


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public LessonForm getFormOfStudying() {
        return formOfStudying;
    }

    public void setFormOfStudying(LessonForm formOfStudying) {
        this.formOfStudying = formOfStudying;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id='" + id + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", department='" + department + '\'' +
                ", students=" + students +
                ", formOfStudying=" + formOfStudying +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(groupNumber, that.groupNumber) &&
                Objects.equals(department, that.department) &&
                Objects.equals(students, that.students) &&
                formOfStudying == that.formOfStudying;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupNumber, department, students, formOfStudying);
    }
}
