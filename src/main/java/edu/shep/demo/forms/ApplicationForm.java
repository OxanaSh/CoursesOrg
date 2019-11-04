package edu.shep.demo.forms;

import edu.shep.demo.model.Degree;
import edu.shep.demo.model.LessonForm;
import edu.shep.demo.model.Occupation;
import edu.shep.demo.model.Speciality;

public class ApplicationForm{
        private String id;
        private String name;
        private String surname;
        private String patronymic;
        private String dateOfBirth;
        private String phoneNumber;
        private String username;
        private Speciality speciality;
        private LessonForm formOfStudying;
        private boolean approval;
        private String dateOfFilling;
        private boolean enabled;
        private Occupation whomWantToBe;
        private Degree degree;


    public ApplicationForm() {

    }

    public ApplicationForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber,String username, Speciality specialityName, LessonForm formOfStudying, Degree degree, String dateOfFilling, Occupation whomWantToBe) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        speciality = specialityName;
        this.formOfStudying = formOfStudying;
        this.approval = false;
        this.dateOfFilling = dateOfFilling;
        this.enabled = true;
        this.whomWantToBe = whomWantToBe;
        this.username = username;
        this.degree = degree;
    }

    public ApplicationForm(String id, String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String username,Speciality specialityName,  LessonForm formOfStudying,Degree degree, String dateOfFilling, Occupation whomWantToBe) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        speciality = specialityName;
        this.formOfStudying = formOfStudying;
        this.approval = false;
        this.dateOfFilling = dateOfFilling;
        this.enabled = true;
        this.whomWantToBe = whomWantToBe;
        this.username = username;
        this.degree = degree;
    }

    public ApplicationForm(String id, String name, String surname, String patronymic, String dateOfBirth, String phoneNumber,String username,Speciality specialityName, LessonForm formOfStudying,Degree degree, boolean approval, String dateOfFilling, boolean enabled, Occupation whomWantToBe) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        speciality = specialityName;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = enabled;
        this.whomWantToBe = whomWantToBe;
        this.username = username;
        this.degree = degree;
    }

    public ApplicationForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber,String username, Speciality specialityName, LessonForm formOfStudying,Degree degree, boolean approval, String dateOfFilling, boolean enabled, Occupation whomWantToBe) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        speciality = specialityName;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = enabled;
        this.whomWantToBe = whomWantToBe;
        this.username = username;
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public LessonForm getFormOfStudying() {
        return formOfStudying;
    }

    public void setFormOfStudying(LessonForm formOfStudying) {
        this.formOfStudying = formOfStudying;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Occupation getWhomWantToBe() {
        return whomWantToBe;
    }

    public void setWhomWantToBe(Occupation whomWantToBe) {
        this.whomWantToBe = whomWantToBe;
    }
}
