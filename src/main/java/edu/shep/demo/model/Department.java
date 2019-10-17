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

    public Department() {
    }

    public Department(int code, String name) {
        this.code = code;
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return code == that.code &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
