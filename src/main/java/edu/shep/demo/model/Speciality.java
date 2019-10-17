package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Speciality {
    @Id
    private String id;
    private int code;
    private String name;
    private List<Subject> subjects;
    private Department department;


    public Speciality() {
    }

    public Speciality(int code, String name, List<Subject> subjects, Department department) {
        this.code = code;
        this.name = name;
        this.subjects = subjects;
        this.department = department;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Speciality{" +
                "id='" + id + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return code == that.code &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subjects, that.subjects) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, subjects, department);
    }
}
