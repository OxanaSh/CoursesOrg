package edu.shep.demo.forms;

import edu.shep.demo.model.LessonForm;
import edu.shep.demo.model.Schedule;
import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Student;

import java.util.List;

public class StudentGroupForm {
    private String id;
    private String groupNumber;
    private LessonForm formOfStudying;
    private Speciality speciality;
    private List<String> students;
    private Schedule schedule;
    private boolean enabled;
    private String maxStudentsNumber;

    public StudentGroupForm() {
    }

    public StudentGroupForm(String id, String groupNumber, LessonForm formOfStudying, Speciality speciality, List<String> students, Schedule schedule, String maxStudentsNumber, boolean enabled) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.students = students;
        this.schedule = schedule;
        this.enabled = enabled;
        this.maxStudentsNumber = maxStudentsNumber;
    }

    public StudentGroupForm(String id, String groupNumber, LessonForm formOfStudying, Speciality speciality, List<String> students, Schedule schedule, String maxStudentsNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.students = students;
        this.schedule = schedule;
        this.enabled = true;
        this.maxStudentsNumber = maxStudentsNumber;
    }

    public StudentGroupForm(String groupNumber, LessonForm formOfStudying, Speciality speciality, Schedule schedule, String maxStudentsNumber) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.schedule = schedule;
        this.enabled = true;
        this.maxStudentsNumber = maxStudentsNumber;
    }

    public StudentGroupForm(String groupNumber, LessonForm formOfStudying, Speciality speciality, List<String> students, Schedule schedule, String maxStudentsNumber, boolean enabled) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.students = students;
        this.schedule = schedule;
        this.enabled = enabled;
        this.maxStudentsNumber = maxStudentsNumber;
    }

    public StudentGroupForm(String groupNumber, LessonForm formOfStudying, Speciality speciality, Schedule schedule, boolean enabled, String maxStudentsNumber) {
        this.groupNumber = groupNumber;
        this.formOfStudying = formOfStudying;
        this.speciality = speciality;
        this.schedule = schedule;
        this.enabled = enabled;
        this.maxStudentsNumber = maxStudentsNumber;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public LessonForm getFormOfStudying() {
        return formOfStudying;
    }

    public void setFormOfStudying(LessonForm formOfStudying) {
        this.formOfStudying = formOfStudying;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMaxStudentsNumber() {
        return maxStudentsNumber;
    }

    public void setMaxStudentsNumber(String maxStudentsNumber) {
        this.maxStudentsNumber = maxStudentsNumber;
    }



}
