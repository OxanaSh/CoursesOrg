package edu.shep.demo.forms;

public class SubjectForm {
    private String id;
    private String name;
    private String hours;


    public SubjectForm() {
    }

    public SubjectForm(String name, String hours) {
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
