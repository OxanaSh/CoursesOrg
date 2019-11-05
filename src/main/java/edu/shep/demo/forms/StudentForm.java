package edu.shep.demo.forms;

import edu.shep.demo.model.Person;

public class StudentForm {
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean enabled;


    public StudentForm() {
    }

    public StudentForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username, String password, boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public StudentForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public StudentForm(Person person, String username, String password) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.patronymic = person.getPatronymic();
        this.dateOfBirth = person.getDateOfBirth().toString();
        this.phoneNumber = person.getPhoneNumber();
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "StudentForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
