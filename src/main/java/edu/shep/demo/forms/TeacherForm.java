package edu.shep.demo.forms;

import edu.shep.demo.model.Degree;
import edu.shep.demo.model.Person;
import edu.shep.demo.model.Subject;

import java.util.List;

public class TeacherForm {
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean enabled;
    private Degree degree;
    private String experience;
    private List <Subject> subjects;

    public TeacherForm() {
    }

    public TeacherForm(String id, String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username, String password, boolean enabled, Degree degree, String experience, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.degree = degree;
        this.experience = experience;
        this.subjects = subjects;
    }

    public TeacherForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username, String password, boolean enabled, Degree degree, String experience, List<Subject> subjects) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.degree = degree;
        this.experience = experience;
        this.subjects = subjects;
    }

    public TeacherForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username, String password, Degree degree, String experience, List<Subject> subjects) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.degree = degree;
        this.experience = experience;
        this.subjects = subjects;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
