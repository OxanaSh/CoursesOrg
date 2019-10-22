package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Department {
    @Id
    private String id;
    private int code;
    private String name;
    private Speciality speciality;
    private boolean enabled;


    public Department() {
    }

    public Department(int code, String name, Speciality speciality) {
        this.code = code;
        this.name = name;
        this.speciality = speciality;
        this.enabled = true;
    }

    public Department(int code, String name, Speciality speciality, boolean enabled) {
        this.code = code;
        this.name = name;
        this.speciality = speciality;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
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

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
