package edu.shep.demo.forms;

import edu.shep.demo.model.LessonForm;
import edu.shep.demo.model.Occupation;

public class ApplicationForm{
        private String id;
        private String name;
        private String surname;
        private String patronymic;
        private String dateOfBirth;
        private String phoneNumber;
        private String specialityCode;
        private String SpecialityName;
        private String specialityPayment;
        private LessonForm formOfStudying;
        private boolean approval;
        private String dateOfFilling;
        private boolean enabled;
        private Occupation whomWantToBe;


    public ApplicationForm() {

    }

    public ApplicationForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String specialityCode, String specialityName, String speciaPayment, LessonForm formOfStudying, String dateOfFilling, Occupation whomWantToBe) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specialityCode = specialityCode;
        SpecialityName = specialityName;
        this.specialityPayment = speciaPayment;
        this.formOfStudying = formOfStudying;
        this.approval = false;
        this.dateOfFilling = dateOfFilling;
        this.enabled = true;
        this.whomWantToBe = whomWantToBe;
    }

    public ApplicationForm(String id, String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String specialityCode, String specialityName, String speciaPayment, LessonForm formOfStudying, String dateOfFilling, Occupation whomWantToBe) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specialityCode = specialityCode;
        SpecialityName = specialityName;
        this.specialityPayment = speciaPayment;
        this.formOfStudying = formOfStudying;
        this.approval = false;
        this.dateOfFilling = dateOfFilling;
        this.enabled = true;
        this.whomWantToBe = whomWantToBe;
    }

    public ApplicationForm(String id, String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String specialityCode, String specialityName, String speciaPayment, LessonForm formOfStudying, boolean approval, String dateOfFilling, boolean enabled, Occupation whomWantToBe) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specialityCode = specialityCode;
        SpecialityName = specialityName;
        this.specialityPayment = speciaPayment;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = enabled;
        this.whomWantToBe = whomWantToBe;
    }

    public ApplicationForm(String name, String surname, String patronymic, String dateOfBirth, String phoneNumber, String specialityCode, String specialityName, String speciaPayment, LessonForm formOfStudying, boolean approval, String dateOfFilling, boolean enabled, Occupation whomWantToBe) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.specialityCode = specialityCode;
        SpecialityName = specialityName;
        this.specialityPayment = speciaPayment;
        this.formOfStudying = formOfStudying;
        this.approval = approval;
        this.dateOfFilling = dateOfFilling;
        this.enabled = enabled;
        this.whomWantToBe = whomWantToBe;
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

    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }

    public String getSpecialityName() {
        return SpecialityName;
    }

    public void setSpecialityName(String specialityName) {
        SpecialityName = specialityName;
    }

    public String getSpecialityPayment() {
        return specialityPayment;
    }

    public void setSpecialityPayment(String specialityPayment) {
        this.specialityPayment = specialityPayment;
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
