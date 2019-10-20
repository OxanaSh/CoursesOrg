package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Subject {
    @Id
    private String id;
    private String name;
    private double hours;

    public Subject() {
    }


    public Subject(String name, double hours) {
        this.name = name;
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
                ", hours=" + hours +
                '}';
    }
}
