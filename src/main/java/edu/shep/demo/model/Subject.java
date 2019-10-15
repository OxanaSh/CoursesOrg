package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Subject {
    @Id
    private String id;
    private String name;
    private int teacherCode;
    private String groupNumber;
    private double hours;


    public Subject() {
    }

    public Subject(String name, int teacherCode, String groupNumber, double hours) {
        this.name = name;
        this.teacherCode = teacherCode;
        this.groupNumber = groupNumber;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(int teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return teacherCode == subject.teacherCode &&
                Double.compare(subject.hours, hours) == 0 &&
                Objects.equals(id, subject.id) &&
                Objects.equals(name, subject.name) &&
                Objects.equals(groupNumber, subject.groupNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teacherCode, groupNumber, hours);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacherCode=" + teacherCode +
                ", groupNumber='" + groupNumber + '\'' +
                ", hours=" + hours +
                '}';
    }
}
