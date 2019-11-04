package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Document
public class Lesson {
    @Id
    private String id;
    private boolean wasHeld;
    private LocalDate date;
    private List<Student> presentStudents;
    private String topic;
    private boolean enabled;
    private Teacher teacher;

    public Lesson() {
    }

    public Lesson(String topic) {
        this.topic = topic;
        this.wasHeld = true;
        this.date = LocalDate.now();
        this.presentStudents = null;
        this.teacher = null;
        this.enabled = true;
    }

    public Lesson(String id, boolean wasHeld, LocalDate date, List<Student> students, Teacher teacher, String topic, boolean enabled) {
        this.id = id;
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = students;
        this.teacher = teacher;
        this.enabled = enabled;
        this.topic = topic;
    }

    public Lesson(boolean wasHeld, LocalDate date, List<Student> students,String topic, Teacher teacher) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = students;
        this.teacher = teacher;
        this.topic = topic;
        this.enabled = true;
    }

    public Lesson(boolean wasHeld, LocalDate date, List<Student> students, Teacher teacher,String topic, boolean enabled) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = students;
        this.teacher = teacher;
        this.topic = topic;
        this.enabled = enabled;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isWasHeld() {
        return wasHeld;
    }

    public void setWasHeld(boolean wasHeld) {
        this.wasHeld = wasHeld;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Student> getPresentStudents() {
        return presentStudents;
    }

    public void setPresentStudents(List<Student> presentStudents) {
        this.presentStudents = presentStudents;
    }

}
