package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Subject {
    @Id
    private String id;
    private String name;
    private Teacher teacher;
    private String groupNumber;
    private double hours;


    public Subject() {
    }


    public Subject(String name, Teacher teacher, String groupNumber, double hours) {
        this.name = name;
        this.teacher = teacher;
        this.groupNumber = groupNumber;
        this.hours = hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", groupNumber='" + groupNumber + '\'' +
                ", hours=" + hours +
                '}';
    }
}
