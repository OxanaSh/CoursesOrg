package edu.shep.demo.forms;

import java.util.List;

public class SpecialityForm {
    private String id;
    private String code;
    private String name;
    private String payment;
    private List<String> subjects;


    public SpecialityForm() {
    }

    public SpecialityForm(String code, String name, String payment, List<String> subjects) {
        this.code = code;
        this.name = name;
        this.payment = payment;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
